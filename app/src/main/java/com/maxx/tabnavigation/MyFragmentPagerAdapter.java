package com.maxx.tabnavigation;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 2;
    private BlankFragment myFragment1 = null;
    private BlankFragment2 myFragment2 = null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new BlankFragment();
        myFragment2 = new BlankFragment2();
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    private final static int PAGE_ONE = 0;
    private final static int PAGE_TWO = 1;

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case PAGE_ONE:
                fragment = myFragment1;
                break;
            case PAGE_TWO:
                fragment = myFragment2;
                break;
        }
        return fragment;
    }

}