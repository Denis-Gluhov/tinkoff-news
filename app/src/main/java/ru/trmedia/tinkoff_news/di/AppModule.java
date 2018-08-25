package ru.trmedia.tinkoff_news.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.trmedia.tinkoff_news.App;

@Module
public class AppModule {

    @NonNull
    private final App app;

    public AppModule(@NonNull App app) {
        this.app = app;
    }

    @NonNull
    @Singleton
    @Provides
    Context provideContext() {
        return app;
    }
}
