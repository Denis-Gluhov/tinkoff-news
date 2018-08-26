package ru.trmedia.tinkoff_news.ui;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void onShowLoadData();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void onHideLoadData();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void onShowMessage(@NonNull String message);
}
