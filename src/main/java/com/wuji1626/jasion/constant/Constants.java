package com.wuji1626.jasion.constant;

public class Constants {

	public static final String MQ_HOST_NAME = "mq.host.name";
	public static final String MQ_PORT = "mq.port";
	public static final String MQ_CHANNEL_NAME = "mq.channel";
	public static final String MQ_CCSID = "mq.ccsid";
	public static final String MQ_QUEUEMANAGER_NAME = "mq.qm.name";
	public static final String MQ_QUEUE_NAME = "mq.queue.name";
	
	public static final String PIC_TYPE_LIST = "thumbnail.type.list";
	public static final String COMMA = ",";
	public static final String THUMBNAIL_PAGE_SIZE = "thumbnail.page.size";
	public static final String THUMBNAIL_MAX_WIDTH = "thumbnail.max.width";
	public static final String THUMBNAIL_MAX_HEIGHT = "thumbnail.max.height";
	
	public static final String MD_PREFIX_PATH = "md.prefix.path";
	public static final String THUMBNAIL_PREFIX_PATH = "thumbnail.prefix.path";
	public static final String WATERMARK_ICON = "watermark.icon";
	
	public static final String NULL = "null";
	public static final String SEPARATOR = "separator";
	public static final int INVALID_NUMBER = 99999;
	
	//Plat Info Template
	public static final String BODY_ELEMENT = "body";
	public static final String HEAD_ELEMENT = "header";
	public static final String TABLE_ELEMENT = "table";
	public static final String ROW_ELEMENT = "row";
	public static final String ITEMS_ELEMENT = "items";
	public static final String NAME_ATT = "name";
	public static final String STATUS_ATT = "status";
	public static final String REQ_ID_ATT = "req_id";
	
	public static final String T_SYS_USER_SYNC = "T_SYS_USER_SYNC";
	
	//Plat User Info Order
	public static final int F_USER_ID = 0;
	public static final int F_DEPT_ID_U = 1;
	public static final int F_USER_CODE = 2;
	public static final int F_USER_NAME = 3;
	public static final int F_LOGIN_NAME = 4;
	public static final int F_SEX = 5;
	public static final int F_OFFICE_PHONE = 6;
	public static final int F_MOBILE = 7;
	public static final int F_EMAIL = 8;
	public static final int F_MSN_QQ = 9;
	public static final int F_GUID = 10;
	public static final int F_DW_NAME = 11;
	public static final int F_DW_FULLNAME = 12;
	
	//Plat Dept Info Order
	public static final int F_DEPT_ID_D = 0;
	public static final int F_AREA_ID = 1;
	public static final int F_DEPT_CODE = 2;
	public static final int F_DEPT_NAME = 3;
	public static final int F_PARENT_ID = 4;
	public static final int F_LEVEL_CODE = 5;
	public static final int F_DEPT_KIND = 6;
	public static final int F_IS_TRUE = 7;
	public static final int F_DEPT_TYPE = 8;
	public static final int F_DEPT_STATUS = 9;
	
	//Plat Info status 
	public static final String ADD_STATUS = "A";
	public static final String UPDATE_STATUS = "U";
	public static final String DEL_STATUS = "D";
	
	// Job status 
	public static final String SUCCESS = "00000001";
	public static final String SUCCESS_WITH_ERROR = "00000002";
	public static final String FAIL = "99999999";
	
	// sms
	public static final String SMS_URL = "sms.url";
	public static final String SMS_SIGN = "sms.sign";
	public static final String SMS_PASSWD = "sms.password";
	public static final String SMS_USER = "sms.account";
	public static final String SMS_RES_SUCCESS = "0";
	public static final String SMS_RES_ACCOUNT_ERR = "1";
	public static final String SMS_RES_PASSWD_ERR = "2";
	public static final String SMS_RES_MSGID_REPEAT = "3";
	public static final String SMS_RES_PHONE_ERR = "4";
	public static final String SMS_RES_PHONE_NO_OVER = "5";
	public static final String SMS_RES_MSG_OVER = "6";
	public static final String SMS_RES_FUND_NO_SUFFICIENT = "11";
	public static final String SMS_RES_SIGN_ERR = "13";
	public static final String SMS_RES_SYS_BUSY = "98";
	
	public static final String DAYS = "01";
	public static final String WEEKS = "02";
	public static final String MONTHS = "03";
	public static final String YEARS = "04";
	
	public static final String OFDO_DL_URL = "ofdo.download.url";
	public static final String OFDO_DL_URL_PATTERN = "ofdo.download.url.pattern";
	public static final String OFDO_LOCAL_STORAGE_PREFIX = "ofdo.local.storage.prefix";
	
	public static final String LOGGER_NAME = "JobPlatLogger";
}
