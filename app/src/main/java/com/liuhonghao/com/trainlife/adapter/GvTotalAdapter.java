package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuhonghao.com.trainlife.bean.RecommandBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/22.
 */

public class GvTotalAdapter extends RecyclerView.Adapter<GvTotalAdapter.MyViewHolder> {
    private final Context mcontext;
    private final List<RecommandBean.DataBean> datas;
    private LayoutInflater inflater;
    public GvTotalAdapter(Context context, List<RecommandBean.DataBean> data) {
        this.mcontext=context;
        this.datas=data;
        inflater = LayoutInflater.from(mcontext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.total_item, null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecommandBean.DataBean dataBean = datas.get(position);
        Glide.with(mcontext).load(dataBean.getCover()).into(holder.itemLiveCover);
        holder.tvContent.setText(dataBean.getTitle());
        holder.tvPlay.setText(dataBean.getPlay()+"");
        holder.tvRecommend.setText(dataBean.getDanmaku()+"");


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    /*private final Context mcontext;
    private final List<RecommandBean.DataBean> datas;

    public GvTotalAdapter(Context context, List<RecommandBean.DataBean> data) {
        this.mcontext = context;
        this.datas = data;
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
            convertview = View.inflate(mcontext, R.layout.total_item, null);
            viewHolder=new ViewHolder(convertview);
            convertview.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertview.getTag();
        }
        RecommandBean.DataBean dataBean = datas.get(position);
        Glide.with(mcontext).load(dataBean.getCover()).into(viewHolder.itemLiveCover);
        *//*viewHolder.tvContent.setText(dataBean.getTitle());
        viewHolder.tvPlay.setText(dataBean.getPlay());
        viewHolder.tvRecommend.setText(dataBean.getDanmaku());*//*
        return convertview;
    }
*/
  class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_live_cover)
        ImageView itemLiveCover;
        @Bind(R.id.tv_content)
        TextView tvContent;
        @Bind(R.id.tv_play)
        TextView tvPlay;
        @Bind(R.id.tv_recommend)
        TextView tvRecommend;
        @Bind(R.id.item_live_layout)
        LinearLayout itemLiveLayout;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick(view,getLayoutPosition());
                    }
                }
            });
        }
    }
   private OnItemClickListener onItemClickListener=null;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
