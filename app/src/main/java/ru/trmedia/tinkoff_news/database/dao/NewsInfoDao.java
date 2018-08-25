package ru.trmedia.tinkoff_news.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;
import ru.trmedia.tinkoff_news.database.entity.NewsInfo;

@Dao
public interface NewsInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addItem(NewsInfo item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addItems(List<NewsInfo> items);

    @Query("SELECT * FROM news_info")
    Single<List<NewsInfo>> getAll();

    @Query("SELECT * FROM news_info WHERE id = :id")
    Single<NewsInfo> getItemById(String id);
}
