package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import com.liuhonghao.com.trainlife.bean.LivePlayBean;
import com.liuhonghao.com.trainlife.utils.Constants;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class RecommendGridViewAdapter extends BaseAdapter{
    private final Context mcontext;
    private final List<LivePlayBean.ResultBean.RecommendInfoBean> datas;

    public RecommendGridViewAdapter(Context mcontext, List<LivePlayBean.ResultBean.RecommendInfoBean> recommend_info) {
        this.mcontext=mcontext;
        this.datas=recommend_info;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mcontext, R.layout.item_recommend_grid_view, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //根据位置得到对应的数据
        LivePlayBean.ResultBean.RecommendInfoBean infos= datas.get(position);
        //绑定数据
        viewHolder.tvName.setText(infos.getName());
        viewHolder.tvPrice.setText("￥"+infos.getCover_price());
        Glide.with(mcontext).load(Constants.BASE_URL_IMAGE+infos.getFigure()).into(viewHolder.ivRecommend);
        return convertView;

    }
    static class ViewHolder {
        ImageView ivRecommend;
        TextView tvName;
        TextView tvPrice;

        ViewHolder(View view) {
            ivRecommend= (ImageView) view.findViewById(R.id.iv_recommend);
            tvName= (TextView) view.findViewById(R.id.tv_name);
            tvPrice= (TextView) view.findViewById(R.id.tv_price);
        }
    }
}
