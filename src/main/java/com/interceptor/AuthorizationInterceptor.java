package com.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName AuthorizationInterceptor
 * @Description 拦截器实现
 */
@Slf4j
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    public static final String LOGIN_TOKEN_KEY = "Token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //支持跨域请求
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,request-source,Token, Origin,imgType, Content-Type, cache-control,postman-token,Cookie, Accept,authorization");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        // 跨域时会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.OK.value());
            return false;
        }

        IgnoreAuth annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }


        /**
         * 不需要验证权限的方法直接放过
         */
        if(annotation!=null) {
            return true;
        }

        //从header中获取token
        String headerToken = request.getHeader(LOGIN_TOKEN_KEY);
        String token="";
        if(null != request.getSession().getAttribute("token")){
            token=request.getSession().getAttribute("token").toString();
        }
        if(StringUtils.isNotBlank(headerToken) && StringUtils.isNotBlank(token) && headerToken.equals(token)){
            return true;
        }

        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSONObject.toJSONString(ApiResponse.failed(401,"登录信息失效,请重新登录")));
        } finally {
            if(writer != null){
                writer.close();
            }
        }
        return false;
    }
}
