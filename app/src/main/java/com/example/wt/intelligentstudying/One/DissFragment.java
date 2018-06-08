package com.example.wt.intelligentstudying.One;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;
import com.example.wt.intelligentstudying.Second.Second_Main;


/**
 * A simple {@link Fragment} subclass.
 */
public class DissFragment extends Fragment implements View.OnClickListener{


    public DissFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diss, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        TextView excellent = getActivity().findViewById(R.id.diss_excellent);
        TextView block = getActivity().findViewById(R.id.diss_block);
        TextView doc = getActivity().findViewById(R.id.diss_doc);
        excellent.setOnClickListener(this);
        block.setOnClickListener(this);
        doc.setOnClickListener(this);
    }
    //在此监听点击的TextView，跳转到相应的Fragment
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.diss_block:
                Intent intent0 = new Intent(getActivity(), Second_Main.class);
                intent0.putExtra("start_fm",0);
                startActivity(intent0);
                break;
            case R.id.diss_excellent:
                Intent intent1 = new Intent(getActivity(), Second_Main.class);
                intent1.putExtra("start_fm",1);
                startActivity(intent1);
                break;
            case R.id.diss_doc:
                Intent intent2 = new Intent(getActivity(), Second_Main.class);
                intent2.putExtra("start_fm",2);
                startActivity(intent2);
                break;
        }
    }

}
