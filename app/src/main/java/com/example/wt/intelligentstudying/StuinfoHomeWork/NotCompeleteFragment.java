package com.example.wt.intelligentstudying.StuinfoHomeWork;


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
public class NotCompeleteFragment extends Fragment {

    List<HomeWork> list = new ArrayList<>();
    public NotCompeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_not_compelete, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initList();
        RecyclerView recyclerView = (RecyclerView)getActivity().findViewById(R.id.fm_not_compelete_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new HomeWorkAdapter(list));
    }

    public void initList(){
        HomeWork homeWork = new HomeWork("楚云飞",
                "操作系统","添加系统调用","2018/05/03");
        for(int i=0;i<8;i++){
            list.add(homeWork);
        }
    }

}
