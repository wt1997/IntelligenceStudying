package com.example.wt.intelligentstudying.Second;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menulib.lib.ContextMenuDialogFragment;
import com.example.menulib.lib.MenuObject;
import com.example.menulib.lib.MenuParams;
import com.example.menulib.lib.interfaces.OnMenuItemClickListener;
import com.example.menulib.lib.interfaces.OnMenuItemLongClickListener;
import com.example.wt.intelligentstudying.DocFragment.Content;
import com.example.wt.intelligentstudying.HomeWork.CourseHomework;
import com.example.wt.intelligentstudying.R;
import com.example.wt.intelligentstudying.StuInfo.CourseFragment;
import com.example.wt.intelligentstudying.StuInfo.MessageFragment;
import com.example.wt.intelligentstudying.StuInfo.SetFragment;
import com.example.wt.intelligentstudying.StuInfo.StudyFragment;
import com.example.wt.intelligentstudying.StuInfo.StuinfoFragment;
import com.example.wt.intelligentstudying.StuInfo.TaskFragment;

import java.util.ArrayList;
import java.util.List;

public class Second_Main extends AppCompatActivity implements OnMenuItemClickListener,
        OnMenuItemLongClickListener,contents{
    private FrameLayout frameLayout;
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentManager fragmentManager;
    private ContextMenuDialogFragment mMenuDialogFragment;
    private static List<String> mtitle = new ArrayList<>();
    private static List<String> mcontent = new ArrayList<>();
    private static String mtitles;
    private static String mcontents;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int number = intent.getIntExtra("start_fm",0);
        setContentView(R.layout.activity_second__main);
        frameLayout = (FrameLayout) findViewById(R.id.second_main_fm);
        initListFragment(fragmentList);
        fragmentManager = getSupportFragmentManager();
        initToolbar();
        initMenuFragment(0);
        replaceFragment(number);
    }

    public void replaceFragment(int position){
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.second_main_fm,fragmentList.get(position));
        fragmentTransaction.commit();
    }
    public void initListFragment(List<Fragment> listfragment){
        listfragment.add(new BlockFragment());
        listfragment.add(new ExcellentFragment());
        listfragment.add(new DocFragment());
        listfragment.add(new StuinfoFragment());
        listfragment.add(new MessageFragment());
        listfragment.add(new CourseFragment());
        listfragment.add(new StudyFragment());
        listfragment.add(new TaskFragment());
        listfragment.add(new SetFragment());
        listfragment.add(new Content());
    }
    //初始化菜单栏Fragment
    private void initMenuFragment(int position) {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects(position));
        menuParams.setClosableOutside(false);
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        mMenuDialogFragment.setItemClickListener(this);
        mMenuDialogFragment.setItemLongClickListener(this);
    }
    //将菜单栏图片装入List中
    private List<MenuObject> getMenuObjects() {
        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject send = new MenuObject("Send message");
        send.setResource(R.drawable.icn_1);

        MenuObject like = new MenuObject("Like profile");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_2);
        like.setBitmap(b);

        MenuObject addFr = new MenuObject("Add to friends");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
        addFr.setDrawable(bd);

        MenuObject addFav = new MenuObject("Add to favorites");
        addFav.setResource(R.drawable.icn_4);

        MenuObject block = new MenuObject("Block user");
        block.setResource(R.drawable.icn_5);

        menuObjects.add(close);
        menuObjects.add(send);
        menuObjects.add(like);
        menuObjects.add(addFr);
        menuObjects.add(addFav);
        menuObjects.add(block);
        return menuObjects;
    }
    //初始化标题栏
    private void initToolbar() {
        Toolbar mToolbar = findViewById(R.id.second_main_toolbar);
        TextView mToolBarTextView = findViewById(R.id.text_view_toolbar_title);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationIcon(R.drawable.btn_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mToolBarTextView.setText("AL");
    }
    //在标题栏添加选项栏
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    //设置选中的Item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu:
                if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                    mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mMenuDialogFragment != null && mMenuDialogFragment.isAdded()) {
            mMenuDialogFragment.dismiss();
        } else {
            finish();
        }
    }
    //ToolBar菜单栏监听器
    @Override
    public void onMenuItemClick(View clickedView, int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.answer_dialog,null,false);
        EditText editText = view.findViewById(R.id.answer_dialog_et);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("评论");
        alertDialog.setView(view);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "发表", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
        //Toast.makeText(this, "Clicked on position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMenuItemLongClick(View clickedView, int position) {
        Toast.makeText(this, "Long clicked on position: " + position, Toast.LENGTH_SHORT).show();
    }
    //Block版块Item的点击事件
    public void onBlockItemClick(View view){
        RecyclerView recyclerView = getSupportFragmentManager().findFragmentById(R.id.second_main_fm)
                .getView().findViewById(R.id.fm_block_recyclerview);
        //获取点击的item项
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        //获取点击项的Title和Content
        mtitles = mtitle.get(childAdapterPosition);
        mcontents = mcontent.get(childAdapterPosition);
        initMenuFragment(1);
        replaceFragment(fragmentList.size()-1);
    }
    //实现自定义接口contents
    //在BlockFragment中调用setContents,将数据传递到Activity
    public void setContents(List<String> title,List<String> content){
        mtitle = title;
        mcontent = content;
    }
    //在ContentFragment中调用getContent,获取Question数据
    public String getContent(){
        return mcontents;
    }
    //在ContentFragment中调用获取Question标题
    public String getmTitle(){
        return mtitles;
    }
    /*----------接下来的代码是对选择条的选择,在开启不同的Fragment时显示不同的选择条------------------*/
    //将菜单栏图片装入List中
    private List<MenuObject> getMenuObjects(int which) {
        List<MenuObject> menuObjects = new ArrayList<>();
        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject send = new MenuObject("Send message");
        send.setResource(R.drawable.icn_1);

        MenuObject like = new MenuObject("Like profile");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_2);
        like.setBitmap(b);

        MenuObject addFr = new MenuObject("Add to friends");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
        addFr.setDrawable(bd);

        MenuObject addFav = new MenuObject("Add to favorites");
        addFav.setResource(R.drawable.icn_4);

        MenuObject block = new MenuObject("Block user");
        block.setResource(R.drawable.icn_5);

        switch (which){
            case 0:
                menuObjects.add(close);
                menuObjects.add(send);
                menuObjects.add(like);
                menuObjects.add(addFr);
                menuObjects.add(addFav);
                menuObjects.add(block);
                break;
            case 1:
                menuObjects.add(close);
                menuObjects.add(send);
                menuObjects.add(like);
                break;
        }
        return menuObjects;
    }
}
