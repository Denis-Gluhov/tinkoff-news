package ru.trmedia.tinkoff_news.news;

import dagger.Subcomponent;

@NewsScreen
@Subcomponent(modules = NewsModule.class)
public interface NewsComponent {
    void inject(NewsPresenter newsPresenter);
}
