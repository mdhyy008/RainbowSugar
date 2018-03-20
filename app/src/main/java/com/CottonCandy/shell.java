package com.CottonCandy;

import java.io.*;

public class shell
{
	public final static String COMMAND_SU       = "su";
	public final static String COMMAND_SH       = "sh";
	public final static String COMMAND_EXIT     = "exit\n";
	public final static String COMMAND_LINE_END = "\n";

	public static class CommandResult {
		public int result = -1;
		public String errorMsg;
		public String successMsg;
	}

	
	public static String su(String a){

		Runtime mRuntime = Runtime.getRuntime();
		try {
			Process mProcess = mRuntime.exec(a);
			BufferedReader mReader = new BufferedReader(new InputStreamReader(mProcess.getInputStream()));
			StringBuffer mRespBuff = new StringBuffer();
			char[] buff = new char[1024];
			int ch = 0;
			while((ch = mReader.read(buff)) != -1){
				mRespBuff.append(buff, 0, ch);
			}
			mReader.close();
			return mRespBuff.toString();
		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	
	public static String su1(String command) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		Process proc = runtime.exec(command);
		try {
			if (proc.waitFor() != 0) {
				System.err.println("exit value = " + proc.exitValue());
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(
													   proc.getInputStream()));
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			while ((line = in.readLine()) != null) {
				stringBuffer.append(line);
			}
			return stringBuffer.toString();

		} catch (InterruptedException e) {
			System.err.println(e);
		}
		return null;
	}
	
	
	

	public static CommandResult execCommand(String[] commands, boolean isRoot) {
		CommandResult commandResult = new CommandResult();
		if (commands == null || commands.length == 0) return commandResult;
		DataOutputStream os = null;
		BufferedReader successResult = null;
		BufferedReader errorResult = null;
		StringBuilder successMsg = null;
		StringBuilder errorMsg = null;
		try {
			java.lang.Process process = Runtime.getRuntime().exec(isRoot ? COMMAND_SU : COMMAND_SH);
			os = new DataOutputStream(process.getOutputStream());
			for (String command : commands)
			{
				if (command != null) {
					os.write(command.getBytes());
					os.writeBytes(COMMAND_LINE_END);
					os.flush();
				}
			}
			os.writeBytes(COMMAND_EXIT);
			os.flush();
			commandResult.result = process.waitFor();
			//获取错误信息
			successMsg = new StringBuilder();
			errorMsg = new StringBuilder();
			successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
			errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String s;
			while ((s = successResult.readLine()) != null) successMsg.append(s);
			while ((s = errorResult.readLine()) != null) errorMsg.append(s);
			commandResult.successMsg = successMsg.toString();
			commandResult.errorMsg = errorMsg.toString();

		} catch (IOException e) {
			String errmsg = e.getMessage();
			if (errmsg != null) {

			} else {
				e.printStackTrace();
			}
		} catch (Exception e) {
			String errmsg = e.getMessage();
			if (errmsg != null) {

			} else {
				e.printStackTrace();
			}
		} finally {
			try {
				if (os != null) os.close();
				if (successResult != null) successResult.close();
				if (errorResult != null) errorResult.close();
			} catch (IOException e) {
				String errmsg = e.getMessage();
				if (errmsg != null) {

				} else {
					e.printStackTrace();
				}
			}		

		}
		return commandResult;
	}


}
