package ru.trmedia.tinkoff_news.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import ru.trmedia.tinkoff_news.R;
import ru.trmedia.tinkoff_news.database.entity.News;
import ru.trmedia.tinkoff_news.detailnews.DetailNewsActivity;

public class NewsActivity extends MvpAppCompatActivity implements NewsContract.View,
        NewsAdapter.NewsAdapterListener {

    private static final String NEWS_ID = "idNews";

    @InjectPresenter
    NewsPresenter presenter;

    private SwipeRefreshLayout rlUpdateData;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initUi();
        presenter.loadData();
    }

    private void initUi() {
        Toolbar tbNews = findViewById(R.id.tbNews);
        tbNews.setTitle("Tinkoff news");

        rlUpdateData = findViewById(R.id.rlUpdateData);
        rlUpdateData.setOnRefreshListener(() -> presenter.loadData());

        RecyclerView rvNews = findViewById(R.id.rvNews);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsAdapter(this);
        rvNews.setAdapter(adapter);
    }

    @Override
    public void onSetData(@NonNull List<News> data) {
        NewsDiffUtil newsDiffUtil = new NewsDiffUtil(adapter.getData(), data);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(newsDiffUtil);
        adapter.setData(data);
        diffResult.dispatchUpdatesTo(adapter);
    }

    @Override
    public void onShowLoading(boolean loading) {
        rlUpdateData.setRefreshing(loading);
    }

    @Override
    public void onItemClick(@NonNull String id) {
        presenter.selectedItem(id);
    }

    @Override
    public void onShowMessage(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    @Override
    public void onShowDetailNews(@NonNull String id) {
        Intent intentDetailNews = new Intent(this, DetailNewsActivity.class);
        intentDetailNews.putExtra(NEWS_ID, id);
        startActivity(intentDetailNews);
    }
}
