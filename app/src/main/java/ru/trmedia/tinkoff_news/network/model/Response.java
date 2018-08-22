package ru.trmedia.tinkoff_news.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("payload")
    private List<Payload> payload;

    @SerializedName("trackingId")
    private String trackingId;

    public String getResultCode() {
        return resultCode;
    }

    public List<Payload> getPayload() {
        return payload;
    }

    public String getTrackingId() {
        return trackingId;
    }
}
