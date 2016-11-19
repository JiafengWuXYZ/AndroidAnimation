package com.jiafeng.androidanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton1, mButton2,mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1://视图动画
                Intent intent1 = new Intent(MainActivity.this, ViewAnimationActivity.class);
                startActivity(intent1);
                break;

            case R.id.button2://属性动画
                Intent intent2 = new Intent(MainActivity.this, PropertyAnimationActivity.class);
                startActivity(intent2);
                break;

            case R.id.button3://SVG动画
                Intent intent3 = new Intent(MainActivity.this, SVGActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
