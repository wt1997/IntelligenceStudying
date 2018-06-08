package com.example.wt.intelligentstudying.Second;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wt.intelligentstudying.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlockFragment extends Fragment {

    List<Quenstion> quenstionList = new ArrayList<>();
    RecyclerView recyclerView;

    public BlockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_block, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initQusetionList();
        recyclerView = getActivity().findViewById(R.id.fm_block_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        QuestionsAdapter questionsAdapter = new QuestionsAdapter(quenstionList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(questionsAdapter);
    }
    //Block版块Item的点击事件
    public void onBlockItemClick(View view){
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
    }
    public void initQusetionList(){
        String author = "西北狼发表了问题 ";
        String time = "1天前 ";
        int authorImage = R.color.blue;
        int num_agree = 28;
        int num_diss = 4;
        String title = "Android圆形ImageView的实现";
        String contents = "西北狼：Android如何实现圆形的ImageView控件？在今天的开发中模仿知乎上牛客网的" +
                "信息发表栏时，遇到圆形ImageView控件,在尝试使用coner设置圆角边距失败后，" +
                "还没有好的解决方法，请大佬指点。";
        Quenstion q1 = new Quenstion(author,time,title,contents,num_agree,num_diss,authorImage);
        for(int i=0;i<10;i++){
            quenstionList.add(q1);
        }
    }
}
