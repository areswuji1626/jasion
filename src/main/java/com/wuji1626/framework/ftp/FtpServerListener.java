package com.wuji1626.framework.ftp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FtpServerListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());   
        MyFtpServer server=(MyFtpServer)ctx.getServletContext().getAttribute("FTPSERVER_CONTEXT_NAME");  
        server.stop();  
        sce.getServletContext().removeAttribute("FTPSERVER_CONTEXT_NAME");  
        System.out.println("Stopping FtpServer");  
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Starting FtpServer");   
	    WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());   
	    MyFtpServer server=(MyFtpServer) ctx.getBean("NeusoftFTP");  
	   sce.getServletContext().setAttribute("FTPSERVER_CONTEXT_NAME",server);   
	    try {           
	           server.initFtp();  
	           server.start();  
	    System.out.println("FtpServer started");   
	    } catch (Exception e){   
	      throw new RuntimeException("Failed to start FtpServer", e);   
	    }   
	}

}
