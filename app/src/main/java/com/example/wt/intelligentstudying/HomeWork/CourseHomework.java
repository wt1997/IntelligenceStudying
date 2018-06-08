package com.example.wt.intelligentstudying.HomeWork;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wt.intelligentstudying.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseHomework extends Fragment implements AdapterView.OnItemSelectedListener{

    public CourseHomework() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_homework, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initSpinner();
    }
    private void initSpinner(){
        Spinner TeamOrPerson = getActivity().findViewById(R.id.fch_team_or_person);
        Spinner SelectPerson = getActivity().findViewById(R.id.fch_select_person);
        ArrayAdapter arrayAdapter1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.select_team_or_person,R.layout.spinner_textview);
        ArrayAdapter arrayAdapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.select_person_sort,R.layout.spinner_textview);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TeamOrPerson.setAdapter(arrayAdapter1);
        SelectPerson.setAdapter(arrayAdapter2);
        TeamOrPerson.setOnItemSelectedListener(this);
        SelectPerson.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent,View view,
                               int position,long id){
        String str = parent.getItemAtPosition(position).toString();
        Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }
}
