package ru.trmedia.tinkoff_news.ui.news;

import android.support.v7.util.DiffUtil;

import java.util.List;

import ru.trmedia.tinkoff_news.database.entity.News;

public class NewsDiffUtil extends DiffUtil.Callback {

    private final List<News> oldData;
    private final List<News> newData;

    NewsDiffUtil(List<News> oldData, List<News> newData) {
        this.oldData = oldData;
        this.newData = newData;
    }

    @Override
    public int getOldListSize() {
        if (oldData != null && !oldData.isEmpty())
            return oldData.size();
        else
            return 0;
    }

    @Override
    public int getNewListSize() {
        if (newData != null && !newData.isEmpty())
            return newData.size();
        else
            return 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        News oldItem = oldData.get(oldItemPosition);
        News newItem = newData.get(newItemPosition);
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return true;
    }
}
