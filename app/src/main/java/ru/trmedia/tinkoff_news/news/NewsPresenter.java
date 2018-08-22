package ru.trmedia.tinkoff_news.news;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class NewsPresenter extends MvpPresenter<NewsContract.View> implements NewsContract.Presenter {

    public NewsPresenter() {
    }
}
