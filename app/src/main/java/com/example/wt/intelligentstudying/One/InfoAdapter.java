package com.example.wt.intelligentstudying.One;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder>{
    private List<News> newsList;
    public static int ImageSize;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView newsImage;
        TextView newsText;
        public ViewHolder(View view){
            super(view);
            newsText = (TextView)view.findViewById(R.id.new_info);
            newsImage = (ImageView)view.findViewById(R.id.news_png);
            ImageSize = newsImage.getWidth();
        }
    }
    public InfoAdapter(List<News> newsList){
        this.newsList = newsList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item,parent,false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        News news = newsList.get(position);
        holder.newsImage.setImageResource(news.getImageId());
        holder.newsText.setText(news.getNewsInfo());
    }
    @Override
    public int getItemCount(){
        return newsList.size();
    }
    public int getImageSize(){
        return ImageSize;
    }
}
