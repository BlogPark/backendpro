package com.yongming.backendpro.httpglobal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Project: sundata Package: com.hlt.sundata.httpglobal.error
 *
 * <p>Create Time: 2019年08月28日 20:26
 *
 * <p>@author: qingmei.meng
 *
 * <p>Description:
 */
@RestControllerAdvice
public class HttpGlobalErrorHandler {

  @ExceptionHandler(value = HttpGlobalError.class)
  public ResponseEntity<HttpGlobalResponse> handleGlobalError(HttpGlobalError e) {
    return ResponseEntity.ok(HttpGlobalResponse.failed(e));
  }
}
