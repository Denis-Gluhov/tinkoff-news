package ru.trmedia.tinkoff_news.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.trmedia.tinkoff_news.news.NewsComponent;
import ru.trmedia.tinkoff_news.news.NewsModule;

@Singleton
@Component(modules = {AppModule.class, DatabaseModule.class, NetworkModule.class})
public interface AppComponent {

    NewsComponent createNewsComponent(NewsModule newsModule);

}
