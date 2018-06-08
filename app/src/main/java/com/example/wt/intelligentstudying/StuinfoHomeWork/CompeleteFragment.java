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
public class CompeleteFragment extends Fragment {

    private List<HomeWork> homeWorkList = new ArrayList<>();
    public CompeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compelete, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initList();
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.fm_compelete_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new HomeWorkAdapter(homeWorkList));
    }

    public void initList(){
        HomeWork homeWork = new HomeWork("李云龙",
                "军事理论","考察济南解放阁","2015/04/03");
        for(int i=0;i<10;i++){
            homeWorkList.add(homeWork);
        }
    }
}
