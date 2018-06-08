package com.example.wt.intelligentstudying.One;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wt.intelligentstudying.HomeWork.HomeWorkActivity;
import com.example.wt.intelligentstudying.R;
import com.example.wt.intelligentstudying.Second.Second_Main;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment implements View.OnClickListener{

    List<View> viewList = new ArrayList<>();
    public StudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_student_info, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceSate){
        super.onActivityCreated(savedInstanceSate);
        initView();
    }
    public void initView(){
        View stu_info = (View)getActivity().findViewById(R.id.stu_info_info);
        View stu_message = (View)getActivity().findViewById(R.id.stu_info_messsage);
        View stu_mycourse = (View)getActivity().findViewById(R.id.stu_info_mycourse);
        View stu_myhomework = (View)getActivity().findViewById(R.id.stu_info_myhomework);
        View stu_set = (View)getActivity().findViewById(R.id.stu_info_set);
        View stu_mystu_team = (View)getActivity().findViewById(R.id.stu_info_study_team);
        viewList.add(stu_info);
        viewList.add(stu_message);
        viewList.add(stu_mycourse);
        viewList.add(stu_myhomework);
        viewList.add(stu_set);
        viewList.add(stu_mystu_team);
        for(int i=0;i<viewList.size();i++){
            viewList.get(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.stu_info_info:
                Intent intent1 = new Intent(getActivity(), Second_Main.class);
                intent1.putExtra("start_fm",3);
                startActivity(intent1);
                Log.v("TAG---","you click it");
                break;
            case R.id.stu_info_messsage:
                Intent intent2 = new Intent(getActivity(), Second_Main.class);
                intent2.putExtra("start_fm",4);
                startActivity(intent2);
                break;
            case R.id.stu_info_mycourse:
                Intent intent3 = new Intent(getActivity(), Second_Main.class);
                intent3.putExtra("start_fm",5);
                startActivity(intent3);
                break;
            case R.id.stu_info_study_team:
                Intent intent4 = new Intent(getActivity(), Second_Main.class);
                intent4.putExtra("start_fm",6);
                startActivity(intent4);
                break;
            case R.id.stu_info_myhomework:
                Intent intent5 = new Intent(getActivity(), Second_Main.class);
                intent5.putExtra("start_fm",7);
                startActivity(intent5);
                break;
            case R.id.stu_info_set:
                Intent intent6 = new Intent(getActivity(), Second_Main.class);
                intent6.putExtra("start_fm",8);
                startActivity(intent6);
                break;
        }
    }
}
