package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuhonghao.com.trainlife.activity.MyGridView;
import com.liuhonghao.com.trainlife.bean.DevideBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/23.
 */

public class DevideRecycleViewAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final List<DevideBean.DataBean> datas;
    private final LayoutInflater inflater;
    private int currentType = TOP;
    private static final int TOP = 0;
    private static final int BOTTOM = 1;
    private int[]  images = {R.drawable.ic_category_t13, R.drawable.ic_category_t13,
            R.drawable.ic_category_t1, R.drawable.ic_category_t3,
            R.drawable.ic_category_t129, R.drawable.ic_category_t4,
            R.drawable.ic_category_t36, R.drawable.ic_category_t160,
            R.drawable.ic_category_t119, R.drawable.ic_category_t155,
            R.drawable.ic_category_t165, R.drawable.ic_category_t5,
            R.drawable.ic_category_t23, R.drawable.ic_category_t11,
            R.drawable.ic_category_game_center,R.drawable.ic_category_t153,R.drawable.ic_category_t154,R.drawable.ic_category_t155,R.drawable.ic_category_t155};

    public DevideRecycleViewAdapter(Context context, List<DevideBean.DataBean> data) {
        this.context = context;
        this.datas = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == TOP) {
            currentType = TOP;
        }
        if (position == BOTTOM) {
            currentType = BOTTOM;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TOP) {
            return new TopViewHolder(context, inflater.inflate(R.layout.top_grid, null));

        } else if (viewType == BOTTOM) {
            return new BottomViewHolder(context, inflater.inflate(R.layout.bottom_item, null));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TOP) {
            TopViewHolder viewHolder = (TopViewHolder) holder;
            viewHolder.setData();

        } else if (getItemViewType(position) == BOTTOM) {
            BottomViewHolder actViewHolder = (BottomViewHolder) holder;
            actViewHolder.setData(datas.get(position-1));
            actViewHolder.ivLeft.setImageResource(images[position-1]);
            actViewHolder.tvRegion.setText(datas.get(position-1).getTitle());
            actViewHolder.btTishi.setText(datas.get(position-1).getParam()+"16"+"新动态,点击刷!");
        }
    }

    @Override
    public int getItemCount() {
        return datas.size()+1;
    }

    static class TopViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private int[]  images = {R.drawable.ic_category_t13, R.drawable.ic_category_t13,
                R.drawable.ic_category_t1, R.drawable.ic_category_t3,
                R.drawable.ic_category_t129, R.drawable.ic_category_t4,
                R.drawable.ic_category_t36, R.drawable.ic_category_t160,
                R.drawable.ic_category_t119, R.drawable.ic_category_t155,
                R.drawable.ic_category_t165, R.drawable.ic_category_t5,
                R.drawable.ic_category_t23, R.drawable.ic_category_t11,
                R.drawable.ic_category_game_center};
        ;
        private String[] names = {"直播", "番剧", "动画", "音乐", "舞蹈", "游戏", "科技", "生活", "鬼畜"
                , "时尚", "广告", "娱乐", "电影", "电视剧", "游戏中心"};
        @Bind(R.id.gv_top)
        MyGridView gvTop;
        private GridTopAdapter gridTopAdapter;

        TopViewHolder(Context context, View view) {
            super(view);
            this.context = context;
            ButterKnife.bind(this, view);
        }

        public void setData() {
            gridTopAdapter = new GridTopAdapter(context, images, names);
            gvTop.setAdapter(gridTopAdapter);
        }
    }

    static class BottomViewHolder extends RecyclerView.ViewHolder{
        private final Context context;
        @Bind(R.id.iv_left)
        ImageView ivLeft;
        @Bind(R.id.tv_region)
        TextView tvRegion;
        @Bind(R.id.bt_next1)
        Button btNext;
        @Bind(R.id.gv_region)
        MyGridView gvRegion;
        @Bind(R.id.more)
        Button more;
        @Bind(R.id.bt_tishi)
        TextView btTishi;
        @Bind(R.id.iv_refsh)
        ImageView ivRefsh;
        private BottomAdapter bottomAdapter;
        BottomViewHolder(Context context, View view) {
            super(view);
            this.context=context;
            ButterKnife.bind(this, view);
        }

        public void setData(DevideBean.DataBean datas) {
            bottomAdapter=new BottomAdapter(context,datas);
            gvRegion.setAdapter(bottomAdapter);
        }
    }
}
