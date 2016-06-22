package com.kaishengit.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class HttpUtil {
    public static String getRequestText(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int httpCode = httpResponse.getStatusLine().getStatusCode();
            if (httpCode==200){
                InputStream inputStream = httpResponse.getEntity().getContent();
                String html = IOUtils.toString(inputStream);
                return html;
            }else {
                throw new RuntimeException("请求服务器异常:" + httpCode);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
