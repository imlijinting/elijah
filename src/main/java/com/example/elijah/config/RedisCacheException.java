package com.example.elijah.config;

public class RedisCacheException extends RuntimeException {

  private static final long serialVersionUID = -1041504903669964677L;

  public RedisCacheException() {
  }

  public RedisCacheException(String message) {
    super(message);
  }

  public RedisCacheException(String message, Throwable cause) {
    super(message, cause);
  }

  public RedisCacheException(Throwable cause) {
    super(cause);
  }

  public RedisCacheException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
