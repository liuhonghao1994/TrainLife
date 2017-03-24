package com.liuhonghao.com.trainlife.fragment;

import android.liuhonghao.com.trainlife.R;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.liuhonghao.com.trainlife.adapter.DevideRecycleViewAdapter;
import com.liuhonghao.com.trainlife.base.BaseFragment;
import com.liuhonghao.com.trainlife.bean.DevideBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class DevideFragment extends BaseFragment {
    String url = "http://app.bilibili.com/x/v2/show/region?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&ts=1490014674000&sign=93edb7634f38498a60e5c3ad0b8b0974";
    @Bind(R.id.rc_devide)
    RecyclerView rcDevide;
    @Bind(R.id.sp_devide)
    SwipeRefreshLayout spDevide;
    private DevideRecycleViewAdapter devideRecycleViewAdapter;

    @Override
    public int getLayoutid() {
        return R.layout.devide_fragment;
    }

    @Override
    protected void initData(String json) {
        DevideBean devideBean = JSON.parseObject(json, DevideBean.class);
        List<DevideBean.DataBean> data = devideBean.getData();
        devideRecycleViewAdapter = new DevideRecycleViewAdapter(context, data);
        GridLayoutManager manager = new GridLayoutManager(context, 1);
        rcDevide.setLayoutManager(manager);
        rcDevide.setAdapter(devideRecycleViewAdapter);
        spDevide.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        spDevide.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getLoadingPager().loadData();
                spDevide.setRefreshing(false);
            }
        });
    }

    @Override
    public String getChildUrl() {
        return url;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
