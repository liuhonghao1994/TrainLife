package com.liuhonghao.com.trainlife.adapter;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.liuhonghao.com.trainlife.bean.FollowBean;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/21.
 */

public class FollowRecycleAdapter extends RecyclerView.Adapter {
    private final Context mcontext;
    private final FollowBean.ResultBean datas;
    private final LayoutInflater inflater;
    private static final int BANNER = 0;
    private static final int LIST = 1;
    private static final int DEVIDE = 2;
    private int currentType = BANNER;
    private static final int NewShow = 3;

    public FollowRecycleAdapter(Context mContext, FollowBean.ResultBean result) {
        this.mcontext = mContext;
        this.datas = result;
        inflater = LayoutInflater.from(mcontext);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currentType = BANNER;
        } else if (position == LIST) {
            currentType = LIST;
        } else if (position == DEVIDE) {
            currentType = DEVIDE;
        } else if (position == NewShow) {
            currentType = NewShow;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            return new BannerViewHolder(mcontext, inflater.inflate(R.layout.banner_item, null));
        }
        if (viewType == LIST) {
            return new MyListViewHolder(mcontext, inflater.inflate(R.layout.rv_head, null));
        }
        if (viewType == DEVIDE) {
            return new DeVideViewHolder(mcontext, inflater.inflate(R.layout.devide_item, null));
        }
        if (viewType == NewShow) {
            return new NewShowViewHolder(mcontext, inflater.inflate(R.layout.new_show, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.setData(datas.getAd().getHead());
        }
        if (getItemViewType(position) == LIST) {
            MyListViewHolder listViewHolder = (MyListViewHolder) holder;
        }
        if (getItemViewType(position) == DEVIDE) {
            DeVideViewHolder deVideViewHolder = (DeVideViewHolder) holder;
        }
        if (getItemViewType(position) == NewShow) {
            NewShowViewHolder newShowViewHolder = (NewShowViewHolder) holder;
            newShowViewHolder.setData(datas.getSerializing());
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        Banner banner;

        BannerViewHolder(Context mcontext, View view) {
            super(view);
            this.context = mcontext;
            banner = (Banner) view.findViewById(R.id.banner_follow);
        }

        public void setData(List<FollowBean.ResultBean.AdBean.HeadBean> bean) {
            List<String> images = new ArrayList<>();
            for (int i = 0; i < bean.size(); i++) {
                images.add(bean.get(i).getImg());
            }
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
            banner.isAutoPlay(false);
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    static class MyListViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.after_fanju)
        RelativeLayout afterFanju;
        @Bind(R.id.after_guoman)
        RelativeLayout afterGuoman;
        @Bind(R.id.ll_head)
        LinearLayout llHead;
        @Bind(R.id.after_shijianbiao)
        TextView afterShijianbiao;
        @Bind(R.id.after_suoyin)
        TextView afterSuoyin;
        @Bind(R.id.tv)
        LinearLayout tv;
        @Bind(R.id.after_nofanju)
        ImageView afterNofanju;

        MyListViewHolder(Context mcontext, View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class DeVideViewHolder extends RecyclerView.ViewHolder {
        DeVideViewHolder(Context mcontext, View view) {
            super(view);
        }
    }

    static class NewShowViewHolder extends RecyclerView.ViewHolder {
        private final Context mcontext;
        private GridView gvShow;
        private FollowGridViewAdapter followGridViewAdapter;

        NewShowViewHolder(Context mcontext, View view) {
            super(view);
            this.mcontext = mcontext;
            gvShow = (GridView) view.findViewById(R.id.gv_show);
        }

        public void setData(List<FollowBean.ResultBean.SerializingBean> serializing) {
            followGridViewAdapter = new FollowGridViewAdapter(mcontext, serializing);
            gvShow.setAdapter(followGridViewAdapter);
        }
    }


}
