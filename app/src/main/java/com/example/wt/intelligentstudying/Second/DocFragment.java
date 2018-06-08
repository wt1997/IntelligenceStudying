package com.example.wt.intelligentstudying.Second;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wt.intelligentstudying.DocFragment.Enginner;
import com.example.wt.intelligentstudying.DocFragment.Humanistic;
import com.example.wt.intelligentstudying.DocFragment.IT;
import com.example.wt.intelligentstudying.DocFragment.Medical;
import com.example.wt.intelligentstudying.DocFragment.Natural;
import com.example.wt.intelligentstudying.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DocFragment extends Fragment implements View.OnClickListener{

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<TextView> textViewList = new ArrayList<>();
    private TextView IT;
    private TextView Humanistic;
    private TextView Enginner;
    private TextView Natural;
    private TextView Medical;
    private FragmentManager fragmentManager;
    private int Last_Click = 0;
    private int Now_Click = 0;
    private FragmentTransaction fragmentTransaction;
    private List<Doc> docList = new ArrayList<>();

    public DocFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doc, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initList();
        initView();
    }
    @Override
    public void onStart(){
        super.onStart();
        fragmentManager = getChildFragmentManager();
        initFragment();
        hideAndshow(0);
        IT.setBackgroundColor(getResources().getColor(R.color.white));
        IT.setTextColor(getResources().getColor(R.color.red_orange));
        IT.setOnClickListener(this);
        Humanistic.setOnClickListener(this);
        Enginner.setOnClickListener(this);
        Natural.setOnClickListener(this);
        Medical.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.IT:
                setBackgroundColor(0);
                hideAndshow(0);
                break;
            case R.id.Humanistic:
                setBackgroundColor(1);
                hideAndshow(1);
                break;
            case R.id.Engineer:
                setBackgroundColor(2);
                hideAndshow(2);
                break;
            case R.id.Natural:
                setBackgroundColor(3);
                hideAndshow(3);
                break;
            case R.id.Medical:
                setBackgroundColor(4);
                hideAndshow(4);
                break;
        }
    }
    private void replaceFragment(int position){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fm_doc_sort_fm,fragmentList.get(position));
        fragmentTransaction.commit();
    }
    public void hideAndshow(int position){
        hideFragment(fragmentTransaction,position);
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (position){
            case 0:
                fragmentTransaction.show(fragmentList.get(0));
                fragmentTransaction.commit();
                Log.v("Positon 0","show !!");
                break;
            case 1:
                fragmentTransaction.show(fragmentList.get(1));
                fragmentTransaction.commit();
                Log.v("Positon 1","show !!");
                break;
            case 2:
                fragmentTransaction.show(fragmentList.get(2));
                fragmentTransaction.commit();
                Log.v("Positon 2","show !!");
                break;
            case 3:
                fragmentTransaction.show(fragmentList.get(3));
                fragmentTransaction.commit();
                Log.v("Positon 3","show !!");
                break;
            case 4:
                fragmentTransaction.show(fragmentList.get(4));
                fragmentTransaction.commit();
                Log.v("Positon 4","show !!");
                break;
        }
    }
    public void hideFragment(FragmentTransaction fragmentTransaction,int position){
        fragmentTransaction = fragmentManager.beginTransaction();
        for(int i=0;i<fragmentList.size();i++){
            fragmentTransaction.hide(fragmentList.get(i));
            Log.v("hide---","fragment---"+i);
        }
        fragmentTransaction.commit();
    }
    private void initFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentList.add(new IT());
        fragmentList.add(new Humanistic());
        fragmentList.add(new Enginner());
        fragmentList.add(new Natural());
        fragmentList.add(new Medical());
        fragmentTransaction.add(R.id.fm_doc_sort_fm,fragmentList.get(0));
        fragmentTransaction.add(R.id.fm_doc_sort_fm,fragmentList.get(1));
        fragmentTransaction.add(R.id.fm_doc_sort_fm,fragmentList.get(2));
        fragmentTransaction.add(R.id.fm_doc_sort_fm,fragmentList.get(3));
        fragmentTransaction.add(R.id.fm_doc_sort_fm,fragmentList.get(4));
        fragmentTransaction.commit();
    }
    private void setBackgroundColor(int position){
        for(int i=0;i<textViewList.size();i++){
            if(i==position){
                textViewList.get(position).setBackgroundColor(getResources().getColor(R.color.white));
                textViewList.get(position).setTextColor(getResources().getColor(R.color.red_orange));
            }else{
                textViewList.get(i).setBackgroundColor(getResources().getColor(R.color.AndroidWhite));
                textViewList.get(i).setTextColor(getResources().getColor(R.color.black));
            }
        }
    }
    public void initView(){
        IT = (TextView)getActivity().findViewById(R.id.IT);
        Humanistic = (TextView)getActivity().findViewById(R.id.Humanistic);
        Enginner = (TextView)getActivity().findViewById(R.id.Engineer);
        Natural = (TextView)getActivity().findViewById(R.id.Natural);
        Medical = (TextView)getActivity().findViewById(R.id.Medical);
        textViewList.add(IT);
        textViewList.add(Humanistic);
        textViewList.add(Enginner);
        textViewList.add(Natural);
        textViewList.add(Medical);
        RecyclerView recyclerView = getActivity().findViewById(R.id.fm_doc_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        DocAdapter docAdapter = new DocAdapter(docList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(docAdapter);
    }
    public void initList(){
        String name = "Android MP3播放器";
        String author = "窗前的墙";
        String time = "2018-05-23";
        Doc doc = new Doc(name,author,time);
        for(int i=0;i<15;i++){
            docList.add(doc);
        }
    }
}
