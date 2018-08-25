package ru.trmedia.tinkoff_news.news;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.trmedia.tinkoff_news.App;
import ru.trmedia.tinkoff_news.database.entity.News;

@InjectViewState
public class NewsPresenter extends MvpPresenter<NewsContract.View> implements NewsContract.Presenter {

    @Inject
    NewsContract.Interactor interactor;

    private final CompositeDisposable compositeDisposable;

    NewsPresenter() {
        App.getInstance().createNewsComponent().inject(this);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void loadData() {
            compositeDisposable.add(interactor.loadData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> getViewState().onShowLoading(true))
                    .doAfterTerminate(() -> getViewState().onShowLoading(false))
                    .subscribe(this::success, this::error));
    }

    private void error(@NonNull Throwable throwable) {
        compositeDisposable.clear();
        getViewState().onShowMessage(throwable.getMessage());
    }

    private void success(@NonNull List<News> news) {
        compositeDisposable.clear();
        getViewState().onSetData(news);
    }

    @Override
    public void selectedItem(@NonNull String id) {
        getViewState().onShowDetailNews(id);
    }

    @Override
    public void destroy() {
        compositeDisposable.clear();
        App.getInstance().clearNewsComponent();
    }
}
