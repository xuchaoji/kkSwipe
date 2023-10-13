package com.xuchaoji.recycler.kk.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xuchaoji.recycler.kk.R;
import com.xuchaoji.recycler.kk.data.CardData;

import java.util.List;
import java.util.zip.Inflater;

public class KKAdapter extends RecyclerView.Adapter<BaseCardHolder> {
    private List<CardData> cardDataList;

    public KKAdapter(List<CardData> cardDataList) {
        this.cardDataList = cardDataList;
    }

    @NonNull
    @Override
    public BaseCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseCardHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseCardHolder holder, int position) {
        CardData cardData = cardDataList.get(position % 10);
        if (cardData == null) {
            return;
        }
        Context context = holder.itemView.getContext();
        holder.contentIv.setImageDrawable(cardData.getContentDrawable(context));
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
