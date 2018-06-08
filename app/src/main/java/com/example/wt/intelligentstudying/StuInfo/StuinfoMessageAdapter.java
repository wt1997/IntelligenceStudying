package com.example.wt.intelligentstudying.StuInfo;

import android.content.pm.LabeledIntent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;

import java.util.List;

public class StuinfoMessageAdapter extends RecyclerView.Adapter<StuinfoMessageAdapter.StuinfoMessageHolder>{

    private List<StuinfoMessage> stuinfoMessageList;
    static class StuinfoMessageHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView sender;
        TextView time;
        public StuinfoMessageHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.stu_info_recycleview_item_image);
            sender = (TextView) view.findViewById(R.id.stu_info_recycleview_item_sender);
            time = (TextView)view.findViewById(R.id.stu_info_recycleview_item_time);
        }
    }
    @Override
    public StuinfoMessageHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.stu_info_message_iteam,parent,false);
        StuinfoMessageHolder stuinfoMessageHolder = new StuinfoMessageHolder(view);
        return stuinfoMessageHolder;
    }
    @Override
    public void onBindViewHolder(StuinfoMessageHolder stuinfoMessageHolder,int position){
        StuinfoMessage stuinfoMessage = stuinfoMessageList.get(position);
        stuinfoMessageHolder.time.setText(stuinfoMessage.getTime());
        stuinfoMessageHolder.sender.setText(stuinfoMessage.getSender());
        stuinfoMessageHolder.imageView.setImageResource(stuinfoMessage.getImage());
    }
    @Override
    public int getItemCount(){
        return stuinfoMessageList.size();
    }
    public StuinfoMessageAdapter(List<StuinfoMessage> list){
        this.stuinfoMessageList = list;
    }
}
