package com.example.wt.intelligentstudying.DocFragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerHolder>{

    List<Answer> list;
    public static class AnswerHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        TextView an;
        public AnswerHolder(View v){
            super(v);
            imageView = v.findViewById(R.id.answer_item_iv);
            name = v.findViewById(R.id.answer_item_name);
            an = v.findViewById(R.id.answer_item_content);
        }
    }
    @Override
    public AnswerHolder onCreateViewHolder(ViewGroup parent,int viewType){
        return  new AnswerHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.answer_item,parent,false));
    }
    @Override
    public void onBindViewHolder(AnswerHolder answerHolder,int position){
        Answer answer = list.get(position);
        answerHolder.imageView.setImageResource(answer.getImageView());
        answerHolder.name.setText(answer.getName());
        answerHolder.an.setText(answer.getAnswer());
    }
    @Override
    public int getItemCount(){
        return list.size();
    }
    public AnswerAdapter(List<Answer> list){
        this.list = list;
    }
}
