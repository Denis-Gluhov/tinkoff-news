package ru.trmedia.tinkoff_news.news;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.trmedia.tinkoff_news.R;

public class NewsActivity extends MvpAppCompatActivity implements NewsContract.View {

    @InjectPresenter
    NewsPresenter presenter;

    private Toolbar tbNews;
    private SwipeRefreshLayout rlUpdateData;
    private RecyclerView rvNews;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initUi();
    }

    private void initUi() {
        tbNews = findViewById(R.id.tbNews);
        tbNews.setTitle("Tinkoff news");

        rlUpdateData = findViewById(R.id.rlUpdateData);
        rlUpdateData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        rvNews = findViewById(R.id.rvNews);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsAdapter(this);
        rvNews.setAdapter(adapter);
    }

    @Override
    public void onShowLoading(boolean loading) {
        rlUpdateData.setRefreshing(loading);
    }
}
