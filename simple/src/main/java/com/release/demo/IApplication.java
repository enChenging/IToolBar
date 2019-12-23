package com.release.demo;

import android.app.Application;

import com.release.itoolbar.IToolBar;

/**
 * @author Mr.release
 * @create 2019-12-21
 * @Describe
 */
public class IApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //第一种方式：只统一IToolBar背景色
//        IToolBar.init(R.color.Green);
        //第二种方式：统一IToolBar背景色、标题色、返回键图标
//        IToolBar.init(R.color.Purple,R.color.White,R.mipmap.toolbar_back_white);
        //第三种方式：统一IToolBar背景色、标题色、右边文本颜色、返回键图标、整体高度
//        IToolBar.init(R.color.Blue,R.color.White,R.color.Yellow,R.mipmap.toolbar_back_white,120);
    }
}
