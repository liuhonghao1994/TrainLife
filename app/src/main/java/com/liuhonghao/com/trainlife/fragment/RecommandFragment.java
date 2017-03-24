package com.liuhonghao.com.trainlife.fragment;

import android.liuhonghao.com.trainlife.R;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.liuhonghao.com.trainlife.adapter.RecommandViewPager;
import com.liuhonghao.com.trainlife.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class RecommandFragment extends BaseFragment {
    /*String url = "http://app.bilibili.com/x/feed/index?appkey=1d8b6e7d45233436&build=501000&idx=1490013261&mobi_app=android&network=wifi&platform=android&pull=true&style=2&ts=1490015599000&sign=af4edc66aef7e443c98c28de2b660aa4";*/
    @Bind(R.id.tb_recommand_layout)
    TabLayout tbRecommandLayout;
    @Bind(R.id.view_recommand)
    ViewPager viewRecommand;
    private RecommandViewPager recommandViewPager;

    @Override
    public int getLayoutid() {
        return R.layout.recommand_fragment;
    }

    @Override
    protected void initData(String json) {



        recommandViewPager=new RecommandViewPager(context);
        viewRecommand.setAdapter(recommandViewPager);
        //将tablayout和viewpager关联
        tbRecommandLayout.setupWithViewPager(viewRecommand);
        //设置tab的模式
        tbRecommandLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
       /* rc_total = (RecyclerView) viewRecommand.findViewById(R.id.rc_total);*/
        /*rc_total= (RecyclerView) viewRecommand.getChildAt(0).findViewById(R.id.rc_total);*/
      /*  RecommandBean recommandBean = JSON.parseObject(json, RecommandBean.class);
        gvTotalAdapter=new GvTotalAdapter(context,recommandBean.getData());*/
       /* GridLayoutManager manager1 = new GridLayoutManager(context, 2);
        rc_total.setLayoutManager(manager1);
        rc_total.setAdapter(gvTotalAdapter);
        rc_more = (RecyclerView) viewRecommand.getChildAt(0).findViewById(R.id.rc_more);
        GridLayoutManager manager2 = new GridLayoutManager(context, 2);
        rc_more.setLayoutManager(manager2);
        rc_more.setAdapter(gvTotalAdapter);*/
       /* gvTotalAdapter.setOnItemClickListener(new GvTotalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "position=="+position, Toast.LENGTH_SHORT).show();
            }
        });*/





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
