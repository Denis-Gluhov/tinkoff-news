package ru.trmedia.tinkoff_news.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.trmedia.tinkoff_news.R;
import ru.trmedia.tinkoff_news.database.entity.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    interface NewsAdapterListener {
        void onItemClick(@NonNull String id);
    }

    @NonNull
    private final Context context;
    @NonNull
    private final NewsAdapterListener listener;

    private List<News> data;

    NewsAdapter(@NonNull Context context) {
        this.context = context;
        listener = (NewsAdapterListener) context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        final News news = data.get(i);
        newsViewHolder.tvDatePublishNews.setText(news.convertPublicationDate());
        newsViewHolder.tvTitleNews.setText(news.getText());
        newsViewHolder.cvNews.setOnClickListener(view -> listener.onItemClick(news.getId()));
    }

    @Override
    public int getItemCount(){
        if (data != null && !data.isEmpty())
            return data.size();
        else
            return 0;
    }

    public void setData(@NonNull List<News> data) {
        this.data = data;
    }

    public List<News> getData() {
        return data;
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {

        final CardView cvNews;
        final TextView tvDatePublishNews;
        final TextView tvTitleNews;

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            cvNews = itemView.findViewById(R.id.cvNews);
            tvDatePublishNews = itemView.findViewById(R.id.tvDatePublishNews);
            tvTitleNews = itemView.findViewById(R.id.tvTitleNews);
        }
    }
}
