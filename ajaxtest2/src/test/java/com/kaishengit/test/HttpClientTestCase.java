package com.kaishengit.test;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpClientTestCase {
    @Test
    public void testDownloadImage() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://ww4.sinaimg.cn/mw690/6f055540gw1eqw4zp7hsgj21kw2dcqv5.jpg");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        if (httpCode==200){
            InputStream inputStream = httpResponse.getEntity().getContent();
            FileOutputStream outputStream = new FileOutputStream("D:/qq.jpg");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            outputStream.close();
        }else {
            System.out.println("请求异常:" + httpCode);
        }
        httpClient.close();
    }

    @Test
    public void testGetRequest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://blog.sina.com.cn/rss/1220218113.xml");
        HttpResponse response = httpClient.execute(httpGet);
        int httpCode = response.getStatusLine().getStatusCode();
        if (httpCode==200){
            InputStream inputStream = response.getEntity().getContent();
            String html = IOUtils.toString(inputStream);
            System.out.println(html);
        }else {
            System.out.println("请求异常:" + httpCode);
        }
        httpClient.close();
    }
}
