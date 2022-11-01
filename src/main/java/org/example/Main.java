package org.example;

import com.google.gson.Gson;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {

        String url = "https://api.nasa.gov/planetary/apod?api_key=U30P2fYbMdmo2W4eXZzFIcjoeiwcVb0bSMunfkGF";
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(request);
        String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);

        Gson gson = new Gson();
        Nasa nasaObj = gson.fromJson(body, Nasa.class);
        String[] nameOfFile = nasaObj.getUrl().split("/");

        String url1 = nasaObj.getUrl();
        HttpGet request1 = new HttpGet(url1);
        request1.setHeader(HttpHeaders.ACCEPT, ContentType.IMAGE_JPEG.getMimeType());
        CloseableHttpResponse response1 = httpClient.execute(request1);

        FileOutputStream stream = new FileOutputStream(nameOfFile[nameOfFile.length - 1]);
        response1.getEntity().getContent().transferTo(stream);
        stream.flush();
        stream.close();

    }
}