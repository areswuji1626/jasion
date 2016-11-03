package com.wuji1626.framework.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SysConfig {

	private static Properties prop = new Properties();    
	
	static{
        try  {
           // 解决Properties中中文问题
           InputStream inputStream = SysConfig.class.getClassLoader().getResourceAsStream("config.properties");
           BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream,"utf-8")); 
           prop.load(bf);    
           inputStream.close();
       }  catch  (IOException e) {    
           e.printStackTrace();    
       }    

	}
	public static String getConfigFromProperties(String key){
		return prop.getProperty(key).trim();
	}
}
