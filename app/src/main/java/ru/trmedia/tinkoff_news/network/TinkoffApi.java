package ru.trmedia.tinkoff_news.network;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.trmedia.tinkoff_news.network.model.ResponseNews;
import ru.trmedia.tinkoff_news.network.model.ResponsePayload;

public interface TinkoffApi {
    @NonNull
    @GET("/v1/news")
    Observable<ResponsePayload> getAllNews();

    @NonNull
    @GET("/v1/news_content")
    Single<ResponseNews> getNewsById(@NonNull @Query("id") String id);
}
