package ru.trmedia.tinkoff_news.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.trmedia.tinkoff_news.ui.detailnews.DetailNewsComponent;
import ru.trmedia.tinkoff_news.ui.detailnews.DetailNewsModule;
import ru.trmedia.tinkoff_news.ui.news.NewsComponent;
import ru.trmedia.tinkoff_news.ui.news.NewsModule;

@Singleton
@Component(modules = {AppModule.class, DatabaseModule.class, NetworkModule.class})
public interface AppComponent {
    NewsComponent createNewsComponent(NewsModule newsModule);

    DetailNewsComponent createDetailNewsComponent(DetailNewsModule detailNewsModule);
}
