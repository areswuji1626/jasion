package com.wuji1626.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Utils {

	@SuppressWarnings("resource")
	public static String readXML2Str(String absoluteFileName){
		
		StringBuffer str=new StringBuffer("");
		File file=new File(absoluteFileName);
		InputStreamReader read;
		try {
			read = new InputStreamReader (new FileInputStream(file),"UTF-8");
			BufferedReader reader=new BufferedReader(read);

			String line = "";
			while ((line = reader.readLine()) != null) {
				str.append(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str.toString();
	}
	public static String getHostIPAddress(){
		InetAddress ia=null;
		try {
			ia=InetAddress.getLocalHost();
			String localip=ia.getHostAddress();
			return localip;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}
}
