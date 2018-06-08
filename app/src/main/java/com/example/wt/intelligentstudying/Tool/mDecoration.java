package com.example.wt.intelligentstudying.Tool;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.wt.intelligentstudying.One.InfoAdapter;

public class mDecoration extends RecyclerView.ItemDecoration{
        private Context mContext;
        private Drawable mDivider;
        private int mOrientation;
        public int ImSize = InfoAdapter.ImageSize;
        public static final int HORIZIONTAL_LIST = LinearLayoutManager.HORIZONTAL;
        public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    public static final int[] ATRRS = new int[]{
      android.R.attr.listDivider
    };
    public mDecoration(Context context,int orientation){
        this.mContext = context;
        final TypedArray ta = context.obtainStyledAttributes(ATRRS);
        this.mDivider = ta.getDrawable(0);
        ta.recycle();
        setOrientation(orientation);
    }
    //设置屏幕的方向
    public void setOrientation(int orientation){
        if(orientation != HORIZIONTAL_LIST&&orientation != VERTICAL_LIST){
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }
    @Override
    public void onDraw(Canvas canvas,RecyclerView parent,RecyclerView.State state){
        if(mOrientation == HORIZIONTAL_LIST){
            drawHorizontalLine(canvas,parent,state);
        }else{
            drawVerticalLine(canvas,parent,state);
        }
    }
    //画横线，这里的parent其实是显示在屏幕显示的部分
    public void drawHorizontalLine(Canvas canvas,RecyclerView parent,RecyclerView.State state){
        int left = parent.getPaddingLeft()+3;
        int right = parent.getWidth() - parent.getPaddingRight()-115-3;
        final int childCount = parent.getChildCount();
        for(int i=0;i<childCount;i++){
            final View child = parent.getChildAt(i);
            //获得child的布局信息
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top+mDivider.getIntrinsicHeight();
            Log.v("Left,Top,Right,Bottom","Here"+left+"-"+top+"-"+right+"-"+bottom);
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(canvas);
        }
    }
    //画竖线
    public void drawVerticalLine(Canvas c, RecyclerView parent, RecyclerView.State state){
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++){
            final View child = parent.getChildAt(i);

            //获得child的布局信息
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
    //由于Divider也有长宽高，每一个Item需要向下或者向右偏移
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation == HORIZIONTAL_LIST){
            //画横线，就是往下偏移一个分割线的高度
            Log.v("getItemOffsets","There is set HORIZIONTAL_LIST");
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        }else {
            //画竖线，就是往右偏移一个分割线的宽度
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}
