package ru.trmedia.tinkoff_news.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;
import ru.trmedia.tinkoff_news.database.entity.News;

@Dao
public interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addItems(List<News> news);

    @Query("SELECT * FROM news ORDER BY publication_date DESC")
    Maybe<List<News>> getAll();
}
