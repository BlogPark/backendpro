package com.yongming.backendpro.httpglobal;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * Project: sundata Package: com.hlt.sundata.httpglobal.advise
 *
 * <p>Create Time: 2019年08月28日 19:24
 *
 * <p>@author: qingmei.meng
 *
 * <p>Description:
 */
@RestControllerAdvice
public class HttpGlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private Logger logger = LoggerFactory.getLogger(HttpGlobalResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class clazz) {
        String methodName = methodParameter.getMethod().getName();
        if (methodName.equals("handleGlobalError") // error
                || methodName.equals("recvMessage")
                || methodName.equals("paymentCallback")) { // 和缓回调
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object returnValue,
            MethodParameter methodParameter,
            MediaType mediaType,
            Class clazz,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpGlobalResponse) {
        HttpGlobalResponse resp = HttpGlobalResponse.succeed(returnValue);
    /*
    if (returnValue instanceof String) {
      serverHttpGlobalResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
      return JsonObjectMapper.toJson(resp);
    }
    */
        return resp;
    }


}
