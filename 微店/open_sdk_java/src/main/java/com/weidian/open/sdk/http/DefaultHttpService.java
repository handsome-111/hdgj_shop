package com.weidian.open.sdk.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.weidian.open.sdk.exception.OpenException;
import com.weidian.open.sdk.util.SystemConfig;

public class DefaultHttpService implements HttpService {

  public DefaultHttpService() {
    super();
  }

  private static DefaultHttpService instance = new DefaultHttpService();

  private static CloseableHttpClient httpClient = null;
  private static PoolingHttpClientConnectionManager connectionManager = null;
  private static RequestConfig defaultRequestConfig = null;

  static {
    connectionManager = new PoolingHttpClientConnectionManager();
    connectionManager.setMaxTotal(SystemConfig.HTTP_POOL_MAX_TOTAL);
    connectionManager.setDefaultMaxPerRoute(SystemConfig.HTTP_MAX_PER_ROUTE);

    defaultRequestConfig =
        RequestConfig.custom().setSocketTimeout(SystemConfig.HTTP_CONNECTION_TIMEOUT)
            .setConnectTimeout(SystemConfig.HTTP_CONNECTION_TIMEOUT)
            .setConnectionRequestTimeout(SystemConfig.HTTP_READ_TIMEOUT).build();
    httpClient =
        HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(defaultRequestConfig)
            .build();
  }

  public static DefaultHttpService getInstance() {
    return instance;
  }

  @Override
  public String get(String url) throws OpenException {
    return this.httpExecute(new HttpGet(url), url);
  }

  @Override
  public String post(String url, Param... params) throws OpenException {
    HttpPost post = new HttpPost(url);
    if (params != null && params.length > 0) {
      List<NameValuePair> parameters = new ArrayList<NameValuePair>(params.length);
      for (Param p : params) {
        parameters.add(new BasicNameValuePair(p.getName(), p.getValue()));
      }
      post.setEntity(new UrlEncodedFormEntity(parameters, Charset.forName(SystemConfig.ENC_UTF8)));
    }
    return this.httpExecute(post, url);
  }

  @Override
  public String multipart(String url, String name, byte[] content) throws OpenException {
    HttpPost httpPost = new HttpPost(url);
    HttpEntity entity = MultipartEntityBuilder.create().addPart(name, new ByteArrayBody(content, "media.jpg")).build();
    httpPost.setEntity(entity);
    return httpExecute(httpPost, url);
  }

  private String httpExecute(HttpRequestBase request, String url) throws OpenException {
    request.setConfig(RequestConfig.copy(defaultRequestConfig).build());
    CloseableHttpResponse response = null;
    try {
      response = httpClient.execute(request);
      if (response == null) {
        throw new OpenException("http response is null|url:" + url);
      }

      StatusLine status = response.getStatusLine();
      int code = status.getStatusCode();
      if (code != 200) {
        throw new OpenException("http response code is " + code + "|reason:" + status.getReasonPhrase() + "|url:" + url);
      }

      HttpEntity entity = response.getEntity();
      if (entity == null) {
        throw new OpenException("http response entity is null|url:" + url);
      }

      return EntityUtils.toString(response.getEntity(), SystemConfig.ENC_UTF8);
    } catch (ClientProtocolException e) {
      throw new OpenException("http client protocol exception|url:" + url, e);
    } catch (IOException e) {
      throw new OpenException("http io exception|url:" + url, e);
    } finally {
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
          // ignore
        }
      }
    }
  }

}
