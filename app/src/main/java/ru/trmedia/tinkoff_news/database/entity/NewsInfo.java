package ru.trmedia.tinkoff_news.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity(tableName = "news_info")
public class NewsInfo {

    @NonNull
    @PrimaryKey
    private String id;

    private String name;

    private String text;

    @ColumnInfo(name = "publication_date")
    private long publicationDate;

    @ColumnInfo(name = "last_modification_date")
    private long lastModificationDate;

    private String content;

    public NewsInfo(@NonNull String id, String name, String text, long publicationDate,
                    long lastModificationDate, String content) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.publicationDate = publicationDate;
        this.lastModificationDate = lastModificationDate;
        this.content = content;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(long publicationDate) {
        this.publicationDate = publicationDate;
    }

    public long getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(long lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String convertPublicationDate() {
        Date date = new Date(publicationDate);
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        return dateFormat.format(date);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
