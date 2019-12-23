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

//        IToolBar.init(R.color.Green);
//        IToolBar.init(R.color.Purple,R.color.White,R.mipmap.toolbar_back_white);
//        IToolBar.init(R.color.Blue,R.color.White,R.color.Yellow,R.mipmap.toolbar_back_white,120);
    }
}
