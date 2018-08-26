package ru.trmedia.tinkoff_news.ui.detailnews;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import ru.trmedia.tinkoff_news.database.AppDatabase;
import ru.trmedia.tinkoff_news.database.dao.NewsInfoDao;
import ru.trmedia.tinkoff_news.network.TinkoffApi;

@Module
public class DetailNewsModule {

    @NonNull
    @DetailNewsScreen
    @Provides
    DetailNewsContract.Interactor provideInteractor(@NonNull TinkoffApi tinkoffApi,
                                                    @NonNull NewsInfoDao newsInfoDao) {
        return new DetailNewsInteractor(tinkoffApi, newsInfoDao);
    }

    @NonNull
    @DetailNewsScreen
    @Provides
    NewsInfoDao provideNewsInfoDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.newsInfoDao();
    }
}
