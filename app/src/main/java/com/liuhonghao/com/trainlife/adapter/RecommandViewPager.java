package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.liuhonghao.com.trainlife.utils.LoadingPager;
import com.liuhonghao.com.trainlife.view.MorePager;
import com.liuhonghao.com.trainlife.view.TotalPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘红豪 on 2017/3/22.
 */

public class RecommandViewPager extends PagerAdapter {

    private final Context mcontext;
    private final TotalPager totalPager;
    private final MorePager morePager;
    private List<LoadingPager> pagers=new ArrayList<>();
    private String[] titles = {"综合", "动态"};


    public RecommandViewPager(Context mContext) {
        this.mcontext=mContext;
        totalPager=new TotalPager(mcontext);
        morePager=new MorePager(mcontext);
        pagers.add(totalPager);
        pagers.add(morePager);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(pagers.get(position));
        return pagers.get(position);

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(pagers.get(position));
    }


    @Override
    public int getCount() {
        return pagers.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
