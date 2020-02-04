package com.yongming.backendpro.httpglobal;

import lombok.Getter;

/**
 * Project: sundata Package: com.hlt.sundata.httpglobal.response
 *
 * <p>Create Time: 2019年08月28日 19:25
 *
 * <p>@author: qingmei.meng
 *
 * <p>Description:
 */
@Getter
public class HttpGlobalResponse {
  private Integer code;
  private String message;
  private Object data;

  protected HttpGlobalResponse(Integer code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static HttpGlobalResponse succeed(Object data) {
    return new HttpGlobalResponse(HttpErrorCode.SUCCEED, null, data);
  }

  public static HttpGlobalResponse failed(HttpGlobalError e) {
    return new HttpGlobalResponse(e.getCode(), e.getMessage(), null);
  }
}
