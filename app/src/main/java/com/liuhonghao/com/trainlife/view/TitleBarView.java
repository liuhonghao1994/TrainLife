package com.liuhonghao.com.trainlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by 刘红豪 on 2017/1/6.
 */

public class TitleBarView extends LinearLayout implements View.OnClickListener {
    private Context mcontext;

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mcontext=context;
    }
    //每次布局接在完成后得到此方法

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }


    @Override
    public void onClick(View view) {


    }
}
