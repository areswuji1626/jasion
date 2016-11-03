/**                                
 * Copyright ?? 2015 东软集团 政府第三事业部
 * 版权所有。     
 */ 

package com.wuji1626.framework.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 
 * <p>Class       : com.neusoft.mh.common.util.HttpRequestUtil
 * <p>Descdription: java模拟get/post请求
 *
 * @author  金春艳-jincy@neusoft.com
 * @version 1.0.0
 *<p>
 *--------------------------------------------------------------<br>
 * 修改履历：<br>
 *        <li> 2015-6-9，libing。neu@neusoft.com，创建文件；<br>
 *--------------------------------------------------------------<br>
 *</p>
 */
public class HttpRequestUtil {
    
    /**
     * 
     * <p>Method ：sendGet
     * <p>Description : 模拟get方法获取http返回
     *
     * @param url  指定url
     * @param param  参数串
     * @return 
     * @author  金春艳-jincy@neusoft.com
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url ;
            URL realUrl = new URL(urlNameString);
            /*打开和URL之间的连接*/
            URLConnection connection = realUrl.openConnection();
            /*设置通用的请求属性*/
            connection.setRequestProperty("Authorization",param);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            /*建立实际的连接*/
            connection.connect();
            /*获取所有响应头字段*/
            Map<String, List<String>> map = connection.getHeaderFields();
            /*定义 BufferedReader输入流来读取URL的响应*/
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8")); 
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*使用finally块来关闭输入流*/
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    /**
     * 
     * <p>Method ：sendPost
     * <p>Description : 模拟post方法获取http返回
     *
     * @param url  指定url 
     * @param param  参数串
     * @return 
     * @author  金春艳-jincy@neusoft.com
     *<p>
     *--------------------------------------------------------------<br>
     * 修改履历：<br>
     *        <li> 2015-6-12，jincy@neusoft.com，创建方法；<br>
     *--------------------------------------------------------------<br>
     *</p>
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        URL realUrl = null;
        URLConnection conn = null;
        String result = "";
        try {
            realUrl = new URL(url);
            /*打开和URL之间的连接*/
            conn = realUrl.openConnection();
            /*设置通用的请求属性*/
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            /*发送POST请求必须设置如下两行*/
            conn.setDoOutput(true);
            conn.setDoInput(true);
            /*获取URLConnection对象对应的输出流*/
            out = new PrintWriter(conn.getOutputStream());
            /*发送请求参数*/
            out.print(param);
            /*flush输出流的缓冲*/
            out.flush();
            /*定义BufferedReader输入流来读取URL的响应*/
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*使用finally块来关闭输出流、输入流*/
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    /**
     * 
     * <p>Method ：getUrlStatus
     * <p>Description : 获取url的http 状态码
     *
     * @param sUrl
     * @return 
     * @author  金春艳-jincy@neusoft.com
     */
    public static String getUrlStatus(String sUrl){
        try {
            /** post方式 */
            HttpClient client = new HttpClient();
            client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
            client.getHttpConnectionManager().getParams().setSoTimeout(30000);
            PostMethod postMethod = new PostMethod(sUrl);
            client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
            int status = client.executeMethod(postMethod);
            return String.valueOf(status);
        } catch (Exception e) {
            return "404";
        }
    }
    
    /**
     * 
     * <p>Method ：sendMess
     * <p>Description : 模拟发送post请求
     *
     * @param url
     * @param input
     * @return  post 请求返回结果
     * @author  金春艳-jincy@neusoft.com
     */
    @SuppressWarnings("deprecation")
    public static String sendPostReq(String url,String input){
        HttpClient client = null;
        PostMethod postMethod = null;
        try{
            client = new HttpClient();
            client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
            client.getHttpConnectionManager().getParams().setSoTimeout(30000);
            postMethod = new PostMethod(url);
            postMethod.addRequestHeader("Content-Type","textml;charset=UTF-8");
            postMethod.setRequestBody(input);
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            client.executeMethod(postMethod);
            String rsp = postMethod.getResponseBodyAsString();
            return rsp;
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
}