package com.example.wt.intelligentstudying.StuInfo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wt.intelligentstudying.R;

import java.util.ArrayList;
import java.util.List;


public class StudyFragment extends Fragment {
    private List<Team> list;
    public StudyFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initList();
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.study_fm_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        TeamAdapter teamAdapter = new TeamAdapter(list);
        recyclerView.setAdapter(teamAdapter);
    }
    private void initList(){
        list = new ArrayList<>();
        String name = "毛概第一小组";
        String teacher = "任是非";
        List<String> teamer = new ArrayList<>();
        teamer.add("王晓明");
        teamer.add("白月初");
        teamer.add("保剑锋");
        teamer.add("心未泯");
        teamer.add("留沙");
        Team team = new Team(name,teamer,teacher);
        for(int i=0;i<4;i++){
            list.add(team);
        }
    }
}
