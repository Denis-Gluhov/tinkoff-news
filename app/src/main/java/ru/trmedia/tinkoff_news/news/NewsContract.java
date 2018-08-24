package ru.trmedia.tinkoff_news.news;

import com.arellomobile.mvp.MvpView;

public interface NewsContract {

    interface View extends MvpView {

        void onShowLoading(boolean loading);

    }

    interface Presenter {

    }

    interface Interactor {

    }
}
