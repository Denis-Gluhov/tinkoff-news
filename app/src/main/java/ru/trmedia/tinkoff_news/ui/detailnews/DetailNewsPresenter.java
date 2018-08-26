package ru.trmedia.tinkoff_news.ui.detailnews;

import android.support.annotation.NonNull;
import android.text.Html;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.trmedia.tinkoff_news.App;
import ru.trmedia.tinkoff_news.database.entity.NewsInfo;
import ru.trmedia.tinkoff_news.ui.BasePresenter;

@InjectViewState
public class DetailNewsPresenter extends BasePresenter<DetailNewsContract.View>
        implements DetailNewsContract.Presenter {

    @Inject
    DetailNewsContract.Interactor interactor;

    DetailNewsPresenter() {
        super();
        App.getInstance().createDetailNewsComponent().inject(this);
    }

    @Override
    public void loadNewsById(@NonNull String id) {
        if (compositeDisposable.size() == 0) {
            compositeDisposable.add(interactor.getNewsById(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> getViewState().onShowLoadData())
                    .doAfterTerminate(getViewState()::onHideLoadData)
                    .subscribe(this::success, this::error));
        }
    }

    @Override
    public void error(@NonNull Throwable throwable) {
        compositeDisposable.clear();
        getViewState().onShowMessage(throwable.getMessage());
    }

    private void success(@NonNull NewsInfo newsInfo) {
        compositeDisposable.clear();
        getViewState().onSetTitleToolbar(newsInfo.getName());
        getViewState().onSetTitleNews(newsInfo.getText());
        getViewState().onSetContentNews(Html.fromHtml(newsInfo.getContent()));
        getViewState().onSetDateCreate(newsInfo.convertPublicationDate());
    }

    @Override
    public void exit() {
        getViewState().onExit();
    }

    @Override
    public void destroy() {
        super.destroy();
        App.getInstance().clearDetailNewsComponent();
    }
}
