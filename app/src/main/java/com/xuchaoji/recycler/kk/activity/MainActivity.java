package com.xuchaoji.recycler.kk.activity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xuchaoji.recycler.kk.R;
import com.xuchaoji.recycler.kk.data.CardData;
import com.xuchaoji.recycler.kk.recycler.KKAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private RecyclerView recyclerView;

    private KKAdapter kkAdapter;
    private List<CardData> cardDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestScreenOn();
        hideActionStatusBar();
        hideBottomViews();
        setContentView(R.layout.activity_main);
        initDataList();
        initAdapter();
    }

    private void initDataList() {
        cardDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int resId = getResources().getIdentifier("an_" + i, "drawable", getPackageName());
            CardData cardData = new CardData(resId);
            cardDataList.add(cardData);
        }
    }

    private void initAdapter() {
        recyclerView = findViewById(R.id.re_view);
        kkAdapter = new KKAdapter(cardDataList);
        recyclerView.setAdapter(kkAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}