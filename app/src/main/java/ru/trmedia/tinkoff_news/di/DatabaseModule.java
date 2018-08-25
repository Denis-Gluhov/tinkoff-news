package ru.trmedia.tinkoff_news.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.trmedia.tinkoff_news.database.AppDatabase;

@Module
public class DatabaseModule {

    private final static String NAME_DATABASE = "news";

    @NonNull
    @Singleton
    @Provides
    AppDatabase provideAppDatabase(@NonNull Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, NAME_DATABASE)
                .build();
    }
}
