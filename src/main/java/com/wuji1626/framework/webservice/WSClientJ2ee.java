/**                                
 * Copyright ® 2015 东软集团 政府第三事业部
 * 版权所有。     
 */ 
package com.wuji1626.framework.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.log4j.Logger;

import com.wuji1626.framework.utils.HttpRequestUtil;

public class WSClientJ2ee {
    
    private static final Logger log = Logger.getLogger(WSClientJ2ee.class);
    
    /*输入参数*/
	private Object[] input = null;
	/*调用url*/
	private String wsUrl ="";
	/*调用方法名 */
	private String method ="";
	/*返回错误信息*/
	private String errMsg="";
	
	/**
	 * 
	 * <p>Method ：getCallWSResponse
	 * <p>Description : 利用cxf框架调用java编写的webservice 的工具类方法
	 *
	 * @return 
	 * @author  金春艳-jincy@neusoft.com
	 */
	public Object[] getCallWSResponse(){
	    
	     if(HttpRequestUtil.getUrlStatus(this.wsUrl).equals("404")){
	         log.error("retcode=" + HttpRequestUtil.getUrlStatus(this.wsUrl));
	         log.error("webservice 访问异常，请检查webservice=" + this.wsUrl +"是否正常");
	         return null;
	     }
	     
		 Object[] res = null;    
		 JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		 try {    
			Client client = dcf.createClient(this.wsUrl);
			//设置超时单位为毫秒
	        HTTPConduit http = (HTTPConduit) client.getConduit();      
	        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();      
	        httpClientPolicy.setConnectionTimeout(3000);//连接超时    
	        httpClientPolicy.setAllowChunking(false);   //取消块编码 
	        httpClientPolicy.setReceiveTimeout(3000);   //响应超时
	        http.setClient(httpClientPolicy);
	        log.info("调用webservice:" + this.wsUrl +",参数为：" + (String)input[0]);
			res = client.invoke(this.method,this.input); 
		 } catch (Exception e) {
			 log.error("调用webservice("+this.wsUrl +")的方法("+this.method+")出现错误:");
			 log.error("输入参数为：" + this.input);
			 log.error("错误详细信息为：" + e.getMessage(),e);
			 this.setErrMsg(e.getMessage());
		 }
		 return res;
	}

	public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object[] getInput() {
        return input;
    }

    public void setInput(Object[] input) {
        this.input = input;
    }
    
    public String getWsUrl() {
        return wsUrl;
    }

    public void setWsUrl(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
