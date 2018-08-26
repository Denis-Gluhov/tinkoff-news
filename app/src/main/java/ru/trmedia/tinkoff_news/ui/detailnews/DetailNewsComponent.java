package ru.trmedia.tinkoff_news.ui.detailnews;

import dagger.Subcomponent;

@DetailNewsScreen
@Subcomponent(modules = DetailNewsModule.class)
public interface DetailNewsComponent {
    void inject(DetailNewsPresenter detailNewsPresenter);
}
