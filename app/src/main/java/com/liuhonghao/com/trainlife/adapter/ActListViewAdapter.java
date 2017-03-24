package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import com.liuhonghao.com.trainlife.bean.LivePlayBean;
import com.liuhonghao.com.trainlife.utils.Constants;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class ActListViewAdapter extends BaseAdapter {
    private final Context mcontext;
    private final List<LivePlayBean.ResultBean.ActInfoBean> datas;

    public ActListViewAdapter(Context mcontext, List<LivePlayBean.ResultBean.ActInfoBean> act_info) {
        this.mcontext = mcontext;
        this.datas = act_info;
    }

    @Override
    public int getCount() {
        return 1;
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
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (convertview == null) {
            convertview = View.inflate(mcontext, R.layout.item_act, null);
            viewHolder=new ViewHolder(convertview);
            convertview.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertview.getTag();
        }
        LivePlayBean.ResultBean.ActInfoBean actInfoBean = datas.get(1);
        Glide.with(mcontext).load(Constants.BASE_URL_IMAGE+actInfoBean.getIcon_url()).into(viewHolder.ivAct);
        return convertview;
    }

    static class ViewHolder {

        ImageView ivAct;

        ViewHolder(View view) {
            ivAct = (ImageView) view.findViewById(R.id.iv_act);
        }
    }
}
