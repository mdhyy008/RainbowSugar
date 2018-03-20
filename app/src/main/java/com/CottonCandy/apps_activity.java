package com.CottonCandy;
import android.support.v7.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.support.design.widget.*;
import java.util.*;
import android.content.pm.*;

public class apps_activity extends AppCompatActivity
{
	
	private ListView lv_app_list;
    private AppAdapter mAppAdapter;
    public Handler mHandler = new Handler();
	
	TextView te1;
	ProgressBar pr1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apps);
		setTitle("应用管理");
	
		
		te1 = (TextView)findViewById(R.id.appsTextView1);
		pr1 = (ProgressBar)findViewById(R.id.appsProgressBar1);
	
		lv_app_list = (ListView) findViewById(R.id.appsListView1);
        mAppAdapter = new AppAdapter();
        lv_app_list.setAdapter(mAppAdapter);
        userAppList();
		
		lv_app_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){ 
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id)
				{
				 
				
				} });
		}	
	
		//隐藏进度
		public void pro8(){
			te1.setVisibility(8);
			pr1.setVisibility(8);
			lv_app_list.setVisibility(0);
		}
		//显示进度
		public void pro0(){
			te1.setVisibility(0);
			pr1.setVisibility(0);
			lv_app_list.setVisibility(8);
		}
	
	private void sysAppList(){
		pro0();
		new Thread(){
			@Override
			public void run() {
				super.run();
				//扫描得到APP列表
				final List<MyAppInfo> appInfos = ApkTool.scanLocalInstallAppList(getApplicationContext().getPackageManager(),1);
				mHandler.post(new Runnable() {
						@Override
						public void run() {
							mAppAdapter.setData(appInfos);						
							pro8();				
						}
					});
			}
		}.start();
	}		
		
	private void userAppList(){
		pro0();
		new Thread(){
			@Override
			public void run() {
				super.run();
				//扫描得到APP列表
				final List<MyAppInfo> appInfos = ApkTool.scanLocalInstallAppList(getApplicationContext().getPackageManager(),0);
				mHandler.post(new Runnable() {
						@Override
						public void run() {
							mAppAdapter.setData(appInfos);
							pro8();	
						}
					});
			}
		}.start();
	}	
		
		
	

	class AppAdapter extends BaseAdapter {

        List<MyAppInfo> myAppInfos = new ArrayList<MyAppInfo>();

        public void setData(List<MyAppInfo> myAppInfos) {
            this.myAppInfos = myAppInfos;
            notifyDataSetChanged();
        }

        public List<MyAppInfo> getData() {
            return myAppInfos;
        }

        @Override
        public int getCount() {
            if (myAppInfos != null && myAppInfos.size() > 0) {
                return myAppInfos.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (myAppInfos != null && myAppInfos.size() > 0) {
                return myAppInfos.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder mViewHolder;
            MyAppInfo myAppInfo = myAppInfos.get(position);
            if (convertView == null) {
                mViewHolder = new ViewHolder();
                convertView = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_app_info, null);
                mViewHolder.iv_app_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
                mViewHolder.tx_app_name = (TextView) convertView.findViewById(R.id.iv_app_name);
                
				convertView.setTag(mViewHolder);
            } else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
            mViewHolder.iv_app_icon.setImageDrawable(myAppInfo.getImage());
            mViewHolder.tx_app_name.setText(myAppInfo.getAppName());
            return convertView;
        }

        class ViewHolder {

            ImageView iv_app_icon;
            TextView tx_app_name;
        }
    }
	
	
	


	
		
	//菜单 
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.apps_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.sys:
					snackbar("切换为system应用");
				lv_app_list = (ListView) findViewById(R.id.appsListView1);
				mAppAdapter = new AppAdapter();
				lv_app_list.setAdapter(mAppAdapter);
				sysAppList();
				
				break;
			case R.id.user:
					snackbar("切换为user应用");
				lv_app_list = (ListView) findViewById(R.id.appsListView1);
				mAppAdapter = new AppAdapter();
				lv_app_list.setAdapter(mAppAdapter);
				userAppList();
				
					
				break;		
        }
        return super.onOptionsItemSelected(item);
    }

	
	public void toast(String a){
		Toast.makeText(getApplicationContext(),a,0).show();
	}
	public void snackbar(String a){
		Snackbar.make(getWindow().getDecorView(),a,0).show();
	}	
}
