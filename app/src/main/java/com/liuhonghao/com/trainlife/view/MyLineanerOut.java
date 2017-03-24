package com.liuhonghao.com.trainlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by 刘红豪 on 2017/3/23.
 */

public class MyLineanerOut extends LinearLayout {

    public MyLineanerOut(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
