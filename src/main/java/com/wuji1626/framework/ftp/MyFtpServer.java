package com.wuji1626.framework.ftp;

import java.io.File;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;

import com.wuji1626.framework.config.SysConfig;
import com.wuji1626.framework.constant.CommonConstant;

public class MyFtpServer {
    FtpServer server =null;  
    public void initFtp(){  
          FtpServerFactory serverFactory = new FtpServerFactory();  
          ListenerFactory listenerFactory = new ListenerFactory();  
           // replacethedefault listener  
          listenerFactory.setPort(21);  
          serverFactory.addListener("default",listenerFactory.createListener());  
          PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory(); 
          String userFileName = SysConfig.getConfigFromProperties(CommonConstant.FTP_ADMIN_FILE);
          userManagerFactory.setFile(new File(userFileName));  
           //设置盐化hash加密算法  
          //SaltedPasswordEncryptorsalterpassword = new SaltedPasswordEncryptor();  
         //userManagerFactory.setPasswordEncryptor(salterpassword);  
          //设定了用户输入密码时 直接输入明文  
          userManagerFactory.setPasswordEncryptor(new ClearTextPasswordEncryptor());                  
          serverFactory.setUserManager(userManagerFactory.createUserManager());  
          server=serverFactory.createServer();         
    }  
    
    public void start(){               
           try {  
                 server.start();  
                 System.out.println("serverstarting");  
           }catch(FtpException e) {  
                  //TODOAuto-generated catch block  
                 e.printStackTrace();  
           }  
    }  
    public void stop() {  
           server.stop();  
          System.out.println("serveris stopped");  
    }   
}
