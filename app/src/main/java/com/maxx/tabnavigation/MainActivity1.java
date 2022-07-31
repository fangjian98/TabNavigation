package com.maxx.tabnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity1 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    //UI Objects
    private RadioGroup rg_tab_bar;
    private RadioButton rb_home;
    private RadioButton rb_study;
    private ViewPager vp_fragment;
    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    private long exitTime = 0;

    //2秒内按两次返回键退出
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            //彻底关闭整个APP
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
            System.exit(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_home.setChecked(true);
    }

    private void bindViews() {
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_study = (RadioButton) findViewById(R.id.rb_study);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vp_fragment = (ViewPager) findViewById(R.id.vp_fragment);
        vp_fragment.setAdapter(mAdapter);
        vp_fragment.setCurrentItem(0);
        vp_fragment.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                vp_fragment.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_study:
                vp_fragment.setCurrentItem(PAGE_TWO);
                break;
        }
    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vp_fragment.getCurrentItem()) {
                case PAGE_ONE:
                    rb_home.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_study.setChecked(true);
                    break;
            }
        }
    }
}