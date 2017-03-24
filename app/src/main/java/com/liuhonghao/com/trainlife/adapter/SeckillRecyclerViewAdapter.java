package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import com.liuhonghao.com.trainlife.bean.LivePlayBean;
import com.liuhonghao.com.trainlife.utils.Constants;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class SeckillRecyclerViewAdapter extends RecyclerView.Adapter<SeckillRecyclerViewAdapter.ViewHolder>{
    private final Context mcontext;
    private final List<LivePlayBean.ResultBean.SeckillInfoBean.ListBean> datas;

    public SeckillRecyclerViewAdapter(Context mcontext, LivePlayBean.ResultBean.SeckillInfoBean seckill_info) {
        this.mcontext = mcontext;
        this.datas = seckill_info.getList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mcontext, R.layout.item_seckill, null));
    }

    @Override
    public void onBindViewHolder(SeckillRecyclerViewAdapter.ViewHolder holder, int position) {
        final LivePlayBean.ResultBean.SeckillInfoBean.ListBean listBean = datas.get(position);
        holder.show.setText(listBean.getCover_price());
        Glide.with(mcontext).load(Constants.BASE_URL_IMAGE+listBean.getFigure())
                .crossFade().into(holder.ivFigure);
        holder.ivFigure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext, "price"+listBean.getCover_price(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return datas.size()-1;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFigure;

        TextView show;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFigure= (ImageView) itemView.findViewById(R.id.iv_figure);
            show= (TextView) itemView.findViewById(R.id.tv_show);
        }
    }
}
