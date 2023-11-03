package com.xuchaoji.recycler.kk.recycler;

import static com.xuchaoji.recycler.kk.activity.MainActivity.IMG_COUNT;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xuchaoji.recycler.kk.R;
import com.xuchaoji.recycler.kk.data.CardData;
import com.xuchaoji.recycler.kk.utils.CommonUtil;
import com.xuchaoji.recycler.kk.utils.SensorUtil;

import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

public class KKAdapter extends RecyclerView.Adapter<BaseCardHolder> {
    private List<CardData> cardDataList;

    private int preId;

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
        int id = CommonUtil.randomBetween(0, IMG_COUNT - 1, preId);
        preId = id;
        CardData cardData = cardDataList.get(id);
        if (cardData == null) {
            return;
        }
        Context context = holder.itemView.getContext();
        holder.contentIv.setImageDrawable(cardData.getContentDrawable(context));
        SensorUtil.vibrate(context, 15);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
