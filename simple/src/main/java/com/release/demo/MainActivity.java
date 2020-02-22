package com.release.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.release.itoolbar.IToolBar;


public class MainActivity extends AppCompatActivity {

    private IToolBar mTb1, mTb2, mTb3, mTb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mTb1 = findViewById(R.id.tb_1);
        mTb2 = findViewById(R.id.tb_2);
        mTb3 = findViewById(R.id.tb_3);
        mTb4 = findViewById(R.id.tb_4);
    }

    private void initData() {
        mTb1.setTitle("标题1")
                .setBackIconVisible(View.GONE);

        mTb2.setTitle("标题2");

        mTb3.setTitle("标题3")
                .setRightText("分享")
                .setOnRightClickListener(new IToolBar.OnRightClickListener() {
                    @Override
                    public void onClick(TextView rightText) {
                        Toast.makeText(MainActivity.this, "分享", Toast.LENGTH_SHORT).show();
                    }
                });

        mTb4.setTitle("标题4")
                .setTitleColor(R.color.White)
                .setRightTextColor(R.color.White)
                .setBgColor(R.color.Pink)
                .setBackIconDrawable(R.mipmap.toolbar_back_white)
                .setRightText("更多")
                .setOnRightClickListener(new IToolBar.OnRightClickListener() {
                    @Override
                    public void onClick(TextView rightText) {
                        Toast.makeText(MainActivity.this, "更多", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
