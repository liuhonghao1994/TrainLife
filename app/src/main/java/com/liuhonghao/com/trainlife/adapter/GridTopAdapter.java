package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/23.
 */

public class GridTopAdapter extends BaseAdapter {
    private final Context context;
    private final int[] datas;
    private final String[] names;

    public GridTopAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.datas = images;
        this.names = names;
    }

    @Override
    public int getCount() {
        return datas.length;
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
            convertView = View.inflate(context, R.layout.top_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.ivTop.setImageResource(datas[position]);
        viewHolder.tvTop.setText(names[position]);
        return convertView;
    }



    static class ViewHolder {
        @Bind(R.id.iv_top)
        ImageView ivTop;
        @Bind(R.id.tv_top)
        TextView tvTop;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
