package com.example.wt.intelligentstudying.DocFragment;


import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;
import com.example.wt.intelligentstudying.Second.Second_Main;
import com.example.wt.intelligentstudying.Second.contents;
import com.example.wt.intelligentstudying.StuInfo.StuinfoMessage;
import com.example.wt.intelligentstudying.StuInfo.StuinfoMessageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Content extends Fragment {

    private String mcontent;
    private String mtitle;
    private List<Answer> list = new ArrayList<>();
    public Content() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initList();
        initView();
    }
    public void initList(){
        Answer answer = new Answer(R.drawable.bf,"窗前明月光",
                "通过继承ImageView控件,重写控件的方法,将控件Draw为圆形即可实现," +
                        "或者继承自View通过onDraw方法画出。");
        for(int i=0;i<5;i++){
            list.add(answer);
        }
    }
    public void initView(){
        TextView title = getActivity().findViewById(R.id.fm_content_title);
        TextView content = getActivity().findViewById(R.id.fm_content_content);
        RecyclerView recyclerView = getActivity().findViewById(R.id.fm_content_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AnswerAdapter(list));
        mtitle = ((contents)(getActivity())).getmTitle();
        mcontent = ((contents)getActivity()).getContent();
        title.setText(mtitle);
        content.setText(mcontent);
    }
}
