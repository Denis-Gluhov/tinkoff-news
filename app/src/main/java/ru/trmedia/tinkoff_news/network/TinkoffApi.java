package ru.trmedia.tinkoff_news.network;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ru.trmedia.tinkoff_news.network.model.Response;

public interface TinkoffApi {
    @NonNull
    @GET("/v1/news")
    Observable<Response> getAllNews();
}
