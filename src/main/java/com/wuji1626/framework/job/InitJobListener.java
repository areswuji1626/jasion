package com.wuji1626.framework.job;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import com.wuji1626.framework.config.JobConfig;
import com.wuji1626.framework.domain.JobInfo;

/**
 * 
* @ClassName: InitJobListener 
* @Description: 任务队列初始化 
* @author zhangwh zhangwenheN@neusoft.com
* @date 2015年12月17日 下午4:04:06 
*
 */
public class InitJobListener implements InitializingBean, ServletContextAware {
	/**
	 * 初始化任务队列
	 */
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub

        List<JobInfo> jobList = JobConfig.getJobListFromProperties();
        for(JobInfo job:jobList){
        	try {
				QuartzManager.addJob(job.getJobName(), Class.forName(job.getJobClassStr()), job.getJobCron());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("job:" + job.getJobName() + " Class forName error!");
				continue;
			}
        }
//		String job_name = "动态任务调度";  
//        System.out.println("【系统启动】开始(每1秒输出一次)...");  
//        QuartzManager.addJob(job_name, QuartzJob.class, "0/1 * * * * ?"); 
//		System.out.println("EXEC ONLY ONCE WHEN CONTAIN START!");
//		String job_name = "自动更新MQ";
//		QuartzManager.addJob(job_name, PlatMQUpdator.class, "0 51 11 * * ?");
		
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

}
