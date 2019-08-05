package com.weidian.open.sdk.http;

import com.weidian.open.sdk.exception.OpenException;

public interface HttpService {

  public String get(String url) throws OpenException;

  public String post(String url, Param... params) throws OpenException;

  public String multipart(String url, String name, byte[] content) throws OpenException;

}
