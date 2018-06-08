package com.example.wt.intelligentstudying.DocFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IT extends Fragment implements View.OnClickListener{

    private List<TextView> textViewList = new ArrayList<>();
    private TextView all;
    private TextView internet;
    private TextView computer;
    private TextView software;
    private TextView hardware;
    public IT() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_it, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initTextView();
    }
    @Override
    public void onStart(){
        super.onStart();
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.fm_it_all:
                setTextColor(0);
                break;
            case R.id.fm_it_internet:
                setTextColor(1);
                break;
            case R.id.fm_it_computer:
                setTextColor(2);
                break;
            case R.id.fm_it_software:
                setTextColor(3);
                break;
            case R.id.fm_it_hardware:
                setTextColor(4);
                break;
        }
    }
    public void setTextColor(int position){
        for(int i=0;i<textViewList.size();i++){
            if(i==position){
                textViewList.get(position).setTextColor(getResources().getColor(R.color.red_orange));
            }else{
                textViewList.get(i).setTextColor(getResources().getColor(R.color.black));
            }
        }
    }

    public void initTextView(){
        all = (TextView)getActivity().findViewById(R.id.fm_it_all);
        internet = (TextView)getActivity().findViewById(R.id.fm_it_internet);
        computer = (TextView)getActivity().findViewById(R.id.fm_it_computer);
        software = (TextView)getActivity().findViewById(R.id.fm_it_software);
        hardware = (TextView)getActivity().findViewById(R.id.fm_it_hardware);
        textViewList.add(all);
        textViewList.add(internet);
        textViewList.add(computer);
        textViewList.add(software);
        textViewList.add(hardware);
        textViewList.get(0).setTextColor(getResources().getColor(R.color.red_orange));
        all.setOnClickListener(this);
        internet.setOnClickListener(this);
        computer.setOnClickListener(this);
        software.setOnClickListener(this);
        hardware.setOnClickListener(this);
    }
}
