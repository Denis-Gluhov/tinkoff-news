package ru.trmedia.tinkoff_news.ui.detailnews;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import io.reactivex.Maybe;
import ru.trmedia.tinkoff_news.database.entity.NewsInfo;
import ru.trmedia.tinkoff_news.ui.BaseView;

public interface DetailNewsContract {

    interface View extends BaseView {
        @StateStrategyType(AddToEndSingleStrategy.class)
        void onSetTitleToolbar(@NonNull String title);

        @StateStrategyType(AddToEndSingleStrategy.class)
        void onSetTitleNews(@NonNull String titleNews);

        @StateStrategyType(AddToEndSingleStrategy.class)
        void onSetContentNews(@NonNull CharSequence contentNews);

        @StateStrategyType(AddToEndSingleStrategy.class)
        void onSetDateCreate(@NonNull String dateCreate);

        @StateStrategyType(AddToEndSingleStrategy.class)
        void onExit();
    }

    interface Presenter {
        void loadNewsById(@NonNull String id);

        void exit();

        void destroy();
    }

    interface Interactor {
        @NonNull
        Maybe<NewsInfo> getNewsById(@NonNull String id);
    }
}
