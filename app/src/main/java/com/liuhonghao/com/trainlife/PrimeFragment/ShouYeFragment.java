package com.liuhonghao.com.trainlife.PrimeFragment;

import android.liuhonghao.com.trainlife.R;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liuhonghao.com.trainlife.adapter.CommunityViewPagerAdapter;
import com.liuhonghao.com.trainlife.base.BaseFragment;
import com.liuhonghao.com.trainlife.fragment.DevideFragment;
import com.liuhonghao.com.trainlife.fragment.FindFragment;
import com.liuhonghao.com.trainlife.fragment.FollowFragment;
import com.liuhonghao.com.trainlife.fragment.LivePlayFragment;
import com.liuhonghao.com.trainlife.fragment.RecommandFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class ShouYeFragment extends BaseFragment {
    @Bind(R.id.iv_more)
    ImageView ivMore;
    @Bind(R.id.iv_login)
    ImageView ivLogin;
    @Bind(R.id.tv_search)
    TextView tvSearch;
    @Bind(R.id.tv_game)
    TextView tvGame;
    @Bind(R.id.rl_game)
    RelativeLayout rlGame;
    @Bind(R.id.iv_down)
    ImageView ivDown;
    @Bind(R.id.iv_ss)
    ImageView ivSs;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tb_layout)
    TabLayout tbLayout;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.content_main)
    LinearLayout contentMain;
    private List<BaseFragment> fragments;

    private CommunityViewPagerAdapter adapter;
    private FragmentManager manager;
    /*private ImageView ivmore;*/
   /* private DrawerLayout dr;*/


    /*@Override
    public View intView() {
        View view = View.inflate(mContext, R.layout.shouye_fragment, null);
        viewPager= (ViewPager) view.findViewById(R.id.view_pager);
        toolbar= (Toolbar)view.findViewById(R.id.toolbar);
        tbLayout= (TabLayout)view. findViewById(R.id.tb_layout);
        viewPager= (ViewPager) view.findViewById(R.id.view_pager);
        fab= (FloatingActionButton) view.findViewById(R.id.fab);
       *//*ivmore= (ImageView) view.findViewById(R.id.iv_more);*//*
      *//*  dr = (DrawerLayout) view.findViewById(R.id.dr_layout);*//*

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        initFragmenr();
        manager =getActivity().getSupportFragmentManager();
        adapter = new CommunityViewPagerAdapter(manager, fragments);
        viewPager.setAdapter(adapter);
        //将tablayout和viewpager关联
        tbLayout.setupWithViewPager(viewPager);
        //设置tab的模式
        tbLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


    }*/

    /*private void initListener() {
        ivmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dr.openDrawer(Gravity.LEFT);
            }
        });
    }*/


    private void initFragmenr() {
        fragments = new ArrayList<>();
        fragments.add(new LivePlayFragment());//0
        fragments.add(new RecommandFragment());//1
        fragments.add(new FollowFragment());
        fragments.add(new DevideFragment());
        fragments.add(new FindFragment());

    }

    @Override
    public int getLayoutid() {
        return R.layout.shouye_fragment;
    }

    @Override
    protected void initData(String json) {
        initFragmenr();
        manager =getActivity().getSupportFragmentManager();
        adapter = new CommunityViewPagerAdapter(manager, fragments);
        viewPager.setAdapter(adapter);
        //将tablayout和viewpager关联
        tbLayout.setupWithViewPager(viewPager);
        //设置tab的模式
        tbLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public String getChildUrl() {
        return null;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
