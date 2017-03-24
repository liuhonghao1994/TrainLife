package com.liuhonghao.com.trainlife.fragment;

import android.graphics.drawable.Drawable;
import android.liuhonghao.com.trainlife.R;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.liuhonghao.com.trainlife.base.BaseFragment;
import com.liuhonghao.com.trainlife.bean.TagBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘红豪 on 2017/3/21.
 */
//http://app.bilibili.com/x/v2/search/hot?appkey=1d8b6e7d45233436&build=501000&lim
public class FindFragment extends BaseFragment {
    private String url="http://app.bilibili.com/x/v2/search/hot?appkey=1d8b6e7d45233436&build=501000&lim" +
            "it=50&mobi_app=android&platform=android&ts=1490014710000&sign=e5ddf94fa9a0d6876cb85756c37c4adc";
    private boolean isShowMore = true;
    @Bind(R.id.search_scan)
    ImageView searchScan;
    @Bind(R.id.search_edit)
    TextView searchEdit;
    @Bind(R.id.search_img)
    ImageView searchImg;
    @Bind(R.id.card_view)
    CardView cardView;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.tags_layout)
    TagFlowLayout tagsLayout;
    @Bind(R.id.hide_tags_layout)
    TagFlowLayout hideTagsLayout;
    @Bind(R.id.hide_scroll_view)
    NestedScrollView hideScrollView;
    @Bind(R.id.tv_more)
    TextView tvMore;
    @Bind(R.id.more_layout)
    LinearLayout moreLayout;
    @Bind(R.id.ic_quanzi)
    ImageView icQuanzi;
    @Bind(R.id.ic_quanzi_layout)
    RelativeLayout icQuanziLayout;
    @Bind(R.id.ic_topic)
    ImageView icTopic;
    @Bind(R.id.topic_center_layout)
    RelativeLayout topicCenterLayout;
    @Bind(R.id.ic_activity)
    ImageView icActivity;
    @Bind(R.id.activity_center_layout)
    RelativeLayout activityCenterLayout;
    @Bind(R.id.ic_original)
    ImageView icOriginal;
    @Bind(R.id.layout_original)
    RelativeLayout layoutOriginal;
    @Bind(R.id.ic_all_rank)
    ImageView icAllRank;
    @Bind(R.id.layout_all_rank)
    RelativeLayout layoutAllRank;
    @Bind(R.id.ic_game)
    ImageView icGame;
    @Bind(R.id.layout_game_center)
    RelativeLayout layoutGameCenter;
    @Bind(R.id.ic_shop)
    ImageView icShop;
    @Bind(R.id.layout_shop)
    RelativeLayout layoutShop;
    private List<TagBean.DataBean.ListBean> list;
    @Override
    public int getLayoutid() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initData(String json) {
        TagBean tagBean = JSON.parseObject(json, TagBean.class);
        list = tagBean.getData().getList();
        List<TagBean.DataBean.ListBean> hotTags = list.subList(0, 8);
        tagsLayout.setAdapter(new TagAdapter<TagBean.DataBean.ListBean>(hotTags) {
            @Override
            public View getView(FlowLayout parent, int position, final TagBean.DataBean.ListBean hotTags) {

                TextView mTags = (TextView) LayoutInflater.from(getActivity())
                        .inflate(R.layout.layout_tags_item, parent, false);
                mTags.setText(hotTags.getKeyword());

                mTags.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, hotTags.getKeyword() + "", Toast.LENGTH_SHORT).show();
                    }
                });

                return mTags;
            }
        });
        hideTagsLayout.setAdapter(new TagAdapter<TagBean.DataBean.ListBean>(list) {
            @Override
            public View getView(FlowLayout parent, int position, final TagBean.DataBean.ListBean list) {

                TextView mTags = (TextView) LayoutInflater.from(getActivity())
                        .inflate(R.layout.layout_tags_item, parent, false);
                mTags.setText(list.getKeyword());

                mTags.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, list.getKeyword() + "", Toast.LENGTH_SHORT).show();
                    }
                });

                return mTags;
            }
        });

        initListener();
    }

    @Override
    public String getChildUrl() {
        return url;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    private void initListener() {
        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShowMore) {
                    isShowMore = false;
                    hideScrollView.setVisibility(View.VISIBLE);
                    tvMore.setText("收起");
                    tagsLayout.setVisibility(View.GONE);
                    Drawable upDrawable = getResources().getDrawable(R.drawable.ic_arrow_up_gray_round);
                    upDrawable.setBounds(0, 0, upDrawable.getMinimumWidth(), upDrawable.getMinimumHeight());
                    tvMore.setCompoundDrawables(upDrawable, null, null, null);
                } else {
                    isShowMore = true;
                    hideScrollView.setVisibility(View.GONE);
                    tvMore.setText("查看更多");
                    tagsLayout.setVisibility(View.VISIBLE);
                    Drawable downDrawable = getResources().getDrawable(R.drawable.ic_arrow_down_gray_round);
                    downDrawable.setBounds(0, 0, downDrawable.getMinimumWidth(), downDrawable.getMinimumHeight());
                    tvMore.setCompoundDrawables(downDrawable, null, null, null);
                }
            }
        });
    }
}
