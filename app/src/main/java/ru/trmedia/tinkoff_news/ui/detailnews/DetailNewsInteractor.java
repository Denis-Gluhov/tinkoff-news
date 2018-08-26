package ru.trmedia.tinkoff_news.ui.detailnews;

import android.support.annotation.NonNull;

import io.reactivex.Maybe;
import ru.trmedia.tinkoff_news.database.dao.NewsInfoDao;
import ru.trmedia.tinkoff_news.database.entity.NewsInfo;
import ru.trmedia.tinkoff_news.network.TinkoffApi;
import ru.trmedia.tinkoff_news.network.model.News;

public class DetailNewsInteractor implements DetailNewsContract.Interactor {

    @NonNull
    private final TinkoffApi tinkoffApi;

    @NonNull
    private final NewsInfoDao newsInfoDao;

    DetailNewsInteractor(@NonNull TinkoffApi tinkoffApi,
                         @NonNull NewsInfoDao newsInfoDao) {
        this.tinkoffApi = tinkoffApi;
        this.newsInfoDao = newsInfoDao;
    }

    @NonNull
    @Override
    public Maybe<NewsInfo> getNewsById(@NonNull String id) {
        return tinkoffApi.getNewsById(id)
                .flatMapMaybe(responseNews -> {
                    saveNewsInfo(responseNews.getPayload());
                    return newsInfoDao.getItemById(id);
                }).onErrorResumeNext(throwable -> {
                    return newsInfoDao.getItemById(id);
                });
    }

    private void saveNewsInfo(@NonNull News news) {
        NewsInfo newsInfo = new NewsInfo(news.getTitle().getId(),
                news.getTitle().getName(), news.getTitle().getText(),
                news.getCreationDate().getMilliseconds(),
                news.getLastModificationDate().getMilliseconds(),news.getContent());
        newsInfoDao.addItem(newsInfo);
    }
}
