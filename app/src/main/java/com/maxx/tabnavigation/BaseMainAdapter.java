package com.maxx.tabnavigation;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class BaseMainAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArray;
    public BaseMainAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragmentArray) {
        super(supportFragmentManager);
        this.fragmentArray = fragmentArray;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArray.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArray.size();
    }
}
