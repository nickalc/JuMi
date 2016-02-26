package com.puxiang.jumi.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.puxiang.jumi.ui.fragments.OrderDetailFragment;
import com.puxiang.jumi.ui.fragments.OrderStatusFragment;

public class OrderDetailViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT =2;
    private String titles[] ;

    public OrderDetailViewPagerAdapter(FragmentManager fm, String[] titles2) {
        super(fm);
        titles=titles2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            // Open FragmentTab1.java
            case 0:
                return OrderStatusFragment.newInstance(position);
            case 1:
                return OrderDetailFragment.newInstance(position);

        }
        return null;
    }

    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}