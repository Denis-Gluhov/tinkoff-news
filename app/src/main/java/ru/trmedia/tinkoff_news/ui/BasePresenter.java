package ru.trmedia.tinkoff_news.ui;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    @NonNull
    protected final CompositeDisposable compositeDisposable;

    public BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    public abstract void error(@NonNull Throwable throwable);

    public void destroy() {
        compositeDisposable.clear();
    }
}
