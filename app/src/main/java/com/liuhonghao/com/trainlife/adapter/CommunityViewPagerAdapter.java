package com.liuhonghao.com.trainlife.adapter;


import com.liuhonghao.com.trainlife.base.BaseFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class CommunityViewPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = {"直播", "推荐", "追番", "分区", "发现"};
    private final ArrayList<BaseFragment> fragments;

    public CommunityViewPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments= (ArrayList<BaseFragment>) fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //viewPager和PagerTab(就是页签)联用，
    // viewPager的适配器中getPageTitle方法会返回position位置的PagerTab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}