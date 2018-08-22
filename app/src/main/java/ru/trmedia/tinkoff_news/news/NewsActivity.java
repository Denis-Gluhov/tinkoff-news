package ru.trmedia.tinkoff_news.news;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.trmedia.tinkoff_news.R;

public class NewsActivity extends MvpAppCompatActivity implements NewsContract.View {

    @InjectPresenter
    NewsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }
}
