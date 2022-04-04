package com.ej.boot.Interceptor;

import com.ej.boot.domain.AccessLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-04-04
 **/

@Component
@Slf4j
public class AccessLogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AccessLog accessLog = new AccessLog();
        //请求方法
        accessLog.setHttpMethod(request.getMethod());
        accessLog.setIp(request.getRemoteAddr());
        //请求路径
        accessLog.setUri(request.getRequestURI());
        request.setAttribute("sendTime", System.currentTimeMillis());
        request.setAttribute("accessLog", accessLog);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        AccessLog accessLog = (AccessLog) request.getAttribute("accessLog");
        //    获取请求错误码
        int status = response.getStatus();
        accessLog.setHttpStatus(status);
        //    设置访问者
        accessLog.setUsername(request.getParameter("username"));
        long currentTime = System.currentTimeMillis();
        long sendTime = Long.parseLong(request.getAttribute("sendTime").toString());
        accessLog.setDuration(Integer.valueOf((currentTime-sendTime)+""));
        accessLog.setCreateTime(new Date());
        log.info(accessLog.toString());
    }

}