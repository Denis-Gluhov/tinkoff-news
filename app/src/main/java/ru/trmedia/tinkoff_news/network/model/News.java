package ru.trmedia.tinkoff_news.network.model;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("title")
    private Title title;

    @SerializedName("creationDate")
    private Date creationDate;

    @SerializedName("lastModificationDate")
    private Date lastModificationDate;

    @SerializedName("content")
    private String content;

    @SerializedName("bankInfoTypeId")
    private Integer bankInfoTypeId;

    @SerializedName("typeId")
    private String typeId;

    public Title getTitle() {
        return title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public String getContent() {
        return content;
    }

    public Integer getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public String getTypeId() {
        return typeId;
    }
}
