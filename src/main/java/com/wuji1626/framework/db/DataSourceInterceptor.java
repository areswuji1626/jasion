package com.wuji1626.framework.db;
import org.aspectj.lang.JoinPoint; 
import org.springframework.stereotype.Component;

@Component  
public class DataSourceInterceptor implements DynamicDataSourceAble{

	public void setDatasourcePlat(JoinPoint jp){
		DatabaseContextHolder.setDBType(DATA_SOURCE_1);  
	}
	
	public void setDatasourcePreObj(JoinPoint jp){
		DatabaseContextHolder.setDBType(DATA_SOURCE_2);  
	}
	
	public void setDatasourcePlatSupport(JoinPoint jp){
		DatabaseContextHolder.setDBType(DATA_SOURCE_3);  
	}
	
	public void setDatasourceObjDispute(JoinPoint jp){
		DatabaseContextHolder.setDBType(DATA_SOURCE_4); 
	}
	
	public void setDatasourceJoinDatabase(JoinPoint jp){
		DatabaseContextHolder.setDBType(DATA_SOURCE_5); 
	}
}
