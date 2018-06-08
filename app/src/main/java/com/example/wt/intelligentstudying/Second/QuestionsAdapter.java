package com.example.wt.intelligentstudying.Second;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionHolder> {

    List<Quenstion> quenstionsList;
    static class QuestionHolder extends RecyclerView.ViewHolder{
        TextView author;
        TextView time;
        TextView title;
        TextView contents;
        TextView num_agree;
        TextView num_diss;
        ImageView author_image;
        public QuestionHolder(View view){
            super(view);
            author = (TextView) view.findViewById(R.id.question_item_author);
            time = (TextView)view.findViewById(R.id.question_item_time);
            title = (TextView)view.findViewById(R.id.question_item_title);
            contents = (TextView)view.findViewById(R.id.question_item_contents);
            num_agree = (TextView)view.findViewById(R.id.question_item_num_agree);
            num_diss = (TextView)view.findViewById(R.id.question_item_num_diss);
            author_image = (ImageView)view.findViewById(R.id.question_item_author_image);
        }
    }
    @Override
    public QuestionHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.qusetion_item,
                parent,false);
        QuestionHolder questionHolder = new QuestionHolder(view);
        return questionHolder;
    }
    //将Question对象中的属性和ViewHolder中的变量进行绑定
    @Override
    public void onBindViewHolder(QuestionHolder questionHolder,int position){
        Quenstion quenstion = quenstionsList.get(position);
        questionHolder.author_image.setImageResource(quenstion.getAuthor_image());
        questionHolder.author.setText(quenstion.getAuthor());
        questionHolder.time.setText(quenstion.getTime());
        questionHolder.title.setText(quenstion.getTitle());
        questionHolder.contents.setText(quenstion.getContents());
        questionHolder.num_diss.setText(quenstion.getNum_diss()+"");
        questionHolder.num_agree.setText(quenstion.getNum_agree()+"");
        return;
    }
    @Override
    public int getItemCount(){
        return quenstionsList.size();
    }
    public QuestionsAdapter(List<Quenstion> quenstionsList){
        this.quenstionsList = quenstionsList;

    }
}
