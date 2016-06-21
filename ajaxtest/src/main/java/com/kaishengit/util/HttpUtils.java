package com.kaishengit.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpUtils {
    public static String getRequestTest(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            int httpCode = response.getStatusLine().getStatusCode();
            if (httpCode==200){
                InputStream inputStream = response.getEntity().getContent();
                String html = IOUtils.toString(inputStream);
                return html;
            }else {
                throw new RuntimeException("请求服务器异常"+httpCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void getRequestStream(String url, String savePath) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        if (httpCode==200){
            InputStream inputStream = httpResponse.getEntity().getContent();
            FileOutputStream outputStream = new FileOutputStream(savePath);
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }else {
            throw new RuntimeException("请求服务器异常:" + httpCode);
        }
        httpClient.close();
    }
}
