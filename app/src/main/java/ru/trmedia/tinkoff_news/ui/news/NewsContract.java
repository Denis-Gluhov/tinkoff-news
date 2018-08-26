package ru.trmedia.tinkoff_news.ui.news;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import io.reactivex.Maybe;
import ru.trmedia.tinkoff_news.database.entity.News;
import ru.trmedia.tinkoff_news.ui.BaseView;

public interface NewsContract {

    interface View extends BaseView {
        @StateStrategyType(AddToEndSingleStrategy.class)
        void onSetData(@NonNull List<News> data);

        @StateStrategyType(AddToEndSingleStrategy.class)
        void onShowDetailNews(@NonNull String id);
    }

    interface Presenter {
        void loadData();

        void selectedItem(@NonNull String id);
    }

    interface Interactor {
        @NonNull
        Maybe<List<News>> loadData();
    }
}
