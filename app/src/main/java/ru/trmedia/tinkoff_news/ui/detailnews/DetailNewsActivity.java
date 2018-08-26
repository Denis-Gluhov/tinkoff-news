package ru.trmedia.tinkoff_news.ui.detailnews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.trmedia.tinkoff_news.R;

public class DetailNewsActivity extends MvpAppCompatActivity implements DetailNewsContract.View {

    private static final String NEWS_ID = "idNews";

    @InjectPresenter
    DetailNewsPresenter presenter;

    private Toolbar tbDetailNews;
    private LinearLayout llLoadPanel;
    private ScrollView svDataPanel;
    private TextView tvTitle;
    private TextView tvContent;
    private TextView tvDateCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_new);
        initUi();
        presenter.loadNewsById(getIntent().getStringExtra(NEWS_ID));
    }

    private void initUi() {
        tbDetailNews = findViewById(R.id.tbDetailNews);
        tbDetailNews.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_white_24dp));
        tbDetailNews.setNavigationOnClickListener(view -> presenter.exit());

        llLoadPanel = findViewById(R.id.llLoadPanel);
        svDataPanel = findViewById(R.id.svDataPanel);

        tvTitle = findViewById(R.id.tvTitle);
        tvContent = findViewById(R.id.tvContent);
        tvDateCreate = findViewById(R.id.tvDateCreate);
    }

    @Override
    public void onShowLoadData() {
        svDataPanel.setVisibility(View.GONE);
        llLoadPanel.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideLoadData() {
        llLoadPanel.setVisibility(View.GONE);
        svDataPanel.setVisibility(View.VISIBLE);
    }

    @Override
    public void onShowMessage(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSetTitleToolbar(@NonNull String title) {
        tbDetailNews.setTitle(title);
    }

    @Override
    public void onSetTitleNews(@NonNull String titleNews) {
        tvTitle.setText(titleNews);
    }

    @Override
    public void onSetContentNews(@NonNull CharSequence contentNews) {
        tvContent.setText(contentNews);
    }

    @Override
    public void onSetDateCreate(@NonNull String dateCreate) {
        tvDateCreate.setText(dateCreate);
    }

    @Override
    public void onExit() {
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}