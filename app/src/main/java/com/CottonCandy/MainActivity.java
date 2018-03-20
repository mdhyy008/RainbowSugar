package com.CottonCandy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.*;
import android.widget.*;
import java.util.*;
import android.widget.AdapterView.*;
import android.app.*;
import android.view.*;
import android.support.v4.view.*;
import android.os.*;
import android.content.*;
import android.icu.text.*;
import android.net.*;
import java.io.*;
import android.util.*;
import android.widget.PopupMenu.*;
import org.apache.http.util.*;
import android.content.res.*;
import java.lang.reflect.*;
import android.provider.*;
import android.graphics.*;
import android.content.pm.*;
import android.support.v4.content.*;
import android.support.v4.app.*;
import android.support.annotation.*;
import android.Manifest;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import static de.robv.android.xposed.XposedBridge.log;
import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;


public class MainActivity extends AppCompatActivity implements OnClickListener, OnMenuItemClickListener
{
	//UI声明
	TextView right_reb;
	TextView left_log;
	TextView left_model;
	TextView right_shell;
	EditText p_value;
	
	private PopupMenu RebootMenu;
	private PopupMenu ModelMenu;
	
	//文本操作
	EditText w_ed1,w_ed2,w_ed3,w_ed4;
	Button w_bt1;
	
	EditText u_ed1,u_ed2,u_ed3;
	Button u_bt1,u_bt2;
	
	//变量
	private Context mContext;
	double pro;
	
	shell root;

	String a,b,c,d,e,f;
	String prop;
	String oldProp,newProp;
	String a1,b1,c1,d1,e1,f1;;
	
// 要申请的权限
    public String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
		Manifest.permission.READ_PHONE_STATE,
	};
	private AlertDialog dialog;
	private ProgressDialog thss;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
		mContext = this;
		
		if(Build.VERSION.SDK_INT>=21){
			getSupportActionBar().setElevation(0);
		}
		
		//实例化
		right_reb=(TextView)findViewById(R.id.reb);
		left_log=(TextView)findViewById(R.id.mainlog);
		left_model=(TextView)findViewById(R.id.mode);
		right_shell=(TextView)findViewById(R.id.shell);
		root = new shell();	
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 检查该权限是否已经获取
            int i = ContextCompat.checkSelfPermission(this, permissions[0]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (i != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求
                startRequestPermission();
            }
			else{
			}
	
	}}
	   
	
	 public void sbxx(View view){
		 Intent act =new Intent(MainActivity.this,build_activity.class);
		 startActivity(act);
	 }
	 
	 
	 public void bdst(View view){
		 Intent a = new Intent(Intent.ACTION_VIEW);
		 a.setData(Uri.parse("http://shitu.baidu.com"));
		 startActivity(a);
	 }
	 
	public void apps(View view){
		snackbar("出了小差错..正在努力修复bug");
		}
	 
	 
	 public void dhsdtk(View view){
		 
		 final SeekBar speed = new SeekBar(this); 
		 
		 AlertDialog.Builder dh =  new AlertDialog.Builder(this);
		 dh.setTitle("系统动画速度");
		 dh.setView(speed);
		 dh.setPositiveButton("确认更改",
			 new DialogInterface.OnClickListener() {
				 @Override
				 public void onClick(DialogInterface dialogInterface, int i) {
						
					 String cmd[]={"settings put global window_animation_scale "+pro,
						 "settings put global animator_duration_scale "+pro,
						 "settings put global transition_animation_scale "+pro};
					new shell().execCommand(cmd,true); 	
					toast("Command execution");
				}
			 });
		 dh.setNeutralButton("取消", null);
		 dh.show();
		 
		 speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				 /*
				  * seekbar改变时的事件监听处理
				  * */
				 @Override
				 public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
					 pro = progress;
					 pro = pro/50;
				 }
				 /*
				  * 按住seekbar时的事件监听处理
				  * */
				 @Override
				 public void onStartTrackingTouch(SeekBar seekBar) {
					  }
				 /*
				  * 放开seekbar时的时间监听处理
				  * */
				 @Override
				 public void onStopTrackingTouch(SeekBar seekBar) {
				 toast("确定更改为"+pro+"倍");			 
				 }
			 });	 
		 
		 
	 }
	 
	 
	 public void dellog(View view){
		snackbar("Deleting...");
		 new Thread() {
			 @Override
			 public void run() {
				 super.run();
				 //新线程操作
				 new shell().su("logcat -c");
				 
				 runOnUiThread(new Runnable(){
						 @Override
						 public void run() {
							 //更新UI操作
							 snackbar("擦除成功");
						 }
					 });
			 }
		 }.start();	 
		 
	 }
	 
	 public void jxxg(View view){ 
		 ModelMenu = new PopupMenu(this,left_model);
		 ModelMenu.inflate(R.menu.model_menu);
		 ModelMenu.setOnMenuItemClickListener(this);
		 ModelMenu.show();
		 
		 
		 
		 
	 }
	 
	 
	 public void oppo11(){
		 String cmd[]={"mount -o remount,rw /system","busybox mount -o remount,rw /system","chmod 777 /system/build.prop","cp /system/build.prop /sdcard/build.prop","cp /system/build.prop /system/build.prop.bak"};
		 new shell().execCommand(cmd,true);
		 new Thread() {
			 @Override
			 public void run() {
				 super.run();
				 //新线程操作

				 try{
					 a = root.su1("getprop ro.product.model");
					 b = root.su1("getprop ro.product.brand");
					 c = root.su1("getprop ro.product.name");
					 d = root.su1("getprop ro.product.device");
					 e = root.su1("getprop ro.product.manufacturer");
					 f = root.su1("getprop ro.build.product");

				 }catch(Exception e){}

				 runOnUiThread(new Runnable(){
						 @Override
						 public void run() {
							 //更新UI操作
							 String oldProp = readFileSdcardFile("/sdcard/build.prop");
							 a1 = oldProp.replace(a,"oppo R11");
							 b1 = a1.replace(b,"oppo");
							 c1 = b1.replace(c,"R11");
							 d1 = c1.replace(d,"R11");
							 e1 = d1.replace(e,"oppo");
							 f1 = e1.replace(f,"R11");

							 String newProp = f1;
							 saveSdFile("build.prop",newProp);
							 
							 String copy[]={"mount -o remount,rw /system","busybox mount -o remount,rw /system","chmod 777 /system/build.prop","cp /sdcard/build.prop /system/build.prop"};
							 new shell().execCommand(copy,true);
						 }

					 });
			 }
		 }.start(); 	 
	 }
	  
	public void oppo15(){
		String cmd[]={"mount -o remount,rw /system","busybox mount -o remount,rw /system","chmod 777 /system/build.prop","cp /system/build.prop /sdcard/build.prop","cp /system/build.prop /system/build.prop.bak"};
		new shell().execCommand(cmd,true);
		new Thread() {
			@Override
			public void run() {
				super.run();
				//新线程操作

				try{
					a = root.su1("getprop ro.product.model");
					b = root.su1("getprop ro.product.brand");
					c = root.su1("getprop ro.product.name");
					d = root.su1("getprop ro.product.device");
					e = root.su1("getprop ro.product.manufacturer");
					f = root.su1("getprop ro.build.product");

				}catch(Exception e){}

				runOnUiThread(new Runnable(){
						@Override
						public void run() {
							//更新UI操作
							String oldProp = readFileSdcardFile("/sdcard/build.prop");
							a1 = oldProp.replace(a,"oppo R15");
							b1 = a1.replace(b,"oppo");
							c1 = b1.replace(c,"R15");
							d1 = c1.replace(d,"R15");
							e1 = d1.replace(e,"oppo");
							f1 = e1.replace(f,"R15");

							String newProp = f1;
							saveSdFile("build.prop",newProp);
							String copy[]={"mount -o remount,rw /system","busybox mount -o remount,rw /system","chmod 777 /system/build.prop","cp /sdcard/build.prop /system/build.prop"};
							new shell().execCommand(copy,true);
						}
					});
			}
		}.start(); 

	}
	 
	public void vivo(){
		String cmd[]={"mount -o remount,rw /system","busybox mount -o remount,rw /system","chmod 777 /system/build.prop","cp /system/build.prop /sdcard/build.prop","cp /system/build.prop /system/build.prop.bak"};
		new shell().execCommand(cmd,true);
		new Thread() {
			@Override
			public void run() {
				super.run();
				//新线程操作

				try{
					a = root.su1("getprop ro.product.model");
					b = root.su1("getprop ro.product.brand");
					c = root.su1("getprop ro.product.name");
					d = root.su1("getprop ro.product.device");
					e = root.su1("getprop ro.product.manufacturer");
					f = root.su1("getprop ro.build.product");

				}catch(Exception e){}

				runOnUiThread(new Runnable(){
						@Override
						public void run() {
							//更新UI操作
							String oldProp = readFileSdcardFile("/sdcard/build.prop");
							a1 = oldProp.replace(a,"vivo X20");
							b1 = a1.replace(b,"vivo");
							c1 = b1.replace(c,"X20");
							d1 = c1.replace(d,"X20");
							e1 = d1.replace(e,"vivo");
							f1 = e1.replace(f,"X20");

							String newProp = f1;
							saveSdFile("build.prop",newProp);
							String copy[]={"mount -o remount,rw /system","busybox mount -o remount,rw /system","chmod 777 /system/build.prop","cp /sdcard/build.prop /system/build.prop"};
							new shell().execCommand(copy,true);
							
						}

					});
			}
		}.start(); 

	}
	
	 
	public void recover(){
		
		new AlertDialog.Builder(this)
			.setTitle("恢复机型")
			.setMessage("如果你上一次修改机型是用的本软件,那么你可以用本功能恢复\n如果你是用其他APP改的机型,可能本操作会无效")
			.setPositiveButton("确认恢复",
			new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					String cmd[]={"mount -o remount,rw /system","busybox mount -o remount,rw /system","chmod 777 /system/build.prop","chmod 777 /system/build.prop.bak","cp /system/build.prop.bak /system/build.prop","chmod 644 /system/build.prop"};
					new shell().execCommand(cmd,true);
				}
			}) 
			.setNeutralButton("取消", null)
			.show();
								
	}
	
	
	public void sxwl(View view){
		//调用Shell
		snackbar("调用Shell刷新网络中...");
		new Thread() {
			@Override
			public void run() {
				super.run();
				//新线程操作
				String cmd[]={"svc data disable",
					"svc wifi disable",
					"svc data enable",
					"svc wifi enable"};
				new shell().execCommand(cmd,true);
				runOnUiThread(new Runnable(){
						@Override
						public void run() {
							//更新UI操作
							snackbar("刷新完成.");
						}
					});
			}
		}.start();
		
		
		
	}

	 public void shell(View view){
	
		 if(isMobile_spExist("com.xiaochen.shell")){
				Intent Intent = new Intent();
				Intent.setClassName("com.xiaochen.shell", "com.xiaochen.shell.MainActivity");
				startActivity(Intent);
                }
			else{
				Snackbar.make(getWindow().getDecorView(),"你还没有安装Shell插件", Snackbar.LENGTH_LONG).setAction("点击安装", new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							
							AssetManager assets = getAssets();
							try
							{
								
								InputStream stream = assets.open("shell.apk");
								if(stream==null)
								{
									
									return;
								}

								String folder = "/mnt/sdcard/";
								File f=new File(folder);
								if(!f.exists())
								{
									f.mkdir();
								}
								String apkPath = "/mnt/sdcard/shell.apk";
								File file = new File(apkPath);
								//创建apk文件
								file.createNewFile();
								writeStreamToFile(stream, file);
								
								String fileName = "/storage/emulated/0/shell.apk" ; 
								Intent intent = new Intent(); 
								intent.setDataAndType(Uri.fromFile(new File(fileName)), "application/vnd.android.package-archive"); 
								startActivity(intent);
								toast("选择软件安装程序！");
							}
							catch (IOException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}		
						}				
					}
						).show();}}
			 
	 
	public void xp_1(View view){
		snackbar("功能正在了..."); 
	}
	 
	public void xp_2(View view){
		snackbar("功能正在了..."); 
	}
	
	public static boolean appIsInstalled(Context context,String activitypath){
		final PackageManager packageManager = context.getPackageManager();
		List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(new Intent(activitypath), PackageManager.GET_ACTIVITIES);
		if (resolveInfo!=null && !resolveInfo.isEmpty()) {
			return true;
		}
		return false;

	}
	 
	 public void selinux(View view){
		 String meg = "  SELinux(Security-Enhanced Linux) 是美国国家安全局「NSA=The National Security Agency」 和SCC（Secure Computing Corporation）开发的 Linux的一个扩张强制访问控制(MAC)安全模块，是 Linux® 上最杰出的新安全子系统。NSA是在Linux社区的帮助下开发了一种访问控制体系，在这种访问控制体系的限制下，进程只能访问那些在他的任务中所需要文件。";
		 new AlertDialog.Builder(this)
		 .setTitle("SELinux控制")
		 .setMessage(meg)
		 .setPositiveButton("开启",
			 new DialogInterface.OnClickListener() {
				 @Override
				 public void onClick(DialogInterface dialogInterface, int i) {
					 String cmd[]={"setenforce 1"};
					 new shell().execCommand(cmd,true);
					 toast("Command execution");
				 }
			 })  
			 .setNeutralButton("关闭",new DialogInterface.OnClickListener() {
				 @Override
				 public void onClick(DialogInterface dialogInterface, int i) {
					 String cmd[]={"setenforce 0"};
					 new shell().execCommand(cmd,true);
					 toast("Command execution");
				 }
			 })
		 .show();
		 
	 }
	 
	 
	public void doze(View view){
		String meg = "Doze模式是Android6.0上新出的一种模式，是一种全新的、低能耗的状态，在后台只有部分任务允许运行，其他都被强制停止。当用户一段时间没有使用手机的时候，Doze模式通过延缓app后台的CPU和网络活动减少电量的消耗。PowerManagerService中也有Doze模式，和此处的Doze模式不一样，其实此处叫Device Idle模式更容易区分";
		new AlertDialog.Builder(this)
			.setTitle("Doze控制")
			.setMessage(meg)
			.setPositiveButton("开启",
			new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					String cmd[]={"dumpsys deviceidle force-idle"};
					new shell().execCommand(cmd,true);
					snackbar("Command execution");
				}
			})  
			.setNeutralButton("关闭",new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					String cmd[]={"dumpsys deviceidle step"};
					new shell().execCommand(cmd,true);
					snackbar("Command execution");
				}
			})
			.show();

	}
	
	//电池操作
	public void power(View view){
		LayoutInflater infl = LayoutInflater.from(mContext);
		View vie = infl.inflate(R.layout.power, null);
		new AlertDialog.Builder(this)
			.setView(vie)
			.show();

		p_value = (EditText)vie.findViewById(R.id.powerEditText1);	
	}
	
	//电池方法类
	public void p_xg(View view){
		String cmd[]={"dumpsys battery set level "+p_value.getText().toString()};
		new shell().execCommand(cmd,true);
		toast("重启后自动恢复");
	}
	
	
	public void p_on(View view){
		String cmd[]={"dumpsys battery set status 2"};
		new shell().execCommand(cmd,true);
	}
	public void p_off(View view){
		
		String cmd[]={"dumpsys battery set status 1"};
		new shell().execCommand(cmd,true);
		}
	
	
	

	public void led(View view){
		
		new AlertDialog.Builder(this)
			.setMessage("物理键LED灯光")
			.setPositiveButton("关灯",
			new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					String cmd[]={"echo 0 > /sys/class/leds/button-backlight/brightness"
						,"echo 0 > /sys/class/leds/button-backlight1/brightness"};
					new shell().execCommand(cmd,true);
					snackbar("关灯！");
				}
			}) 
			.setNeutralButton("开灯", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					String cmd[]={"echo 1 > /sys/class/leds/button-backlight/brightness"
						,"echo 1 > /sys/class/leds/button-backlight1/brightness"};
					new shell().execCommand(cmd,true);
					snackbar("开灯！");
				}
			})
			.show();
		
	}
	
	public void ui(View view){
		LayoutInflater infl = LayoutInflater.from(mContext);
		View vie = infl.inflate(R.layout.ui, null);
		
		new AlertDialog.Builder(this)
			.setTitle("UI修改")
			.setView(vie)
			.setPositiveButton("完成",null)
			.show();
		
		u_ed1 = (EditText)vie.findViewById(R.id.uiEditText1);
		u_ed2 = (EditText)vie.findViewById(R.id.uiEditText2);
		u_ed3 = (EditText)vie.findViewById(R.id.uiEditText3);
		
		WindowManager windowManager = getWindowManager();  
        Display display = windowManager.getDefaultDisplay();  
        int screenWidth = screenWidth = display.getWidth();  
        int screenHeight = screenHeight = display.getHeight();  
		
		u_ed2.setHint(""+screenWidth);
		u_ed3.setHint(""+screenHeight);
		
		DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        int height = metric.heightPixels;  // 屏幕高度（像素）
        float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
		
		u_ed1.setHint(""+densityDpi);
		
	}
	
	
	public void xg1(View view){
		String num = u_ed1.getText().toString();
		String cmd[]={"wm density "+num};
		new shell().execCommand(cmd,true);
		snackbar("修改完毕");
		
	}
	public void xg2(View view){
		String num1 = u_ed2.getText().toString();
		String num2 = u_ed3.getText().toString();
		String cmd[]={"wm size "+num1+"x"+num2};
		new shell().execCommand(cmd,true);	
		snackbar("命令完成");
	}

	public void dckms(View view){
		new AlertDialog.Builder(this)
			.setTitle("多窗口模式")
			.setMessage("Android 8.0新增画中画模式,小伙伴们可以试一下,会重启哦")
			.setPositiveButton("开启多窗口模式",
			new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					String cmd[]={"settings put global enable_freeform_support 1","reboot"};
					new shell().execCommand(cmd,true);
				}
			}) 
			.setNeutralButton("关闭多窗口模式", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					String cmd[]={"settings put global enable_freeform_support 0","reboot"};
					new shell().execCommand(cmd,true);
					
				}
			})
			.show();
	}
	
	public void thss(View view){
		thss = ProgressDialog.show(this, "正在运行叹号の杀手", "叹号杀手 . 去掉WiFi旁边的叹号(多半是原生系统的问题)");
		new Thread() {
			@Override
			public void run() {
				super.run();
				//新线程操作
				String cmd[]={"settings delete global captive_portal_server",
					"settings delete global captive_portal_https_url",
					"settings delete global captive_portal_http_url",
					"settings delete global captive_portal_use_https",
					"settings put global captive_portal_use_https 1",
					"settings put global captive_portal_https_url https://www.qualcomm.cn/generate_204"
				};
				new shell().execCommand(cmd,true);
				try
				{
					Thread.sleep(2000);
				}
				catch (InterruptedException e)
				{}
				runOnUiThread(new Runnable(){
						@Override
						public void run() {
							//更新UI操作
						thss.dismiss();
						snackbar("重启下WiFi看看吧");					
						}
					});
			}
		}.start();
		
		
	}
	
	
	
	public void dhlkg(View view){
	 if(isNavigationBar(this)){
		new AlertDialog.Builder(this)
			.setTitle("原生导航栏工具")
			.setMessage("导航栏已经开启")
			.setPositiveButton("立即开启",
			new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					//开启按钮
					String oncmds[] = {"mount -o rw,remount /system","sed -i '/qemu/d' /system/build.prop","echo qemu.hw.mainkeys=0 >> /system/build.prop"};
					new shell().execCommand(oncmds,true);
				}
			}) 
			.setNeutralButton("立即关闭", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					//关闭按钮
					String offcmds[] = {"mount -o rw,remount /system","sed -i '/qemu/d' /system/build.prop","echo qemu.hw.mainkeys=1 >> /system/build.prop"};
					new shell().execCommand(offcmds,true);
				}
			})
			.show();
			}else{
			
				new AlertDialog.Builder(this)
					.setTitle("原生导航栏工具")
					.setMessage("导航栏没有开启")
					.setPositiveButton("立即开启",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							//开启按钮
							String oncmds[] = {"mount -o rw,remount /system","sed -i '/qemu/d' /system/build.prop","echo qemu.hw.mainkeys=0 >> /system/build.prop"};
							new shell().execCommand(oncmds,true);
						}
					}) 
					.setNeutralButton("立即关闭", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							//关闭按钮
							String offcmds[] = {"mount -o rw,remount /system","sed -i '/qemu/d' /system/build.prop","echo qemu.hw.mainkeys=1 >> /system/build.prop"};
							new shell().execCommand(offcmds,true);
						}
					})
					.show();		
			}
	}
	
	
	
	
	
	
	public void gjcq(View view){
		
		RebootMenu = new PopupMenu(this,right_reb);
		RebootMenu.inflate(R.menu.reboot_menu);
		RebootMenu.setOnMenuItemClickListener(this);
		RebootMenu.show();
		
	}
	
	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
	}

	@Override
	public boolean onMenuItemClick(MenuItem item)
	{
		int id = item.getItemId();
		switch(id){
			case R.id.cq:
				String cq[]={"reboot"};
				new shell().execCommand(cq,true);
				break;
			case R.id.gj:
				String gj[]={"reboot -p"};
				new shell().execCommand(gj,true);
				break;
			case R.id.rec:
				String rec[]={"reboot recovery"};
				new shell().execCommand(rec,true);
				break;
			case R.id.fast:
				String fast[]={"reboot fastboot"};
				new shell().execCommand(fast,true);
				break;
			case R.id.ui:
				String ui[]={"killall com.android.systemui","busybox killall com.android.systemui"};
				new shell().execCommand(ui,true);
				break;	
			case R.id.vivo:
				Snackbar.make(getWindow().getDecorView(),"确定要修改机型为vivo x20嘛", Snackbar.LENGTH_LONG).setAction("确定修改", new View.OnClickListener() {
						@Override
						public void onClick(View v) {
						vivo();
						}
					}).show();	
				break;
			case R.id.oppo11:
				Snackbar.make(getWindow().getDecorView(),"确定要修改机型为oppo R11嘛", Snackbar.LENGTH_LONG).setAction("确定修改", new View.OnClickListener() {
						@Override
						public void onClick(View v) {
						oppo11();
						}
					}).show();
				break;
			case R.id.oppo15:
				Snackbar.make(getWindow().getDecorView(),"确定要修改机型为oppo R15嘛", Snackbar.LENGTH_LONG).setAction("确定修改", new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							oppo15();
						}
					}).show();
				break;
				
			case R.id.recover:
				recover();
				break;
						
		}
		return false;
	}
	
	
	public void wbcz(View view){
		LayoutInflater infl = LayoutInflater.from(mContext);
		View vie = infl.inflate(R.layout.dxxzh, null);
		AlertDialog.Builder bu = new AlertDialog.Builder(mContext);
		bu.setView(vie).setPositiveButton(android.R.string.copy, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
						clip(w_ed4.getText().toString());	
				}
			}).create().show();
		w_ed1 = (EditText)vie.findViewById(R.id.dxxzhEditText1);
		w_ed2 = (EditText)vie.findViewById(R.id.dxxzhEditText2);
		w_ed3 = (EditText)vie.findViewById(R.id.dxxzhEditText3);
		w_ed4 = (EditText)vie.findViewById(R.id.dxxzhEditText4);
		w_bt1 = (Button)vie.findViewById(R.id.dxxzhButton1);
	}
	
	public void th(View view){
		String a=w_ed1.getText().toString();
		String b=a.replace(w_ed2.getText().toString(),w_ed3.getText().toString());
		w_ed4.setText(b);
	}

	//工具
	
	
	
	
	// 开始提交请求权限
    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 321);
    }

    // 用户权限 申请 的回调方法
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 321) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // 判断用户是否 点击了不再提醒。(检测该权限是否还可以申请)
                    boolean b = shouldShowRequestPermissionRationale(permissions[0]);
                    if (!b) {
                        // 用户还是想用我的 APP 的
                        // 提示用户去应用设置界面手动开启权限
                        showDialogTipUserGoToAppSettting();
                    } else
                        finish();
                } else {
                    Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }



    // 提示用户去应用设置界面手动开启权限

    private void showDialogTipUserGoToAppSettting() {

        dialog = new AlertDialog.Builder(this)
			.setTitle("存储权限不可用")
			.setMessage("请在-应用设置-权限-中，允许使用存储权限来保存数据")
			.setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// 跳转到应用设置界面
					goToAppSetting();
				}
			})
			.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			}).setCancelable(false).show();
    }



    // 跳转到当前应用的设置界面
    private void goToAppSetting() {
        Intent intent = new Intent();

        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);

        startActivityForResult(intent, 123);
    }

    //回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // 检查该权限是否已经获取
                int i = ContextCompat.checkSelfPermission(this, permissions[0]);
                // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
                if (i != PackageManager.PERMISSION_GRANTED) {
                    // 提示用户应该去应用设置界面手动开启权限
                    showDialogTipUserGoToAppSettting();
                } else {

                    if (dialog != null && dialog.isShowing()) {

                        dialog.dismiss();
                    }
                   	Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show();



				}
            }
        }
    }


	
	
	
	
	
	private void writeStreamToFile(InputStream stream, File file)
	{
		try
		{
			//
			OutputStream output = null;
			try
			{
				output = new FileOutputStream(file);
			}
			catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try
			{
				try
				{
					final byte[] buffer = new byte[1024];
					int read;

					while ((read = stream.read(buffer)) != -1)
						output.write(buffer, 0, read);

					output.flush();
				}
				finally
				{
					output.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		finally
		{
			try
			{
				stream.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void installApk(String apkPath)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setDataAndType(Uri.fromFile(new File(apkPath)),
							  "application/vnd.android.package-archive");
		startActivity(intent);
	}
	
	
	
	
	public boolean isMobile_spExist(String pack) {
        PackageManager manager = this.getPackageManager();
        List<PackageInfo> pkgList = manager.getInstalledPackages(0);
        for (int i = 0; i < pkgList.size(); i++) {
            PackageInfo pI = pkgList.get(i);
            if (pI.packageName.equalsIgnoreCase(pack))
                return true;
        }
        return false;
    }
	
	
	//检测导航栏操作
	public static boolean isNavigationBar(Context context)
	{
		boolean hasNavigationBar = false;
		Resources rs = context.getResources();
		int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
		if (id > 0)
		{
			hasNavigationBar = rs.getBoolean(id);
		}
		try
		{
			Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
			Method m = systemPropertiesClass.getMethod("get", String.class);
			String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
			if ("1".equals(navBarOverride))
			{
				hasNavigationBar = false;
			}
			else if ("0".equals(navBarOverride))
			{
				hasNavigationBar = true;
			}
		}
		catch (Exception e)
		{

		}
		return hasNavigationBar;
	}
	
	//读
	private String readFileSdcardFile(String fileName){ 
		String res=""; 
		try{ 
			FileInputStream fin = new FileInputStream(fileName);
			int length = fin.available(); 
			byte [] buffer = new byte[length]; 
			fin.read(buffer);     
			res = EncodingUtils.getString(buffer, "UTF-8"); 
			fin.close();     
		} 
		catch(Exception e){ 
			e.printStackTrace(); 
		} 
		return res; 
    }

	//写	
	public void saveSdFile(String filename,String text)
	{
	if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){	
		try{
		File sdCardDir = Environment.getExternalStorageDirectory();//获取SDCard目录
		File saveFile = new File(sdCardDir,filename);
		FileOutputStream outStream = new FileOutputStream(saveFile);
		outStream.write(text.getBytes());
		outStream.close();
		}catch(IOException ioe){
		}
		}
	}

	
	public void clip(String a){
		ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(a);
        snackbar("复制成功");
		
	}
	 public void toast(String a){
		 Toast.makeText(getApplicationContext(),a,0).show();
	 }
	 public void snackbar(String a){
		Snackbar.make(getWindow().getDecorView(),a,0).show();
	 }
	 
}
