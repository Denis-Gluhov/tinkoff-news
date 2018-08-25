package ru.trmedia.tinkoff_news.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.trmedia.tinkoff_news.network.TinkoffApi;

@Module
public class NetworkModule {

    private static final String BASE_URL = "https://api.tinkoff.ru/";

    @NonNull
    @Singleton
    @Provides
    TinkoffApi provideApi(@NonNull Retrofit retrofit) {
        return retrofit.create(TinkoffApi.class);
    }

    @NonNull
    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
