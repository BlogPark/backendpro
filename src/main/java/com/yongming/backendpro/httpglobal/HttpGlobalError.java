package com.yongming.backendpro.httpglobal;

import lombok.Getter;

/**
 * Project: sundata Package: com.hlt.sundata.httpglobal.error
 *
 * <p>Create Time: 2019年08月28日 19:10
 *
 * <p>@author: qingmei.meng
 *
 * <p>Description:
 */
@Getter
public class HttpGlobalError extends RuntimeException {
  private final int code;
  private final String message;
  private final String extCode;
  private final Object extData;

  public HttpGlobalError(int code, String message) {
    this.code = code;
    this.extCode = null;
    this.message = message;
    this.extData = null;
  }

  public HttpGlobalError(int code, String message, String extCode) {
    this.code = code;
    this.message = message;
    this.extCode = extCode;
    this.extData = null;
  }

  public HttpGlobalError(int code, String message, String extCode, Object extData) {
    this.code = code;
    this.message = message;
    this.extCode = extCode;
    this.extData = extData;
  }
}
