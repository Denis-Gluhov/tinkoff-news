package ru.trmedia.tinkoff_news.network.model;

import com.google.gson.annotations.SerializedName;

public class ResponseNews {

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("payload")
    private News payload;

    @SerializedName("trackingId")
    private String trackingId;

    public String getResultCode() {
        return resultCode;
    }

    public News getPayload() {
        return payload;
    }

    public String getTrackingId() {
        return trackingId;
    }
}
