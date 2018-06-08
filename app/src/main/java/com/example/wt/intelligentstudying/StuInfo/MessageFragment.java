package com.example.wt.intelligentstudying.StuInfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wt.intelligentstudying.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    List<StuinfoMessage> stuinfoMessageList = new ArrayList<>();
    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    /*onActivityCreated方法中，Fragment已经和相应的Activity绑定，可以使用getActivity()获取对应的
     Activity，进而对布局进行操作*/

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initMessageList();
        RecyclerView recyclerView = getActivity().findViewById(R.id.fm_message_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        StuinfoMessageAdapter stuinfoMessageAdapter = new StuinfoMessageAdapter(stuinfoMessageList);
        recyclerView.setAdapter(stuinfoMessageAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
    //初始化信息列表
    public void initMessageList(){
        StuinfoMessage stuinfoMessage = new StuinfoMessage(R.drawable.bf,"高数老师-张雪峰",
                "2018/05/12");
        for(int i=0;i<3;i++){
            stuinfoMessageList.add(stuinfoMessage);
        }
    }
}
