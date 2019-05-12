package com.cjw.project.tool.util.alipay;
public class AlipayConfig {
    // 商户appid
    public static String APPID = "2019051264466211";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAswYK0Dwp3nibHo0CjquRRdoqbH+0CzDdUo3WRdqIbTmUUsOSpcV7OXu5itwkM+x6SQ5K4z8sXCVrMfAy1SGz8KKsSvj0Ar8E2Y923xyYYl691nokp7etGvRAh6IY3ALqiF803sZVJQrsW9mj+hXhAMa979iDx28fWli2ACSuwXwHMekXg/Xk0D0wUMDtqbkiZjOreq1YJtEWRRqbf65U4YhADe0WE+OpqKsALevFQ0PaDI5v31iY3scyRVhDF6L3Y3RmPM5CJ1Jnosj2TUEzoVcK6Xiu64aoL+tHH3n/14xlI6/yPs4Fqc7G8UrbLNf8WgZS9ZWAMbHp5jroI4HxHwIDAQAB";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.bemess.xyz/CommunityManager/";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://www.bemess.xyz/CommunityManager/";
    // 请求网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "hjN9kJfLJWvUHh8Cce8GYA==";
    // 日志记录目录
    public static String log_path = "E:\\log";
    // RSA2
    public static String SIGNTYPE = "RSA2";

}