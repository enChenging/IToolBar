package com.release.itoolbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * @author Mr.release
 * @create 2019/4/25
 * @Describe
 */
public class IToolBar extends FrameLayout {

    private static int mThemeBgColor, mTitleColor, mRightTitleColor, mHight, mBackDrawable;
    private ViewGroup toolBar;
    private ImageView iv_back_icon;
    private View bottom_line;
    private TextView tv_title, tv_right;
    private String title, rightText;
    private int background, backIcon, titleColor, rightColor, titleSize, rightSize, line_color, line_height;
    private boolean titleSelect, rightVisible, line_visible;


    public IToolBar(Context context) {
        this(context, null);
    }

    public IToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IToolBar);
        title = typedArray.getString(R.styleable.IToolBar_title);
        titleColor = typedArray.getResourceId(R.styleable.IToolBar_titleColor, R.color.Black);
        titleSize = typedArray.getDimensionPixelSize(R.styleable.IToolBar_titleSize, getResources().getDimensionPixelSize(R.dimen.default_toolbar_title_size));
        titleSelect = typedArray.getBoolean(R.styleable.IToolBar_titleSelect, false);
        rightText = typedArray.getString(R.styleable.IToolBar_rightText);
        rightColor = typedArray.getResourceId(R.styleable.IToolBar_rightColor, R.color.Blue);
        rightSize = typedArray.getDimensionPixelSize(R.styleable.IToolBar_rightSize, getResources().getDimensionPixelSize(R.dimen.default_toolbar_title_right_size));
        rightVisible = typedArray.getBoolean(R.styleable.IToolBar_rightVisible, false);
        background = typedArray.getResourceId(R.styleable.IToolBar_background, R.color.Transparent);
        backIcon = typedArray.getResourceId(R.styleable.IToolBar_backIcon, R.mipmap.toolbar_back);
        line_color = typedArray.getResourceId(R.styleable.IToolBar_bottom_line_color, R.color.Black);
        line_height = typedArray.getDimensionPixelSize(R.styleable.IToolBar_bottom_line_height, getResources().getDimensionPixelSize(R.dimen.default_toolbar_bottom_line));
        line_visible = typedArray.getBoolean(R.styleable.IToolBar_bottom_line_visible, false);
        initView(context);
    }

    public static void init(int themeBgColor) {
        mThemeBgColor = themeBgColor;
    }

    public static void init(int themeBgColor, int titleColor, int backDrawable) {
        mThemeBgColor = themeBgColor;
        mTitleColor = titleColor;
        mBackDrawable = backDrawable;
    }

    public static void init(int themeBgColor, int titleColor, int rightTitleColor, int backDrawable, int height) {
        mThemeBgColor = themeBgColor;
        mTitleColor = titleColor;
        mRightTitleColor = rightTitleColor;
        mBackDrawable = backDrawable;
        mHight = height;
    }


    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tool_bar_back, this, true);
        toolBar = view.findViewById(R.id.toolBar);
        iv_back_icon = view.findViewById(R.id.iv_back_icon);
        tv_title = view.findViewById(R.id.tv_title);
        tv_right = view.findViewById(R.id.tv_right);
        bottom_line = view.findViewById(R.id.bottom_line);


        setAttributesStyled();
        setThemeStyle();
        setListener();
    }

    private void setAttributesStyled() {
        setBgColor(background);
        setBackIconDrawable(backIcon);
        setTitleColor(titleColor);
        setRightTextColor(rightColor);

        setTitle(title);
        setTitleSize(DensityUtil.px2sp(getContext(), titleSize));
        setTitleSelected(titleSelect);
        setRightText(rightText);
        setRightSize(DensityUtil.px2sp(getContext(), rightSize));
        setRightVisible(rightVisible ? VISIBLE : GONE);
        setBottomLineColor(line_color);
        setBottomLineHeight(DensityUtil.px2dip(getContext(), line_height));
        setBottomLineVisible(line_visible ? VISIBLE : GONE);
    }


    /**
     * 默认背景色透明、标题色黑色、右边文本色蓝色
     * 建议：不要重复设置默认色值
     */
    private void setThemeStyle() {
        if (mThemeBgColor != 0 && background == R.color.Transparent)
            setBgColor(mThemeBgColor);
        if (mBackDrawable != 0 && backIcon == R.mipmap.toolbar_back)
            setBackIconDrawable(mBackDrawable);
        if (mTitleColor != 0 && titleColor == R.color.Black)
            setTitleColor(mTitleColor);
        if (mRightTitleColor != 0 && rightColor == R.color.Blue)
            setRightTextColor(mRightTitleColor);
        if (mHight != 0)
            setHeight(mHight);
    }

    private OnRightClickListener mOnRightClickListener;

    public interface OnRightClickListener {
        void onClick(TextView rightText);
    }

    public void setOnRightClickListener(OnRightClickListener clickListener) {
        this.mOnRightClickListener = clickListener;
    }

    private OnBackClickListener mOnBackClickListener;

    public interface OnBackClickListener {
        void onClick(ImageView iv_back_icon);
    }

    public void setOnBackhtClickListener(OnBackClickListener clickListener) {
        this.mOnBackClickListener = clickListener;
    }


    /**
     * 背景色
     *
     * @param color
     * @return
     */
    public IToolBar setBgColor(int color) {
        toolBar.setBackground(getResources().getDrawable(color));
        return this;
    }

    /**
     * 布局高度
     *
     * @param height
     * @return
     */
    public IToolBar setHeight(int height) {
        ViewGroup.LayoutParams layoutParams = toolBar.getLayoutParams();
        layoutParams.height = height;
        toolBar.setLayoutParams(layoutParams);
        return this;
    }

    /**
     * 设置底部line的高度
     *
     * @param height
     * @return
     */
    public IToolBar setBottomLineHeight(int height) {
        ViewGroup.LayoutParams layoutParams = bottom_line.getLayoutParams();
        layoutParams.height = height;
        bottom_line.setLayoutParams(layoutParams);
        return this;
    }

    /**
     * 设置底部line的显隐
     *
     * @param visible
     */
    private void setBottomLineVisible(int visible) {
        bottom_line.setVisibility(visible);
    }

    /**
     * 设置底部line的颜色
     *
     * @param color
     */
    private void setBottomLineColor(int color) {
        bottom_line.setBackgroundColor(getResources().getColor(color));
    }

    /**
     * 设置返回按钮的隐藏
     *
     * @return
     */
    public IToolBar setBackIconVisible(int visible) {
        iv_back_icon.setVisibility(visible);
        return this;
    }

    /**
     * 设置返回键图标
     *
     * @param drawable
     * @return
     */
    public IToolBar setBackIconDrawable(Drawable drawable) {
        iv_back_icon.setImageDrawable(drawable);
        return this;
    }

    /**
     * 设置返回键图标
     *
     * @param id
     * @return
     */
    public IToolBar setBackIconDrawable(@DrawableRes int id) {
        iv_back_icon.setImageDrawable(getResources().getDrawable(id));
        return this;
    }


    /**
     * 设置右边文本内容，及文本监听
     *
     * @param right
     * @return
     */
    public IToolBar setRightText(CharSequence right) {
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText(right);
        return this;
    }

    /**
     * 设置右边文本内容
     *
     * @param right
     * @return
     */
    public IToolBar setRightText(int right) {
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText(getResources().getText(right));
        return this;
    }


    /**
     * 设置右边文本显隐
     *
     * @param Visible
     * @return
     */
    public IToolBar setRightVisible(int Visible) {
        tv_right.setVisibility(Visible);
        return this;
    }


    /**
     * 设置右边文本颜色
     *
     * @param color
     * @return
     */
    public IToolBar setRightTextColor(int color) {
        tv_right.setTextColor(getResources().getColor(color));
        return this;
    }

    /**
     * 设置右边文本大小
     *
     * @param textSize
     * @return
     */
    public IToolBar setRightSize(float textSize) {
        tv_right.setTextSize(textSize);
        return this;
    }

    private void setListener() {
        iv_back_icon.setOnClickListener(v -> {
                    if (mOnBackClickListener != null)
                        mOnBackClickListener.onClick(iv_back_icon);
                    else
                        ((Activity) getContext()).finish();
                }
        );
        tv_right.setOnClickListener(v -> {
                    if (mOnRightClickListener != null) mOnRightClickListener.onClick(tv_right);
                }
        );
    }


    /**
     * 设置标题内容
     *
     * @param title
     * @return
     */
    public IToolBar setTitle(CharSequence title) {
        tv_title.setText(title);
        return this;
    }

    /**
     * 设置标题内容
     *
     * @param textId
     * @return
     */
    public IToolBar setTitle(int textId) {
        tv_title.setText(getResources().getText(textId));
        return this;
    }

    /**
     * 设置标题颜色
     *
     * @param color
     * @return
     */
    public IToolBar setTitleColor(int color) {
        tv_title.setTextColor(getResources().getColor(color));
        return this;
    }

    /**
     * 设置标题大小
     *
     * @param textSize
     * @return
     */
    public IToolBar setTitleSize(float textSize) {
        tv_title.setTextSize(textSize);
        return this;
    }

    /**
     * 设置标题是否被选中
     *
     * @param b
     * @return
     */
    public IToolBar setTitleSelected(boolean b) {
        tv_title.setSelected(b);
        return this;
    }


}
