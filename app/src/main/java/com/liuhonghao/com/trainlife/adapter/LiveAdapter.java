package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import com.liuhonghao.com.trainlife.bean.LivePlayBean;
import com.liuhonghao.com.trainlife.utils.Constants;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class LiveAdapter extends RecyclerView.Adapter {
    private final Context mcontext;
    private final LivePlayBean.ResultBean datas;


    public LiveAdapter(Context mContext, LivePlayBean.ResultBean result) {
        this.mcontext = mContext;
        this.datas = result;
        inflater = LayoutInflater.from(mcontext);
    }

    private int currentType = BANNER;
    private static final int BANNER = 0;
    private static final int ACT = 3;
    private static final int SECKILL = 1;
    private static final int RECOMMEND = 2;
    private static final int HOT = 4;
    private LayoutInflater inflater;

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currentType = BANNER;
        }
        if (position == ACT) {
            currentType = ACT;
        }
        if (position == SECKILL) {
            currentType = SECKILL;
        }
        if (position == RECOMMEND) {
            currentType = RECOMMEND;
        }
        if (position == HOT) {
            currentType = HOT;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            return new BannerViewHolder(mcontext, inflater.inflate(R.layout.banner_viewpager, null));

        } else if (viewType == ACT) {
            return new ActViewHolder(mcontext, inflater.inflate(R.layout.act_item, null));

        } else if (viewType == SECKILL) {
            return new SeckillViewHolder(mcontext, inflater.inflate(R.layout.seckill_item, null));
        } else if (viewType == RECOMMEND) {
            return new RecommendViewHolder(mcontext, inflater.inflate(R.layout.recommend_item, null));

        }
         else if (viewType == HOT) {
            return new RecommendViewHolder(mcontext, inflater.inflate(R.layout.recommend_item, null));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER) {
            BannerViewHolder viewHolder = (BannerViewHolder) holder;
            viewHolder.setData(datas.getBanner_info());

        } else if (getItemViewType(position) == ACT) {
            ActViewHolder actViewHolder= (ActViewHolder) holder;
            actViewHolder.setData(datas.getAct_info());

        } else if (getItemViewType(position) == SECKILL) {
            SeckillViewHolder seckillViewHolder = (SeckillViewHolder) holder;
            seckillViewHolder.setData(datas.getSeckill_info());


        } else if (getItemViewType(position) == RECOMMEND) {
            RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
            recommendViewHolder.setData(datas.getRecommend_info());
        }
        else if (getItemViewType(position) == HOT) {
            RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
            recommendViewHolder.setData(datas.getRecommend_info());
            recommendViewHolder.linea.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        private final Context mcontext;
        private Banner banner;

        BannerViewHolder(Context mcontext, View view) {
            super(view);
            this.mcontext = mcontext;
            banner = (Banner) view.findViewById(R.id.banner);
        }

        public void setData(List<LivePlayBean.ResultBean.BannerInfoBean> banner_info) {
            List<String> images = new ArrayList<>();
            for (int i = 0; i < banner_info.size(); i++) {
                images.add(Constants.BASE_URL_IMAGE + banner_info.get(i).getImage());
            }
            //设置图片到Banner上
            banner.setImages(images)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            //获取图片
                            Glide.with(context)
                                    .load(path).crossFade()
                                    .into(imageView);
                        }
                    }).start();
            banner.setBannerAnimation(Transformer.Accordion);
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(mcontext, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    class SeckillViewHolder extends RecyclerView.ViewHolder {

        private final Context mcontext;
        private RecyclerView rvSeckill;
        private SeckillRecyclerViewAdapter seckillRecyclerViewAdapter;

        SeckillViewHolder(Context mcontext, View view) {
            super(view);
            this.mcontext = mcontext;
            rvSeckill = (RecyclerView) view.findViewById(R.id.rv_seckill);
        }

        public void setData(LivePlayBean.ResultBean.SeckillInfoBean seckill_info) {
            seckillRecyclerViewAdapter = new SeckillRecyclerViewAdapter(mcontext, seckill_info);
            rvSeckill.setAdapter(seckillRecyclerViewAdapter);
            rvSeckill.setLayoutManager(new LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout linea;
        private final Context mcontext;
        GridView gvRecommend;
        private RecommendGridViewAdapter recommendGridViewAdapter;
        private TextView tvr;
        RecommendViewHolder(final Context mcontext, View view) {
            super(view);
            this.mcontext = mcontext;
             linea = (LinearLayout) view.findViewById(R.id.lv_show_more);
            gvRecommend = (GridView) view.findViewById(R.id.gv_recommend);
             tvr  = (TextView) view.findViewById(R.id.tv_refresh);
            tvr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recommendGridViewAdapter.notifyDataSetInvalidated();
                    Toast.makeText(mcontext, "已刷新", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setData(final List<LivePlayBean.ResultBean.RecommendInfoBean> recommend_info) {
            recommendGridViewAdapter = new RecommendGridViewAdapter(mcontext, recommend_info);
            gvRecommend.setAdapter(recommendGridViewAdapter);
            gvRecommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(mcontext, "i==" + recommend_info.get(i).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    static class ActViewHolder extends RecyclerView.ViewHolder {
        private ActListViewAdapter listViewAdapter;
        private final Context mcontext;
        ListView listAct;
        ActViewHolder(Context mcontext, View view) {
            super(view);
            this.mcontext=mcontext;
            listAct= (ListView) view.findViewById(R.id.list_act);
        }

        public void setData(List<LivePlayBean.ResultBean.ActInfoBean> act_info) {
            listViewAdapter=new ActListViewAdapter(mcontext,act_info);
            listAct.setAdapter(listViewAdapter);
        }
    }
}
