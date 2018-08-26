package ru.trmedia.tinkoff_news.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import io.reactivex.Maybe;
import ru.trmedia.tinkoff_news.database.entity.NewsInfo;

@Dao
public interface NewsInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addItem(NewsInfo item);

    @Query("SELECT * FROM news_info WHERE id = :id")
    Maybe<NewsInfo> getItemById(String id);
}
