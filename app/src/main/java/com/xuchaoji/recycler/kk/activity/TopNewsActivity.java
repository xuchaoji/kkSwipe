package com.xuchaoji.recycler.kk.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xuchaoji.recycler.kk.R;
import com.xuchaoji.recycler.kk.data.DataBean;
import com.xuchaoji.recycler.kk.news.NewsAdapter;

import java.util.List;

public class TopNewsActivity extends BaseActivity {
    private static final String TAG = "TopNewsActivity";

    private RecyclerView recyclerView; // 定义一个recyclerView对象
    private NewsAdapter newsAdapter; // 定义一个newsAdapter对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news); // 设置布局文件为activity_main

        // 通过id找到recyclerView
        recyclerView = findViewById(R.id.news_recycler);
        // 设置recyclerView的布局管理器为线性布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 定义一个字符串，存储返回的内容
        String response = "{\"BA10TA81wangning\":[{\"title\":\"王祖贤回应复出传闻\",\"digest\":\"王祖贤回应复出传闻，称自己没有复出的打算，只是偶尔参与一些公益活动。\",\"imgsrc\":\"http://cms-bucket.ws.126.net/2023/11/12/6f8f0c1b9a7a4e5f9b2d8c3a1b8a9f0f.png\",\"url\":\"https://3g.163.com/touch/article/BA10TA81wangning/1-20.html\"},{\"title\":\"陈晓晒与陈妍希合照\",\"digest\":\"陈晓晒与陈妍希合照，两人甜蜜相拥，网友纷纷送上祝福。\",\"imgsrc\":\"http://cms-bucket.ws.126.net/2023/11/12/7f9d0c1b9a7a4e5f9b2d8c3a1b8a9f0f.png\",\"url\":\"https://3g.163.com/touch/article/BA10TA81wangning/2-20.html\"},...,{\"title\":\"汪小菲晒女儿萌照\",\"digest\":\"汪小菲晒女儿萌照，称自己是幸福的爸爸，网友评论道：小酒窝太可爱了。\",\"imgsrc\":\"http://cms-bucket.ws.126.net/2023/11/12/9f8f0c1b9a7a4e5f9b2d8c3a1b8a9f0f.png\",\"url\":\"https://3g.163.com/touch/article/BA10TA81wangning/20-20.html\"}]}";
        // 使用Gson库，将字符串转换成一个List<DataBean>的对象
        Gson gson = new Gson();
        List<DataBean> dataBeans = gson.fromJson(response, new TypeToken<List<DataBean>>(){}.getType());
        // 创建一个newsAdapter对象，传入新闻数据的列表
        newsAdapter = new NewsAdapter(dataBeans);
        // 设置recyclerView的适配器为newsAdapter
        recyclerView.setAdapter(newsAdapter);
        // 设置newsAdapter的点击事件的监听器
        newsAdapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // 获取点击的新闻的详情链接
                String url = dataBeans.get(position).getUrl();
                // 跳转浏览器，显示新闻的详情
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(url);
                intent.setData(content_url);
                startActivity(intent);
            }
        });
    }

}
