package com.weidian.open.sdk.exception;

public class OpenException extends Exception {

  private static final long serialVersionUID = 466968164282917646L;

  public OpenException(String message, Throwable cause) {
    super(message, cause);
  }

  public OpenException(String message) {
    super(message);
  }

}
