package com.example.wt.intelligentstudying.One;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.wt.intelligentstudying.R;
import com.example.wt.intelligentstudying.Tool.mDecoration;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Animation.AnimationListener{

    private List<News> list_news = new ArrayList<>();
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ViewFlipper viewFlipper = (ViewFlipper)getActivity().findViewById(R.id.mviewflipper);
        RecyclerView mRecyclerView = (RecyclerView)getActivity().findViewById(R.id.mRecycleView);
        initNews();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        InfoAdapter adapter = new InfoAdapter(list_news);
        mRecyclerView.setAdapter(adapter);
        setViewFlipper(viewFlipper);
        Log.v("RecycleView","There is set ItemDecoration");
        mRecyclerView.addItemDecoration(new mDecoration(getActivity(),mDecoration.HORIZIONTAL_LIST));

    }
    @Override
    public void onAnimationStart(Animation animation){
        //动画开始时
    }
    @Override
    public void onAnimationEnd(Animation animation){
        //动画结束时
    }
    @Override
    public void onAnimationRepeat(Animation animation){
        //重复
    }
    private void setViewFlipper(ViewFlipper mviewFlipper){
        mviewFlipper.addView(getImageView(R.drawable.by1));
        mviewFlipper.addView(getImageView(R.drawable.by2));
        mviewFlipper.addView(getImageView(R.drawable.by3));
        mviewFlipper.addView(getImageView(R.drawable.by4));
        mviewFlipper.setFlipInterval(2000);
        //mviewFlipper.getInAnimation().setAnimationListener(this);
        mviewFlipper.startFlipping();
    }
    private ImageView getImageView(int res){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(res);
        return imageView;
    }
    private void initNews(){
        for(int i=0;i<2;i++){
            News n1 = new News("This is the first News",R.drawable.bf);
            list_news.add(n1);
            News n2 = new News("This is the second News",R.drawable.lf);
            list_news.add(n2);
            News n3 = new News("This is the third News",R.drawable.bf);
            list_news.add(n3);
            News n4 = new News("This is the fourth News",R.drawable.lf);
            list_news.add(n4);
            News n5 = new News("This is the fifth News",R.drawable.bf);
            list_news.add(n5);
            News n6 = new News("This is the sixth News",R.drawable.lf);
            list_news.add(n6);
            News n7 = new News("This is the seventh News",R.drawable.bf);
            list_news.add(n7);
        }
    }
}
