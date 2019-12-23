package com.release.itoolbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;


/**
 * @author Mr.release
 * @create 2019/4/25
 * @Describe
 */
public class IToolBar extends FrameLayout {

    private ViewGroup toolBar;
    private ImageView iv_back;
    private TextView tv_title, tv_right;
    private static int mThemeColor,mTitleColor,mRightTitleColor,mHight,mBackDrawable;

    public IToolBar(Context context) {
        this(context, null);
    }

    public IToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public static void init(int themeColor) {
        mThemeColor = themeColor;
    }

    public static void init(int themeColor, int titleColor, int backDrawable) {
        mThemeColor = themeColor;
        mTitleColor = titleColor;
        mBackDrawable = backDrawable;
    }

    public static void init(int themeColor, int titleColor, int rightTitleColor, int backDrawable, int height) {
        mThemeColor = themeColor;
        mTitleColor = titleColor;
        mRightTitleColor = rightTitleColor;
        mBackDrawable = backDrawable;
        mHight = height;
    }


    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tool_bar_back, this, true);
        toolBar = view.findViewById(R.id.toolBar);
        iv_back = view.findViewById(R.id.iv_back);
        tv_title = view.findViewById(R.id.tv_title);
        tv_right = view.findViewById(R.id.tv_right);

        if (mThemeColor != 0) toolBar.setBackground(getResources().getDrawable(mThemeColor));
        if (mTitleColor != 0) tv_title.setTextColor(getResources().getColor(mTitleColor));
        if (mRightTitleColor != 0) tv_right.setTextColor(getResources().getColor(mRightTitleColor));
        if (mBackDrawable != 0) iv_back.setImageDrawable(getResources().getDrawable(mBackDrawable));

        if (mHight != 0){
            ViewGroup.LayoutParams layoutParams = toolBar.getLayoutParams();
            layoutParams.height = mHight;
            toolBar.setLayoutParams(layoutParams);
        }

        setBackFinish();
    }

    public IToolBar setBackGroundColor(int color) {
        toolBar.setBackground(getResources().getDrawable(color));
        return this;
    }


    public IToolBar setHeight(int height) {
        ViewGroup.LayoutParams layoutParams = toolBar.getLayoutParams();
        layoutParams.height = height;
        toolBar.setLayoutParams(layoutParams);
        return this;
    }

    public IToolBar setBackGone() {
        iv_back.setVisibility(View.INVISIBLE);
        return this;
    }

    public IToolBar setBackDrawable(Drawable drawable) {
        iv_back.setImageDrawable(drawable);
        return this;
    }

    public IToolBar setBackDrawable(int color) {
        iv_back.setImageDrawable(getResources().getDrawable(color));
        return this;
    }

    public IToolBar setRight(String right, OnClickListener clickListener) {
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText(right);
        tv_right.setOnClickListener(clickListener);
        return this;
    }

    public IToolBar setRight(int right, OnClickListener clickListener) {
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText(right);
        tv_right.setOnClickListener(clickListener);
        return this;
    }


    public IToolBar setRightGone(int Visible) {
        tv_right.setVisibility(Visible);
        return this;
    }


    public IToolBar setRightTextColor(int color) {
        tv_right.setTextColor(getResources().getColor(color));
        return this;
    }

    public IToolBar setRightSize(int textSize) {
        tv_right.setTextSize((float) textSize);
        return this;
    }

    public IToolBar setBackFinish() {
        iv_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
        return this;
    }


    public IToolBar setTitle(String title) {
        tv_title.setText(title);
        return this;
    }

    public IToolBar setTitle(int textId) {
        tv_title.setText(textId);
        return this;
    }

    public IToolBar setTitleColor(int color) {
        tv_title.setTextColor(getResources().getColor(color));
        return this;
    }

    public IToolBar setTitleSize(int textSize) {
        tv_title.setTextSize((float) textSize);
        return this;
    }

    public IToolBar setTitleSelected(boolean b) {
        tv_title.setSelected(b);
        return this;
    }
}
