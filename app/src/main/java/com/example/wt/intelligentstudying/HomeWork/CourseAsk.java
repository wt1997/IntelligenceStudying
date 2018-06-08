package com.example.wt.intelligentstudying.HomeWork;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wt.intelligentstudying.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseAsk extends Fragment {


    public CourseAsk() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_ask, container, false);
    }

}
