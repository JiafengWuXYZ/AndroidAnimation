package com.jiafeng.androidanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Android属性动画
 */
public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton1, mButton2, mButton3, mButton4,mButton6, mButton7, mButton8, mButton9;
    private Button mButton5;
    private ImageView mImage;
    private LinearLayout mLinearLayout;

    private final int ANIMATION_DURATION = 3000;
    private final int ANIMATION_REPEAT_COUNT = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        setTitle("Android属性动画");
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

        mButton5 = (Button) findViewById(R.id.button5);
        mButton5.setOnClickListener(this);

        mButton6 = (Button) findViewById(R.id.button6);
        mButton6.setOnClickListener(this);

        mButton7 = (Button) findViewById(R.id.button7);
        mButton7.setOnClickListener(this);

        mButton8 = (Button) findViewById(R.id.button8);
        mButton8.setOnClickListener(this);

        mButton9 = (Button) findViewById(R.id.button9);
        mButton9.setOnClickListener(this);

        mLinearLayout = (LinearLayout) findViewById(R.id.activity_property_animation);

        /**
         * 设置布局动画，在ViewGroup添加View的时候显示效果
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        LayoutAnimationController controller = new LayoutAnimationController(scaleAnimation,1.0F);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        mLinearLayout.setLayoutAnimation(controller);

        mImage = (ImageView) findViewById(R.id.img);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1://透明度动画
                //第一个参数是要操作的View，第二个参数是要操作的属性，最后一个参数是可变数组参数
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImage, "alpha", 0, 1);
                animator1.setDuration(ANIMATION_DURATION);
                animator1.start();
                animator1.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                break;

            case R.id.button2://旋转动画
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImage, "rotation",  0,360,0);
//                ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImage,"rotationX",300);
//                ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImage,"rotationY",300);
                animator2.setDuration(ANIMATION_DURATION);
                animator2.start();
                break;

            case R.id.button3://平移动画
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImage, "translationX", 0,600,0);
//                ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImage,"translateY",300);
                animator3.setDuration(ANIMATION_DURATION);
                animator3.start();
                break;

            case R.id.button4://缩放动画
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImage, "scaleX", 1,3,1);
//                ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImage,"scaleY",3);
                animator4.setDuration(ANIMATION_DURATION);
                animator4.start();
                break;

            case R.id.button5://动画集合
                PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", 1, 0, 1);
                PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("rotation", 0,360,0);
                PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("translationX", 0,300,0);
                PropertyValuesHolder propertyValuesHolder4 = PropertyValuesHolder.ofFloat("scaleX", 3);
                ObjectAnimator.ofPropertyValuesHolder(mImage, propertyValuesHolder1, propertyValuesHolder2, propertyValuesHolder3,propertyValuesHolder4)
                        .setDuration(ANIMATION_DURATION)
                        .start();
                break;

            /**
             * 如果一个属性没有getSet方法怎么办呢
             * 方案1：自定义一个包装类，来间接地给这个属性增加get和set方法
             * 方案2：ValueAnimator
             */

            case R.id.button6://自定义getset的属性动画
                WrapperView wrapperView = new WrapperView(mImage);
                ObjectAnimator.ofFloat(wrapperView,"width",0,800,0).setDuration(ANIMATION_DURATION).start();
                break;

            case R.id.button7://ValueAnimator version >= 21
                ValueAnimator animator5 = ValueAnimator.ofArgb(0x11111111,0xFF998845);
                /**
                 * animator.setTarget(mButton5);有啥用？
                 */
               // animator.setTarget(mButton5);
                animator5.setDuration(ANIMATION_DURATION).start();
                animator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int value = (int)animation.getAnimatedValue();
                        mButton5.setBackgroundColor(value);
                    }
                });
                break;

            case R.id.button8://
                Animator animator6 = AnimatorInflater.loadAnimator(PropertyAnimationActivity.this,R.animator.scale_x_anim);
                animator6.setTarget(mImage);
                animator6.start();
                break;

            case R.id.button9://
                mImage.animate().alpha(0).setDuration(3000).y(300).withStartAction(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mButton5.setVisibility(View.GONE);
                            }
                        });
                    }
                }).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mButton5.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                }).start();
                break;


        }
    }

    //属性包装类
    private static class WrapperView{
        private View mTaget;

        public WrapperView(View target){
            this.mTaget = target;
        }

        public int getWidth(){
            return mTaget.getLayoutParams().width;
        }

        public void setWidth(int width){
            mTaget.getLayoutParams().width = width;
            mTaget.requestLayout();
        }
    }
}
