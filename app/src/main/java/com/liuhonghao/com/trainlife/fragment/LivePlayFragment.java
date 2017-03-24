package com.liuhonghao.com.trainlife.fragment;

import android.liuhonghao.com.trainlife.R;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.liuhonghao.com.trainlife.adapter.LiveAdapter;
import com.liuhonghao.com.trainlife.base.BaseFragment;
import com.liuhonghao.com.trainlife.bean.LivePlayBean;
import com.liuhonghao.com.trainlife.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class LivePlayFragment extends BaseFragment {

    @Bind(R.id.live_play)
    RecyclerView livePlay;
    @Bind(R.id.sp_find)
    SwipeRefreshLayout spFind;
    /* @Bind(R.id.sp_refresh)*/
   /* SwipeRefreshLayout spRefresh;*/
    private LivePlayBean bean;
    private LiveAdapter liveAdapter;
/*

    @Override
    public View intView() {
       View view=View.inflate(mContext, R.layout.live_play,null);
         recycleview = (RecyclerView) view.findViewById(R.id.live_play);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();


    }

    private void getDataFromNet() {
        String url = Constants.HOME_URL;
        OkHttpUtils.get().url(url)
                .id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("TAG", "直播页面联网失败" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                progressData(response);
            }
        });
    }

    private void progressData(String response) {
        bean = JSON.parseObject(response, LivePlayBean.class);
        liveAdapter = new LiveAdapter(mContext, bean.getResult());
        recycleview.setAdapter(liveAdapter);
        GridLayoutManager manager = new GridLayoutManager(mContext, 1);
        recycleview.setLayoutManager(manager);
       */
/* manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 0;
            }
        });*//*

    }
*/

    @Override
    public int getLayoutid() {
        return R.layout.live_play;
    }

    @Override
    protected void initData(final String json) {
        bean = JSON.parseObject(json, LivePlayBean.class);
        liveAdapter = new LiveAdapter(context, bean.getResult());
        livePlay.setAdapter(liveAdapter);
        GridLayoutManager manager = new GridLayoutManager(context, 1);
        livePlay.setLayoutManager(manager);
        spFind.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        spFind.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getLoadingPager().loadData();
                spFind.setRefreshing(false);
            }
        });
    }

    @Override
    public String getChildUrl() {
        return Constants.HOME_URL;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }



}
