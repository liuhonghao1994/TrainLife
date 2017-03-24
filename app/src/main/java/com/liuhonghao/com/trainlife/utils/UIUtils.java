package com.liuhonghao.com.trainlife.utils;

import android.content.Context;
import android.os.Handler;
import android.view.View;

/**
 * Created by 刘红豪 on 2017/3/10.
 */
//工具类，handler，context，将固定的值写入values中的strings进行获取，与屏幕分辨率相关的
public class UIUtils {
    public static Context getContext(){
        return MyApplication.context;
    }

    public static Handler getHandler(){
        return MyApplication.handler;
    }

    public static int getColor(int colorId){
        return getContext().getResources().getColor(colorId);
    }

    public static View getView(int viewId){
        return View.inflate(getContext(), viewId, null);
    }
//将固定的值写入values中的strings进行获取
    public static String[] getStringArray(int arrId){
        return getContext().getResources().getStringArray(arrId);
    }

    //与屏幕分辨率相关的
    public static int dp2px(int dp){
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5);
    }

    public static int px2dp(int px){
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);
    }

    public static void runOnUiThread(Runnable runnable) {
        if(MyApplication.mainThreadId==android.os.Process.myPid()){
            runnable.run();
        }else{
            MyApplication.handler.post(runnable);
        }
    }
}
