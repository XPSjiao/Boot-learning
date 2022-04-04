package com.ej.article.util;


import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-23 15:00
 **/
@Component
@Slf4j
public class SmsUtil {
    /**
     * 注入阿里云配置实体类
     */
    @Resource
    private AliyunResource aliyunResource;


    public boolean sendSms(String phone, String code) {
            Config config = new Config().setAccessKeyId(aliyunResource.getAccessKeyId())
                    .setAccessKeySecret(aliyunResource.getAccessKeySecret());
        config.endpoint = "dysmsapi.aliyuncs.com";


        try {
            Client client = new Client(config);
            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setPhoneNumbers(phone)
                    .setSignName(aliyunResource.getSignName())
                    .setTemplateCode(aliyunResource.getTemplateCode())
                    .setTemplateParam("{\"code\"" + code + "\"}");
            SendSmsResponse resp = client.sendSms(sendSmsRequest);
            log.info(resp.getBody().getCode());
            log.info(resp.getBody().getMessage());
            return true;
            //log.info(resp.toString());
            ////    获得返回结果JSON串
            //String res = String.valueOf(resp.getBody());
            //log.info(res);
            ////    转成JSON对象
            //JSONObject jsonObject = JSON.parseObject(res);
            ////    返回发送成功与否的标记
            //if ("OK".equals(jsonObject.get("Code"))) {
            //    return true;
            //}
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }
}