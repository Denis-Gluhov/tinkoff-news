package ru.trmedia.tinkoff_news.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.trmedia.tinkoff_news.database.dao.NewsDao;
import ru.trmedia.tinkoff_news.database.dao.NewsInfoDao;
import ru.trmedia.tinkoff_news.database.entity.News;
import ru.trmedia.tinkoff_news.database.entity.NewsInfo;

@Database(entities = {News.class, NewsInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
    public abstract NewsInfoDao newsInfoDao();
}
