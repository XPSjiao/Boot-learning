package com.ej.boot.restful.common;

import lombok.Data;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-10
 **/
@Data
public class AjaxResponse {
    private Integer code;
    private String message;
    private Object data;

    /**
     * 请求成功的响应：不带查询参数（删除、修改、新增的接口）
     */
    private AjaxResponse(){

    }

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        return ajaxResponse;
    }


    /**
     * 带返回数据的响应成功
     * @param data
     * @return
     */
    public static AjaxResponse success(Object data){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }

}
