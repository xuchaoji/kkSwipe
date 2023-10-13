package com.xuchaoji.recycler.kk.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public class LoopLayoutManager extends RecyclerView.LayoutManager {
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }
}
