package ru.trmedia.tinkoff_news.network.model;

import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("text")
    private String text;

    @SerializedName("publicationDate")
    private Date date;

    @SerializedName("bankInfoTypeId")
    private int bankInfoTypeId;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public int getBankInfoTypeId() {
        return bankInfoTypeId;
    }
}
