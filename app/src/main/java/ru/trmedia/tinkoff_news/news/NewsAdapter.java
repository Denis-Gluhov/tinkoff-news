package ru.trmedia.tinkoff_news.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.trmedia.tinkoff_news.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    @NonNull
    private final Context context;

    public NewsAdapter(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {

        final TextView tvDatePublishNews;
        final TextView tvTitleNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDatePublishNews = itemView.findViewById(R.id.tvDatePublishNews);
            tvTitleNews = itemView.findViewById(R.id.tvTitleNews);
        }
    }
}
