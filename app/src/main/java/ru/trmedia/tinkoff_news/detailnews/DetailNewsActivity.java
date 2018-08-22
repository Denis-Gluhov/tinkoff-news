package ru.trmedia.tinkoff_news.detailnews;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.trmedia.tinkoff_news.R;

public class DetailNewsActivity extends MvpAppCompatActivity implements DetailNewsContract.View {

    @InjectPresenter
    DetailNewsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_new);
    }
}
