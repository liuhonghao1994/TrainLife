package com.liuhonghao.com.trainlife.utils;

import android.content.Context;
import android.liuhonghao.com.trainlife.R;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


/**
 * Created by 刘红豪 on 2017/3/13.
 */

public abstract class LoadingPager extends FrameLayout {
    private View loadingView;
    private View errorView;
    private View emptyView;
    private View sucessView;
    private  Context context;
    private int STATE_LOADING = 1; //加载中
    private int STATE_ERROR = 2; //加载失败
    private int STATE_SUCCESS = 3; //加载成功
    private int STATE_EMPTY = 4; //空
    private int current_state = STATE_LOADING;
    private LayoutParams params;
    private ResultState resultState;

    public LoadingPager(Context context) {
        super(context);
        this.context=context;
        init();
    }
    /*
    * 添加三个布局
    *
    * */

    public LoadingPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }
    private void init() {
        params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        //加载布局
        if(loadingView==null){
            loadingView = View.inflate(context, R.layout.page_loading, null);
            this.addView(loadingView, params);
        }
        //失败布局
        if (errorView == null) {
            errorView = View.inflate(context, R.layout.page_error, null);
            this.addView(errorView, params);
        }
        //空布局
        if (emptyView == null) {
            emptyView = View.inflate(context, R.layout.page_empty, null);
            this.addView(emptyView, params);
        }
        //展示布局
        showSafeView();

    }

    private void showSafeView() {
        //在主线程中展现布局
        UIUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //展现布局
                showView();
            }
        });
    }

    private void showView() {
        //展现哪一种布局就看我们现在缓存状态是什么
            //是否展示错误页面
            errorView.setVisibility(
            current_state == STATE_ERROR ? View.VISIBLE : View.INVISIBLE);
            //是否展示加载界面
            loadingView.setVisibility(
            current_state == STATE_LOADING ? View.VISIBLE : View.INVISIBLE);
            //是否展示空页面
            emptyView.setVisibility(
            current_state == STATE_EMPTY ? View.VISIBLE : View.INVISIBLE);
            if (sucessView == null){
                int viewId = getViewId();
                if(viewId!=0){
                    sucessView = View.inflate(context, viewId, null);
                    this.addView(sucessView, params);
                }
                }
if(sucessView!=null){
    sucessView.setVisibility(
            current_state == STATE_SUCCESS ? View.VISIBLE : View.INVISIBLE);
}

    }
    /*
    * 根据不同的网络状态加载相应的页面
    *
    */
            public void loadData(){
            //加载网络

            String url = getUrl();
             if(TextUtils.isEmpty(url)){
                 resultState= ResultState.SUCCESS;
                 loadImage();
                 return;
             }
            OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    resultState = ResultState.ERROR;
                    resultState.setJson(e.getMessage());
                    loadImage();
                }

                @Override
                public void onResponse(String response, int id) {
                    if (TextUtils.isEmpty(response)){
                        resultState = ResultState.EMPTY;
                        resultState.setJson("");
                    }else{
                        resultState = ResultState.SUCCESS;
                        resultState.setJson(response);

                    }
                    loadImage();
                }
            });

   }
    //给他赋值给当前缓存的状态
    private void  loadImage() {
        switch (resultState) {
            case ERROR:
                current_state = STATE_ERROR; //根据枚举值来赋值相应的状态
                break;
            case EMPTY:
                current_state = STATE_EMPTY; //根据枚举值来赋值相应的状态break;
            case SUCCESS:
                current_state = STATE_SUCCESS; //根据枚举值来赋值相应的状态
                break;
        }
        showSafeView();
        //如果数据加载成功，那就是
        if (current_state == STATE_SUCCESS){
            //把数据传过去，视图和状态
            onSuccess(resultState,sucessView);
        }
    }
    //利用枚举给请求不同的状态设置不同的值
    public enum ResultState{
        //相当于是三个ResultState对象
        ERROR(2),SUCCESS(3),EMPTY(4);
        private int state;
        ResultState(int state){
            this.state = state;

        }
        //json字符串的get，set方法
        private String json;
        public void setJson(String json){
            this.json = json;
        }
        public String getJson(){
            return json;
        }

    }
    //必须实现的抽向方法是获取网络数据成功，成功后没有视图
    protected abstract void onSuccess(ResultState resultState, View sucessView);
    //网络地址
    protected abstract String getUrl();
    //成功后的视图id'
    public abstract int getViewId();
}
