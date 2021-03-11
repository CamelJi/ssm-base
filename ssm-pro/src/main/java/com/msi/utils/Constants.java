package com.msi.utils;

/**
 *  配置类
 */
public class Constants {
    public static final long TOKEN_EXPRESS_MINUTES = (60 * 3); //3小时

    public static final int HTTPSTATUS_CODE_SUCCESS = 200;

    public static final int NUM_ZERO = 0;
    public static final int NUM_ONE = 1;
    public static final int NUM_TWO = 2;
    public static final int NUM_THREE = 3;
    public static final int NUM_FIVE = 5;
    public static final int NUM_SEVEN = 7;
    public static final int NUM_TEN = 10;
    public static final int NUM_ONE_HUNDRED = 100;
    //头部 token令牌key
    public static final String HEADER_AUTHORIZATION_KEY = "Authori-zation";

    //验证码redis key前缀
    public static final String VALIDATE_REDIS_KEY_PREFIX = "validate_code_";

    public static final String SEARCH_DATE_DAY = "today"; //今天
    public static final String SEARCH_DATE_YESTERDAY = "yesterday"; //昨天
    public static final String SEARCH_DATE_LATELY_7 = "lately7"; //最近7天
    public static final String SEARCH_DATE_LATELY_30 = "lately30"; //最近30天
    public static final String SEARCH_DATE_WEEK = "week"; //本周
    public static final String SEARCH_DATE_PRE_WEEK = "preWeek"; //上周
    public static final String SEARCH_DATE_MONTH = "month"; //本月
    public static final String SEARCH_DATE_PRE_MONTH = "preMonth"; //上月
    public static final String SEARCH_DATE_YEAR = "year"; //年
    public static final String SEARCH_DATE_PRE_YEAR = "preYear"; //上一年

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YEAR = "yyyy";
    public static final String DATE_FORMAT_MONTH_DATE = "MM-dd";
    public static final String DATE_FORMAT_MONTH = "yyyy-MM";
    public static final String DATE_TIME_FORMAT_NUM = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_NUM = "yyyyMMdd";
    public static final String DATE_FORMAT_START = "yyyy-MM-dd 00:00:00";
    public static final String DATE_FORMAT_END = "yyyy-MM-dd 23:59:59";
    public static final String DATE_FORMAT_MONTH_START = "yyyy-MM-01 00:00:00";
    public static final String DATE_FORMAT_YEAR_START = "yyyy-01-01 00:00:00";
    public static final String DATE_FORMAT_YEAR_END = "yyyy-12-31 23:59:59";
    public static final String DATE_FORMAT_HHMMSS = "HH:mm:ss";
    public static final String DATE_FORMAT_START_PEREND = "00:00:00";
    public static final String DATE_FORMAT_END_PEREND = "23:59:59";
    public static final String DATE_FORMAT_HHMM = "yyyy-MM-dd HH:mm";

    // 时间类型开始时间
    public static String DATE_TIME_TYPE_BEGIN = "begin";
    // 时间类型结束时间
    public static String DATE_TIME_TYPE_END = "end";


    public static final String FAIL     = "FAIL";
    public static final String SUCCESS  = "SUCCESS";
}
