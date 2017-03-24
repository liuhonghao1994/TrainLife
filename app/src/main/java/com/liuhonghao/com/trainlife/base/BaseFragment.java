package com.liuhonghao.com.trainlife.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuhonghao.com.trainlife.utils.LoadingPager;

import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/20.
 */

public abstract class BaseFragment extends Fragment {
    public Context context;
    private LoadingPager loadingPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=getActivity();
    }
    //创建视图的时候
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loadingPager=new LoadingPager(context) {
            @Override
            protected void onSuccess(ResultState resultState, View sucessView) {
                ButterKnife.bind(BaseFragment.this,sucessView);
                initData(resultState.getJson());//因为resultState中有json的get，set方法
            }

            @Override
            protected String getUrl() {
                return  getChildUrl();
            }

            @Override
            public int getViewId() {
                return getLayoutid();
            }
        };
        return loadingPager;//返回loadingPager来加载成功后的视图

    }



    //视图绑定过后
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            loadingPager.loadData();
        //会调用loadpager中的获取网络数据，给状态，判断状态加载视图，从而视图出来了
    }

    public LoadingPager getLoadingPager(){
        return loadingPager;
    }

    //实现布局，通过getLayoutid来返回给getViewId()让视图成功后能够加载出来视图
    public abstract int getLayoutid();
    //初始化数据不传递过去哪里来的网络json字符串没字符串哪里能判断加载什么视图
    protected abstract void initData(String json);
    //得到网络数据地址
    public abstract String getChildUrl();

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

  /*  //当fragment被创建会执行这个方法。
    public Context mContext;//上下文
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return intView();
    }
    //当系统实例化视图时候调用该方法
    public abstract View intView() ;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    //将数据绑定到视图，没有数据联网请求
    public   void initData(){

    }*/

}
