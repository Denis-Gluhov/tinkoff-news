package ru.trmedia.tinkoff_news.detailnews;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class DetailNewsPresenter extends MvpPresenter<DetailNewsContract.View> implements DetailNewsContract.Presenter {

    public DetailNewsPresenter() {
    }
}
