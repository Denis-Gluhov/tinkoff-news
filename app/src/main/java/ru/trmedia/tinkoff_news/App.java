package ru.trmedia.tinkoff_news;

import android.app.Application;

import ru.trmedia.tinkoff_news.ui.detailnews.DetailNewsComponent;
import ru.trmedia.tinkoff_news.ui.detailnews.DetailNewsModule;
import ru.trmedia.tinkoff_news.di.AppComponent;
import ru.trmedia.tinkoff_news.di.AppModule;
import ru.trmedia.tinkoff_news.di.DaggerAppComponent;
import ru.trmedia.tinkoff_news.di.DatabaseModule;
import ru.trmedia.tinkoff_news.di.NetworkModule;
import ru.trmedia.tinkoff_news.ui.news.NewsComponent;
import ru.trmedia.tinkoff_news.ui.news.NewsModule;

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    private AppComponent appComponent;
    private NewsComponent newsComponent;
    private DetailNewsComponent detailNewsComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule())
                .networkModule(new NetworkModule())
                .build();
    }

    public NewsComponent createNewsComponent() {
        if (newsComponent == null)
            newsComponent = appComponent.createNewsComponent(new NewsModule());
        return newsComponent;
    }

    public void clearNewsComponent() {
        newsComponent = null;
    }

    public DetailNewsComponent createDetailNewsComponent() {
        if (detailNewsComponent == null)
            detailNewsComponent = appComponent.createDetailNewsComponent(new DetailNewsModule());
        return detailNewsComponent;
    }

    public void clearDetailNewsComponent() {
        detailNewsComponent = null;
    }
}
