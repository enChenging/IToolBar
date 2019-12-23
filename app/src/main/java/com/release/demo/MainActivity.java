package com.release.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.release.itoolbar.IToolBar;

public class MainActivity extends AppCompatActivity {

    private IToolBar mTb1,mTb2,mTb3,mTb4;

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
        mTb1.setTitle("标题1");
        mTb1.setBackGone();

        mTb2.setTitle("标题2");

        mTb3.setTitle("标题3");
        mTb3.setRight("分享", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "分享", Toast.LENGTH_SHORT).show();
            }
        });

        mTb4.setTitle("标题4");
        mTb4.setTitleColor(R.color.White);
        mTb4.setRightTextColor(R.color.White);
        mTb4.setBackGroundColor(R.color.Pink);
        mTb4.setBackDrawable(R.mipmap.toolbar_back_white);
        mTb4.setRight("更多", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "更多", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
