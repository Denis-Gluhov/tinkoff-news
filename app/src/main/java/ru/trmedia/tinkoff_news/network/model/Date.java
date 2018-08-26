package ru.trmedia.tinkoff_news.network.model;

import com.google.gson.annotations.SerializedName;

public class Date {

    @SerializedName("milliseconds")
    private long milliseconds;

    public long getMilliseconds() {
        return milliseconds;
    }
}
