package com.liuhonghao.com.trainlife.view;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.liuhonghao.com.trainlife.adapter.GvTotalAdapter;
import com.liuhonghao.com.trainlife.bean.RecommandBean;
import com.liuhonghao.com.trainlife.utils.LoadingPager;

/**
 * Created by 刘红豪 on 2017/3/23.
 */

public class TotalPager extends LoadingPager {
    private final Context context;

    SwipeRefreshLayout spTotal;

    /* SwipeRefreshLayout spTotal;*/
    private GvTotalAdapter gvTotalAdapter;
    String url = "http://app.bilibili.com/x/feed/index?appkey=1d8b6e7d45233436&build=501000&idx=1490013261&mobi_app=android&network=wifi&platform=android&pull=true&style=2&ts=1490015599000&sign=af4edc66aef7e443c98c28de2b660aa4";
    private RecyclerView ry_total;

    public TotalPager(Context context) {
        super(context);
        this.context = context;
        loadData();
    }

    @Override
    protected void onSuccess(ResultState resultState, View sucessView) {
        ry_total = (RecyclerView) sucessView.findViewById(R.id.rc_total);
     spTotal= (SwipeRefreshLayout) sucessView.findViewById(R.id.sp_total);
        initData(resultState.getJson());
        Log.e("TAG", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Override
    protected String getUrl() {
        return url;
    }

    @Override
    public int getViewId() {
        return R.layout.vp_total;
    }

    protected void initData(final String json) {
        Log.e("TAG", json.toString());
        RecommandBean recommandBean = JSON.parseObject(json, RecommandBean.class);
        gvTotalAdapter = new GvTotalAdapter(context, recommandBean.getData());
        GridLayoutManager manager = new GridLayoutManager(context, 2);
        ry_total.setLayoutManager(manager);
        ry_total.setAdapter(gvTotalAdapter);
        gvTotalAdapter.setOnItemClickListener(new GvTotalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "position==" + position, Toast.LENGTH_SHORT).show();
            }
        });
      spTotal.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        spTotal.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               loadData();
                spTotal.setRefreshing(false);
            }
        });
    }

}
