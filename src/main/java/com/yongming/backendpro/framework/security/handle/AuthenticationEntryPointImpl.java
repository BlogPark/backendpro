package com.yongming.backendpro.framework.security.handle;

import com.alibaba.fastjson.JSON;
import com.yongming.backendpro.common.constant.HttpStatus;
import com.yongming.backendpro.common.utils.ServletUtils;
import com.yongming.backendpro.common.utils.StringUtils;
import com.yongming.backendpro.framework.web.domain.AjaxResult;
import com.yongming.backendpro.httpglobal.HttpGlobalResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 认证失败处理类 返回未授权
 *
 * @author ruoyi
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
  private static final long serialVersionUID = -8970718410437077606L;

  @Override
  public void commence(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
      throws IOException {
    int code = HttpStatus.UNAUTHORIZED;
    String msg = StringUtils.format("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());
    HttpGlobalResponse httpGlobalResponse = HttpGlobalResponse.succeed(AjaxResult.error(code, msg));
    ServletUtils.renderString(response, JSON.toJSONString(httpGlobalResponse));
  }
}
