package com.wuji1626.framework.domain;

public class JobInfo {

	private String jobKey;
	private String jobName;
	private String jobClassStr;
	private String jobCron;
	
	public String getJobKey() {
		return jobKey;
	}
	public void setJobKey(String jobKey) {
		this.jobKey = jobKey;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobClassStr() {
		return jobClassStr;
	}
	public void setJobClassStr(String jobClassStr) {
		this.jobClassStr = jobClassStr;
	}
	public String getJobCron() {
		return jobCron;
	}
	public void setJobCron(String jobCron) {
		this.jobCron = jobCron;
	}
	
}
