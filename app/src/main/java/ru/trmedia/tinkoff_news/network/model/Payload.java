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
    private PublicationDate publicationDate;

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

    public PublicationDate getPublicationDate() {
        return publicationDate;
    }

    public int getBankInfoTypeId() {
        return bankInfoTypeId;
    }
}
