package com.example.wt.intelligentstudying.Second;


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
public class ExcellentFragment extends Fragment {

    List<ExcellentPage> list = new ArrayList<>();
    public ExcellentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_excellent, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initExcellentView();
        RecyclerView recyclerView = getActivity().findViewById(R.id.excellent_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ExcellentItemAdapter excellentItemAdapter = new ExcellentItemAdapter(list);
        recyclerView.setAdapter(excellentItemAdapter);
    }
    //初始化RecyclerView的Item内容
    public void initExcellentView(){
        String author = "Author:";
        String text = "\u3000\u3000"+"RecyclerView recyclerView = getActivity().findViewById(R.id.excellent_recyclerview)" +
                "        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());" +
                "        recyclerView.setLayoutManager(layoutManager);";
        ExcellentPage page1 = new ExcellentPage(author+"Mike",text,R.drawable.bf);
        list.add(page1);
        ExcellentPage page2 = new ExcellentPage(author+"Mike",text,R.drawable.bf);
        list.add(page2);
        ExcellentPage page3 = new ExcellentPage(author+"Mike",text,R.drawable.bf);
        list.add(page3);
        ExcellentPage page4 = new ExcellentPage(author+"Mike",text,R.drawable.bf);
        list.add(page4);
        ExcellentPage page5 = new ExcellentPage(author+"Mike",text,R.drawable.bf);
        list.add(page5);
        ExcellentPage page6 = new ExcellentPage(author+"Mike",text,R.drawable.bf);
        list.add(page6);
        ExcellentPage page7 = new ExcellentPage(author+"Mike",text,R.drawable.bf);
        list.add(page7);
    }

}
