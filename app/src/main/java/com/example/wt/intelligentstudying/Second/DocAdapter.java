package com.example.wt.intelligentstudying.Second;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;

import java.util.List;

public class DocAdapter extends RecyclerView.Adapter<DocAdapter.DocHolder>{
    List<Doc> docList;
    static class DocHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView author;
        TextView time;
        public DocHolder(View view){
            super(view);
            name = (TextView)view.findViewById(R.id.fm_doc_doc_name);
            author = (TextView)view.findViewById(R.id.fm_doc_doc_author);
            time = (TextView)view.findViewById(R.id.fm_doc_doc_time);
        }
    }
    @Override
    public DocHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fm_doc_doc_item,
                parent,false);
        DocHolder docHolder = new DocHolder(view);
        return docHolder;
    }
    //将Doc对象中的属性和ViewHolder中的变量进行绑定
    @Override
    public void onBindViewHolder(DocHolder docHolder,int position){
        Doc doc = docList.get(position);
        docHolder.time.setText(doc.getDoc_time());
        docHolder.author.setText(doc.getDoc_author());
        docHolder.name.setText(doc.getDoc_name());
    }
    @Override
    public int getItemCount(){
        return docList.size();
    }
    public DocAdapter(List<Doc> docList){
        this.docList = docList;
    }
}
