package com.example.wt.intelligentstudying.Second;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.wt.intelligentstudying.R;

import java.util.ArrayList;
import java.util.List;

public class ExcellentItemAdapter extends RecyclerView.Adapter<ExcellentItemAdapter.ExcellentViewHolder>{

    List<ExcellentPage> list = new ArrayList<>();
    static class ExcellentViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        TextView author;
        ImageView imageView;
        public ExcellentViewHolder(View view){
            super(view);
            text = (TextView) view.findViewById(R.id.excellent_recyclerview_item_text);
            author = (TextView) view.findViewById(R.id.excellent_recyclerview_item_author);
            imageView = (ImageView)view.findViewById(R.id.excellent_recyclerview_item_image);
        }
    }
    @Override
    public ExcellentViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.excellent_recyclerview_item,parent,false);
        ExcellentViewHolder excellentViewHolder = new ExcellentViewHolder(view);
        return excellentViewHolder;
    }
    @Override
    public void onBindViewHolder(ExcellentViewHolder holder,int position){
        ExcellentPage excellentPage = list.get(position);
        holder.imageView.setImageResource(excellentPage.getPage_image());
        holder.author.setText(excellentPage.getAuthor());
        holder.text.setText(excellentPage.getPage_text());

    }
    @Override
    public int getItemCount(){
        return list.size();
    }
    public ExcellentItemAdapter(List<ExcellentPage> list){
        this.list = list;
    }
}

