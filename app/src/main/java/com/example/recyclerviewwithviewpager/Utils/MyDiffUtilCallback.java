package com.example.recyclerviewwithviewpager.Utils;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class MyDiffUtilCallback extends DiffUtil.Callback {
    List<String> oldData;
    List<String> newData;

    public MyDiffUtilCallback(List<String> oldData, List<String> newData) {
        this.oldData = oldData;
        this.newData = newData;
    }

    @Override
    public int getOldListSize() {
        return oldData.size();
    }

    @Override
    public int getNewListSize() {
        return newData.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemPosition==newItemPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldData.get(oldItemPosition)==newData.get(newItemPosition);
    }
}
