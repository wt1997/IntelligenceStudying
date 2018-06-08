package com.example.wt.intelligentstudying.StuInfo;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;
import com.example.wt.intelligentstudying.StuinfoHomeWork.CompeleteFragment;
import com.example.wt.intelligentstudying.StuinfoHomeWork.NotCompeleteFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment implements View.OnClickListener{

    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private TextView com;
    private TextView not_com;
    public TaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onStart(){
        super.onStart();
        fragmentManager = getChildFragmentManager();
        initView();
        initFragment();
        hideAndshow(0);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.fm_task_com:
                hideAndshow(0);
                break;
            case R.id.fm_task_not_com:
                hideAndshow(1);
                break;
        }
    }
    //初始化作业界面的子Fragment
    public void initFragment(){
        fragmentList.add(new CompeleteFragment());
        fragmentList.add(new NotCompeleteFragment());
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fm_task_framelayout,fragmentList.get(0));
        fragmentTransaction.add(R.id.fm_task_framelayout,fragmentList.get(1));
        fragmentTransaction.commit();
    }
    //初始化界面的组件
    public void initView(){
        com = (TextView) getActivity().findViewById(R.id.fm_task_com);
        not_com = (TextView) getActivity().findViewById(R.id.fm_task_not_com);
        com.setOnClickListener(this);
        not_com.setOnClickListener(this);
    }
    //将选择到的子Fragment显示出来
    public void hideAndshow(int position){
        hideFragment(fragmentTransaction,position);
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (position){
            case 0:
                setColor(position);
                fragmentTransaction.show(fragmentList.get(0));
                fragmentTransaction.commit();
                break;
            case 1:
                setColor(position);
                fragmentTransaction.show(fragmentList.get(1));
                fragmentTransaction.commit();
                break;
        }
    }
    //隐藏所有Fragment
    public void hideFragment(FragmentTransaction fragmentTransaction,int position){
        fragmentTransaction = fragmentManager.beginTransaction();
        for(int i=0;i<fragmentList.size();i++){
            fragmentTransaction.hide(fragmentList.get(i));
            Log.v("hide---","fragment---"+i);
        }
        fragmentTransaction.commit();
    }
    //
    public void setColor(int position){
        if(position == 1){
            not_com.setBackground(getResources().getDrawable(R.drawable.right_top_c1));
            not_com.setTextColor(getResources().getColor(R.color.white));
            com.setBackground(getResources().getDrawable(R.drawable.top_left_c2));
            com.setTextColor(getResources().getColor(R.color.black));
        }else{
            com.setBackground(getResources().getDrawable(R.drawable.top_left_c1));
            com.setTextColor(getResources().getColor(R.color.white));
            not_com.setBackground(getResources().getDrawable(R.drawable.right_top_c2));
            not_com.setTextColor(getResources().getColor(R.color.black));
        }
    }
}
