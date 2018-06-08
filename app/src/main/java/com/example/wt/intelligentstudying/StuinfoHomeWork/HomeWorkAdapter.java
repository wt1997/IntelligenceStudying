package com.example.wt.intelligentstudying.StuinfoHomeWork;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkAdapter extends RecyclerView.Adapter<HomeWorkAdapter.HomeWorkHolder>{
    List<HomeWork> list = new ArrayList<>();
    static class HomeWorkHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView course;
        TextView deadline;
        public HomeWorkHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.homework_item_title);
            course = (TextView) view.findViewById(R.id.homework_item_course);
            deadline = (TextView) view.findViewById(R.id.homework_item_deadline);
        }
    }
    @Override
    public HomeWorkHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homework_item,parent,false);
        return new HomeWorkHolder(view);
    }
    @Override
    public void onBindViewHolder(HomeWorkHolder homeWorkHolder,int position){
        HomeWork homeWork = list.get(position);
        homeWorkHolder.deadline.setText(homeWork.getDeadline());
        homeWorkHolder.course.setText(homeWork.getCourse());
        homeWorkHolder.title.setText(homeWork.getTitle());
    }
    @Override
    public int getItemCount(){
        return list.size();
    }
    public HomeWorkAdapter(List<HomeWork> list){
        this.list = list;
    }
}
