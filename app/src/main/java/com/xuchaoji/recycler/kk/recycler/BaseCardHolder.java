package com.xuchaoji.recycler.kk.recycler;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xuchaoji.recycler.kk.R;

public class BaseCardHolder extends RecyclerView.ViewHolder {
    ImageView contentIv;

    public BaseCardHolder(@NonNull View itemView) {
        super(itemView);
        contentIv = itemView.findViewById(R.id.content_iv);
    }
}
