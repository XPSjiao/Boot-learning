package com.ej.article.sample;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-23 11:18
 **/
public class Sample {
    /**
     * 使用AK&SK初始化账号Client     *     * @param accessKeyId     accessKeyId     * @param accessKeySecret accessKeySecret     * @return Client     * @throws Exception Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                .setAccessKeyId("LTAI4GEYqEPww4sfKqMm72tU")
                .setAccessKeySecret("iMrqPWmyHkLBOdOa3WP7qh2R9Kk2HL");
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static void main(String[] args) throws Exception {
        com.aliyun.dysmsapi20170525.Client client = Sample.createClient("ACCESS_KEY_ID", "ACCESS_KEY_SECRET");
        SendSmsRequest sendSmsRequest = new SendSmsRequest().setSignName("ABC商城").setPhoneNumbers("13913457284").setTemplateCode("SMS_205403269").setTemplateParam("{\"code\":\"123456\"}");
        SendSmsResponse resp = client.sendSms(sendSmsRequest);
    }
}