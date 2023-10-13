package com.xuchaoji.recycler.kk.data;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.xuchaoji.recycler.kk.R;

public class CardData {
    private int contentId;


    public CardData(int contentId) {
        this.contentId = contentId;
    }

    public Drawable getContentDrawable(Context context) {
        if (context == null) {
            return null;
        }
        Drawable drawable = context.getResources().getDrawable(contentId, null);
        return drawable;
    }
}
