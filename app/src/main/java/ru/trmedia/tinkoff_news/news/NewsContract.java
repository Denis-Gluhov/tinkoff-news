package ru.trmedia.tinkoff_news.news;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import io.reactivex.Maybe;
import ru.trmedia.tinkoff_news.database.entity.News;

public interface NewsContract {

    interface View extends MvpView {
        void onShowLoading(boolean loading);

        void onSetData(@NonNull List<News> data);

        void onShowMessage(@NonNull String message);

        void onShowDetailNews(@NonNull String id);
    }

    interface Presenter {
        void loadData();

        void selectedItem(@NonNull String id);

        void destroy();
    }

    interface Interactor {
        @NonNull
        Maybe<List<News>> loadData();
    }
}
