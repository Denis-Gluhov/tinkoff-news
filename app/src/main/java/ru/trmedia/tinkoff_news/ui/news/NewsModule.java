package ru.trmedia.tinkoff_news.ui.news;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import ru.trmedia.tinkoff_news.database.AppDatabase;
import ru.trmedia.tinkoff_news.database.dao.NewsDao;
import ru.trmedia.tinkoff_news.network.TinkoffApi;

@Module
public class NewsModule {

    @NonNull
    @NewsScreen
    @Provides
    NewsContract.Interactor provideInteractor(@NonNull NewsDao newsDao,
                                              @NonNull TinkoffApi tinkoffApi) {
        return new NewsInteractor(newsDao, tinkoffApi);
    }

    @NonNull
    @NewsScreen
    @Provides
    NewsDao provideNewsDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.newsDao();
    }
}
