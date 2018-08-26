package ru.trmedia.tinkoff_news.ui.news;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.trmedia.tinkoff_news.App;
import ru.trmedia.tinkoff_news.ui.BasePresenter;
import ru.trmedia.tinkoff_news.database.entity.News;

@InjectViewState
public class NewsPresenter extends BasePresenter<NewsContract.View> implements NewsContract.Presenter {

    @Inject
    NewsContract.Interactor interactor;

    NewsPresenter() {
        super();
        App.getInstance().createNewsComponent().inject(this);
    }

    @Override
    public void loadData() {
        if (compositeDisposable.size() == 0) {
            compositeDisposable.add(interactor.loadData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> getViewState().onShowLoadData())
                    .doAfterTerminate(() -> getViewState().onHideLoadData())
                    .subscribe(this::success, this::error));
        }
    }

    @Override
    public void error(@NonNull Throwable throwable) {
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
        super.destroy();
        App.getInstance().clearNewsComponent();
    }
}
