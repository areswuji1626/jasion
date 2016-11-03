package com.wuji1626.framework.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import com.wuji1626.framework.constant.CommonConstant;
import com.wuji1626.framework.domain.JobInfo;

public class JobConfig {
	
	private static Properties prop = new Properties();    
	
	static{
        try  {
           // 解决Properties中中文问题
           InputStream inputStream = SysConfig.class.getClassLoader().getResourceAsStream("jobConfig.properties");
           BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream,"utf-8")); 
           prop.load(bf);    
           inputStream.close();
       }  catch  (IOException e) {    
           e.printStackTrace();    
       }    

	}
	public static List<JobInfo> getJobListFromProperties(){
		Enumeration<Object> e = prop.keys();
		List<Object> keyObjs = Collections.list(e);
		List<JobInfo> jobInfos = new ArrayList<JobInfo>();
		
		for(Object keyObj:keyObjs){
			JobInfo jobInfo = new JobInfo();
			String jobStr = prop.getProperty(keyObj.toString());
			String[] jobDetail = jobStr.split(SysConfig.getConfigFromProperties(CommonConstant.SEPARATOR),4);
			if(jobDetail.length != 4){
				System.out.println("jobConfig " +keyObjs.indexOf(keyObj)+1 + " line error!");
				continue;
			}
			jobInfo.setJobKey(jobDetail[0]);
			jobInfo.setJobName(jobDetail[1]);
			jobInfo.setJobClassStr(jobDetail[2]);
			jobInfo.setJobCron(jobDetail[3]);
			jobInfos.add(jobInfo);
			
		}
		
		return jobInfos;
	}
}
