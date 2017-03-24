package com.liuhonghao.com.trainlife.fragment;


import android.liuhonghao.com.trainlife.R;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.liuhonghao.com.trainlife.adapter.FollowRecycleAdapter;
import com.liuhonghao.com.trainlife.base.BaseFragment;
import com.liuhonghao.com.trainlife.bean.FollowBean;
import com.liuhonghao.com.trainlife.utils.LoadingPager;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class FollowFragment extends BaseFragment {

    @Bind(R.id.ry_follow)
    RecyclerView ryFollow;
    @Bind(R.id.sp_refresh)
    SwipeRefreshLayout spRefresh;
    private String url = "http://bangumi.bilibili.com/api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios";

    private FollowRecycleAdapter followRecycleAdapter;

    /*private RecyclerView recycleview;
    private FollowRecycleAdapter followRecycleAdapter;
    @Override
    public View intView() {
        View view = View.inflate(mContext, R.layout.follow_fragment, null);
        recycleview = (RecyclerView) view.findViewById(R.id.ry_follow);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();
    }

    private void getDataFromNet() {
       String url= "http://bangumi.bilibili.com/api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios";
        OkHttpUtils.get().url(url).id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("TAG", "联网失败"+e);
            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("TAG", "联网OK");
                    progressData(response);
            }
        });
    }

    private void progressData(String response) {
        FollowBean followBean = JSON.parseObject(response, FollowBean.class);
        followRecycleAdapter=new FollowRecycleAdapter(mContext,followBean.getResult());
        recycleview.setAdapter(followRecycleAdapter);
        GridLayoutManager manager = new GridLayoutManager(mContext, 1);
        recycleview.setLayoutManager(manager);
    }
*/
    @Override
    public int getLayoutid() {
        return R.layout.follow_fragment;
    }

    @Override
    protected void initData(final String json) {
        FollowBean followBean = JSON.parseObject(json, FollowBean.class);
        followRecycleAdapter = new FollowRecycleAdapter(getActivity(), followBean.getResult());
        ryFollow.setAdapter(followRecycleAdapter);
        GridLayoutManager manager = new GridLayoutManager(context, 1);
        ryFollow.setLayoutManager(manager);
        spRefresh.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        spRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getLoadingPager().loadData();
                spRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public LoadingPager getLoadingPager() {
        return super.getLoadingPager();
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
