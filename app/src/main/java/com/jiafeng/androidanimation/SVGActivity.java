package com.jiafeng.androidanimation;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * SVG的常用指令
 * M 200,500 将起始点放到（200,500）
 * L 200,300 500,900 从起始点开始扯线到（200,300），再把线扯到（500,900）
 * H V 后面绘制横线和竖线
 * A RX,RY XROTATION FLAG1,FLAG2 X,Y
 * 其中RX，RY为椭圆所在的半径大小
 * XRotation 指椭圆的x轴向和水平方向顺时针的夹角
 * Flag1： 1 大角度弧线  0 小角度弧线
 * Flag2:  1 顺时针      0 逆时针
 * x,y 终点坐标
 */
public class SVGActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton1, mButton2, mButton3, mButton4;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);

        initUI();
    }

    private void initUI() {
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton3.setOnClickListener(this);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton4.setOnClickListener(this);
        mImage = (ImageView) findViewById(R.id.img);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
             //   mImage.setImageResource(R.drawable.arc_avd);
                Drawable drawable1 = mImage.getDrawable();
                if (drawable1 instanceof Animatable) {
                    ((Animatable) drawable1).start();
                }
                break;

            case R.id.button2:
//                mImage.setImageResource(R.drawable.animate_vector);
                Drawable drawable2 = mImage.getDrawable();
                if (drawable2 instanceof Animatable) {
                    ((Animatable) drawable2).start();
                }
                break;

            case R.id.button3:
                break;

            case R.id.button4:
                break;

        }
    }
}
