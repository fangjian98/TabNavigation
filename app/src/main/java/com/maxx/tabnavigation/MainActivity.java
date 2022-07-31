package com.maxx.tabnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // https://baijiahao.baidu.com/s?id=1702876957321864413&wfr=spider&for=pc
        // https://blog.csdn.net/GodnessIsMyMine/article/details/82855877
        // https://www.jianshu.com/p/dca818cb6ca1
        // https://www.it610.com/article/1280167574536994816.htm
        // https://blog.csdn.net/m0_37143081/article/details/84991941
        // ColorStateList 使用详解


        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.setTabIconTint(getColorStateList(R.color.text_color_state_list));
        tabLayout.setTabTextColors(getColorStateList(R.color.text_color_state_list));

        ArrayList<Fragment> fragmentArray = new ArrayList<>();
        fragmentArray.add(new BlankFragment());
        fragmentArray.add(new BlankFragment2());

        viewPager.setAdapter(new BaseMainAdapter(getSupportFragmentManager(), fragmentArray));
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(2);

        tabLayout.setupWithViewPager(viewPager);
        for (int i=0;i<tabLayout.getTabCount();i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab!=null){
                //tab.setText("TAB"+i);
                tab.setCustomView(getTabView(i));
            }
        }

        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        /*tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
                tab.setCustomView(getTabView1(position));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

    }
    int[] icon = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground};
    int[] tab_down_string = {R.string.app_name, R.string.hello_blank_fragment};

    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_down_item, null);
        ImageView tabDownImage = (ImageView) view.findViewById(R.id.tab_down_image);
        TextView tab_down_text = (TextView) view.findViewById(R.id.tab_down_text);
        tabDownImage.setImageResource(icon[position]);
        tab_down_text.setText(tab_down_string[position]);
        return view;
    }

    int[] icon1 = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};

    public View getTabView1(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_down_item, null);
        ImageView tabDownImage = (ImageView) view.findViewById(R.id.tab_down_image);
        TextView tab_down_text = (TextView) view.findViewById(R.id.tab_down_text);
        tabDownImage.setImageResource(icon1[position]);
        tab_down_text.setText(tab_down_string[position]);
        return view;
    }
}