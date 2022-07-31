package com.maxx.tabnavigation;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class BaseMainAdapter1 extends PagerAdapter {

    private ArrayList<Fragment> fragmentArray;
    public BaseMainAdapter1(FragmentManager supportFragmentManager, ArrayList<Fragment> fragmentArray) {
        this.fragmentArray = fragmentArray;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return fragmentArray.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArray.size();
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return true;
    }
}
