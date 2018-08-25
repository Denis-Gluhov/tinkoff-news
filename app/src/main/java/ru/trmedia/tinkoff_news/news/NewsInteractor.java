package ru.trmedia.tinkoff_news.news;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import ru.trmedia.tinkoff_news.database.dao.NewsDao;
import ru.trmedia.tinkoff_news.database.entity.News;
import ru.trmedia.tinkoff_news.network.TinkoffApi;
import ru.trmedia.tinkoff_news.network.model.Payload;
import ru.trmedia.tinkoff_news.network.model.Response;

class NewsInteractor implements NewsContract.Interactor {

    @NonNull
    private final NewsDao newsDao;
    @NonNull
    private final TinkoffApi tinkoffApi;

    NewsInteractor(@NonNull NewsDao newsDao, @NonNull TinkoffApi tinkoffApi) {
        this.newsDao = newsDao;
        this.tinkoffApi = tinkoffApi;
    }

    @NonNull
    @Override
    public Maybe<List<News>> loadData() {
        return tinkoffApi.getAllNews()
                .flatMapIterable(Response::getPayload)
                .flatMap(this::payloadToNews)
                .toList()
                .flatMapMaybe(news -> {
                    newsDao.addItems(news);
                    return newsDao.getAll();
                })
                .onErrorResumeNext(throwable -> {
                    return newsDao.getAll();
                });
    }

    @NonNull
    private Observable<News> payloadToNews(@NonNull Payload payload) {
        News news = new News(payload.getId(), payload.getName(), payload.getText(),
                    payload.getPublicationDate().getMilliseconds());
        return Observable.just(news);
    }
}
