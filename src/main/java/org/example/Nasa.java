package org.example;

import com.google.gson.annotations.SerializedName;

public class Nasa {

    @SerializedName("date")
    private String date; // - дата
    @SerializedName("explanation")
    private String explanation; // - объяснение
    @SerializedName("hdurl")
    private String hdurl; // - hdurl
    @SerializedName("media_type")
    private String media_type; // - тип медиа
    @SerializedName("service_version")
    private String service_version; // - версия сервиса
    @SerializedName("title")
    private String title; // - заголовок
    @SerializedName("url")
    private String url; // - url

    public Nasa(
            String date,
            String explanation,
            String hdurl,
            String media_type,
            String service_version,
            String title,
            String url
    ) {
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }


    @Override
    public String toString() {
        return "\n date = " + date +
                "\n explanation = " + explanation +
                "\n hdurl = " + hdurl +
                "\n media_type = " + media_type +
                "\n service_version = " + service_version +
                "\n title = " + title +
                "\n url = " + url;
    }

    public String getUrl() {
        return url;
    }

}
