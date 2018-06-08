package com.example.wt.intelligentstudying.One;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wt.intelligentstudying.HomeWork.HomeWorkActivity;
import com.example.wt.intelligentstudying.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FunnyFragment extends Fragment implements View.OnClickListener{

    private View mView;
    public FunnyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_funny, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initTextView();
    }
    //findViewById，给LinerLayout设置监听器
    public void initTextView(){
        View SetHomeWorkReady = (View)getActivity().findViewById(R.id.set_home_ready);
        View CourseAsk = (View)getActivity().findViewById(R.id.course_ask);
        View InCourseHomeWork = (View)getActivity().findViewById(R.id.in_course_homework);
        View AfterCourseHomeWork = (View)getActivity().findViewById(R.id.after_course_homework);
        View CollectHomeWorkInfo = (View)getActivity().findViewById(R.id.collect_homework_info);
        SetHomeWorkReady.setOnClickListener(this);
        CourseAsk.setOnClickListener(this);
        InCourseHomeWork.setOnClickListener(this);
        AfterCourseHomeWork.setOnClickListener(this);
        CollectHomeWorkInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.set_home_ready:
                Intent intent0 = new Intent(getActivity(), HomeWorkActivity.class);
                intent0.putExtra("fm",0);
                startActivity(intent0);
                break;
            case R.id.course_ask:
                Intent intent1 = new Intent(getActivity(), HomeWorkActivity.class);
                intent1.putExtra("fm",1);
                startActivity(intent1);
                break;
            case R.id.in_course_homework:
                Intent intent2 = new Intent(getActivity(), HomeWorkActivity.class);
                intent2.putExtra("fm",2);
                startActivity(intent2);
                break;
            case R.id.after_course_homework:
                Intent intent3 = new Intent(getActivity(), HomeWorkActivity.class);
                intent3.putExtra("fm",3);
                startActivity(intent3);
                break;
            case R.id.collect_homework_info:
                Intent intent4 = new Intent(getActivity(), HomeWorkActivity.class);
                intent4.putExtra("fm",4);
                startActivity(intent4);
                break;
        }
    }

}
