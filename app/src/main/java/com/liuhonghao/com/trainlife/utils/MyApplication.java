package com.liuhonghao.com.trainlife.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;

/**
 * Created by 刘红豪 on 2017/3/10.
 */
public class MyApplication extends Application {
    public static Context context;//
    public static Handler handler;//handler
    public static Thread mainThread;//
    public static int mainThreadId;//id

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        handler = new Handler();
        mainThread = Thread.currentThread();//实例化当前Application的线程即为主线程
        mainThreadId = android.os.Process.myTid();//获取当前线程的id
        //初始化为捕获异常,一般不用，上线才用，不然没法查看错误啊
        //Crashhandleer.getinstance().init();
        /*FreelineCore.init(this);*/

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
