package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuhonghao.com.trainlife.bean.DevideBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/23.
 */

public class BottomAdapter extends BaseAdapter {
    private final Context context;
    private final DevideBean.DataBean datas;


    public BottomAdapter(Context context, DevideBean.DataBean datas) {
        this.context = context;
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.getBody().size();
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
            convertView = View.inflate(context, R.layout.bottom_item_show, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(datas.getBody().get(position).getCover()).into(viewHolder.itemLiveCover2);
        viewHolder.tvContent2.setText(datas.getBody().get(position).getTitle());
        viewHolder.tvPlay2.setText(datas.getBody().get(position).getPlay()+"");
        viewHolder.tvRecommend2.setText(datas.getBody().get(position).getDanmaku()+"");
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.item_live_cover2)
        ImageView itemLiveCover2;
        @Bind(R.id.tv_content2)
        TextView tvContent2;
        @Bind(R.id.tv_play2)
        TextView tvPlay2;
        @Bind(R.id.tv_recommend2)
        TextView tvRecommend2;
        @Bind(R.id.item_live_layout2)
        LinearLayout itemLiveLayout2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
