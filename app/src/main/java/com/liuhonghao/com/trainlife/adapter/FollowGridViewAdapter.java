package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuhonghao.com.trainlife.bean.FollowBean;

import java.util.List;

/**
 * Created by 刘红豪 on 2017/3/22.
 */

public class FollowGridViewAdapter extends BaseAdapter {
    private final Context mcontext;
    private final List<FollowBean.ResultBean.SerializingBean> datas;

    public FollowGridViewAdapter(Context mcontext, List<FollowBean.ResultBean.SerializingBean> serializing) {
        this.mcontext = mcontext;
        this.datas = serializing;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertview == null) {
            convertview = View.inflate(mcontext, R.layout.new_item, null);
            viewHolder = new ViewHolder(convertview);
            convertview.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertview.getTag();
        }

        //根据位置得到对应的数据
        Glide.with(mcontext).load(datas.get(position).getCover()).into(viewHolder.ivFollow);
        viewHolder.tvName.setText(datas.get(position).getTitle());
        viewHolder.tvTime.setText("更新至"+datas.get(position).getNewest_ep_index()+"话");
        viewHolder.tvcount.setText(datas.get(position).getWatching_count()+"人在看");
        //绑定数据
        return convertview;
    }

    static class ViewHolder {

        private final TextView tvcount;
        private ImageView ivFollow;
        private TextView tvName;
        private TextView tvTime;
        ViewHolder(View view) {
            ivFollow= (ImageView) view.findViewById(R.id.iv_follow);
            tvName= (TextView) view.findViewById(R.id.tv_title);
            tvTime= (TextView) view.findViewById(R.id.tv_time);
            tvcount= (TextView) view.findViewById(R.id.tv_people);
        }
    }
}
