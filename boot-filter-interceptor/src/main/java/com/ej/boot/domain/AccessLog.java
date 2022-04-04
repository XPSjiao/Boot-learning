package com.ej.boot.domain;

import com.ej.boot.utils.FormatUtils;
import lombok.Data;

import java.util.Date;

/**
 * @program: boot-learning
 * @description: 访问日志内容记录实体类
 * @author: EthanJiao
 * @create: 2022-04-04
 **/
@Data
public class AccessLog {
    /**
     * 访问用户名
     */
    private String username;
    /**
     * 请求路径
     */
    private String uri;
    /**
     * 请求消耗市场
     */
    private Integer duration;
    /**
     * http 方法：GET、POST等
     */
    private String httpMethod;
    /**
     *
     */
    private Integer httpStatus;
    /**
     * 访问者ip
     */
    private String ip;
    /**
     * 此条记录的创建时间
     */
    private Date createTime;

    @Override
    public String toString() {
        return "AccessLog{" +
                "username=" + this.username + "," +
                "uri=" + this.uri + ","  +
                "duration=" + this.duration + "," +
                "httpMethod=" + this.httpMethod + "," +
                "httpStatus=" + this.httpStatus + "," +
                "ip=" + this.ip + "," +
                "createTime=" + FormatUtils.forTime(this.createTime)
                + "}";
    }

}
