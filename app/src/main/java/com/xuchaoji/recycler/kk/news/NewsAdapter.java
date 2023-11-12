package com.xuchaoji.recycler.kk.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.xuchaoji.recycler.kk.R;
import com.xuchaoji.recycler.kk.data.DataBean;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    private List<DataBean> dataBeans; // 存储新闻数据的列表
    private OnItemClickListener onItemClickListener; // 定义一个点击事件的接口

    // 构造方法，传入新闻数据的列表
    public NewsAdapter(List<DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    // 定义一个ViewHolder类，继承自RecyclerView.ViewHolder，用来存储每个item的视图
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView; // 显示新闻图片的ImageView
        TextView titleView; // 显示新闻标题的TextView
        TextView digestView; // 显示新闻摘要的TextView

        // 构造方法，传入每个item的视图
        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView); // 通过id找到ImageView
            titleView = view.findViewById(R.id.titleView); // 通过id找到TextView
            digestView = view.findViewById(R.id.digestView); // 通过id找到TextView
        }
    }

    // 定义一个点击事件的接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position); // 点击item时触发的方法
    }

    // 设置点击事件的监听器
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    // 创建ViewHolder时调用的方法，返回一个ViewHolder对象
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 从布局文件中加载每个item的视图
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        // 创建一个ViewHolder对象，传入视图
        ViewHolder holder = new ViewHolder(view);
        // 返回ViewHolder对象
        return holder;
    }

    // 绑定ViewHolder时调用的方法，用来设置每个item的数据和视图
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 从列表中获取对应位置的数据
        DataBean dataBean = dataBeans.get(position);
        // 使用Glide库，从图片链接中加载图片，设置到ImageView中
        Glide.with(holder.imageView.getContext()).load(dataBean.getImgsrc()).into(holder.imageView);
        // 设置TextView的文本为新闻的标题
        holder.titleView.setText(dataBean.getTitle());
        // 设置TextView的文本为新闻的摘要
        holder.digestView.setText(dataBean.getDigest());
        // 如果有设置点击事件的监听器，为每个item设置点击事件
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 调用接口的方法，传入视图和位置
                    onItemClickListener.onItemClick(v, position);
                }
            });
        }
    }

    // 获取item的数量，返回列表的大小
    @Override
    public int getItemCount() {
        return dataBeans.size();
    }
}
