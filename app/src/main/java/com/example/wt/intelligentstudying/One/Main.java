package com.example.wt.intelligentstudying.One;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.menulib.lib.ContextMenuDialogFragment;
import com.example.menulib.lib.MenuObject;
import com.example.menulib.lib.MenuParams;
import com.example.menulib.lib.interfaces.OnMenuItemClickListener;
import com.example.menulib.lib.interfaces.OnMenuItemLongClickListener;
import com.example.wt.intelligentstudying.MenuFragment;
import com.example.wt.intelligentstudying.R;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity implements ViewPager.OnPageChangeListener,OnMenuItemClickListener, OnMenuItemLongClickListener,BottomNavigationBar.OnTabSelectedListener{
    private BottomNavigationBar bottomNavigationBar;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private FragmentManager fragmentManager;
    private ContextMenuDialogFragment mMenuDialogFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainplatform);
        bottomNavigationBar = findViewById(R.id.bottomNavigationBar);
        viewPager = (ViewPager)findViewById(R.id.viewPager_one);
        fragmentManager = getSupportFragmentManager();
        initBottomNavigation();
        initToolbar();
        initMenuFragment();
        initViewPager();
        addFragment(new MenuFragment(), true, R.id.zero_fm);
    }
    //初始化底部菜单栏
    private void initBottomNavigation(){
        BadgeItem badgeItem = new BadgeItem()
                .setBorderWidth(2)
                .setBackgroundColor("#FF0000")
                .setBackgroundColor("#9ACD32")
                .setGravity(Gravity.RIGHT|Gravity.TOP)
                .setText("Hi")
                .setTextColor("#F0F8FF")
                .setAnimationDuration(2000)
                .setHideOnSelect(true);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp,"Home").setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp,"Book").setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp,"Music").setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp,"Games").setBadgeItem(badgeItem))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
    }


    //初始化菜单栏Fragment
    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects());
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
        Toolbar mToolbar = findViewById(R.id.toolbar);
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
    //添加Fragment,此处设置Fragment的大小为0
    protected void addFragment(Fragment fragment, boolean addToBackStack, int containerId) {
        invalidateOptionsMenu();
        String backStackName = fragment.getClass().getName();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(backStackName, 0);
        if (!fragmentPopped) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(containerId, fragment, backStackName)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            if (addToBackStack)
                transaction.addToBackStack(backStackName);
            transaction.commit();
        }
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
    //初始化ViewPager
    private void initViewPager(){

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new DissFragment());
        fragments.add(new FunnyFragment());
        fragments.add(new StudentFragment());
        viewPager.setAdapter(new SectionsPagerAdapter(fragmentManager,fragments));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
    }
    /*---------------------ViewPagerListener-----------------------*/
    @Override
    public void onPageScrolled(int position,float positionOffset,int positionOffsetPixels){
       // Log.v("onPageScroolled--","The Method come in"+position+"-"+positionOffset+"-"+positionOffsetPixels);
    }
    @Override
    public void onPageSelected(int position){
       // Log.v("onPageSelected--","The Method come in");
        bottomNavigationBar.selectTab(position);
    }
    @Override
    public void onPageScrollStateChanged(int state){
       // Log.v("ScrollStateChanged","The Method come in"+state);
    }
   /*----------------------BootomNavigationListener------------------*/
   @Override
   public void onTabSelected(int position) {
       //replaceFragments(fragments,position);
       viewPager.setCurrentItem(position);
       //  Log.v("onTabSelected--","The Method come in"+position);
   }

    @Override
    public void onTabUnselected(int position) {
        //  Log.v("onTabUnselected--","The Method come in"+position);
    }

    @Override
    public void onTabReselected(int position) {
        //  Log.v("onTabReselected--","The Method come in"+position);
    }
    /*---------------------MunuItenListener-------------------------*/
    @Override
    public void onMenuItemClick(View clickedView, int position) {
        Toast.makeText(this, "Clicked on position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMenuItemLongClick(View clickedView, int position) {
        Toast.makeText(this, "Long clicked on position: " + position, Toast.LENGTH_SHORT).show();
    }
}
