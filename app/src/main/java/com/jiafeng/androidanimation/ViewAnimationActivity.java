package com.jiafeng.androidanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Android视图动画
 */
public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton1, mButton2, mButton3, mButton4;
    private Button mButton5,mButton6;
    private ImageView mImage;

    private final int ANIMATION_DURATION = 3000;
    private final int ANIMATION_REPEAT_COUNT = 10;

    private AlphaAnimation mAlphaAnimation;
    private RotateAnimation mRotateAnimation;
    private TranslateAnimation mTranslateAnimation;
    private ScaleAnimation mScaleAnimation;
    private AnimationSet mAnimationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        setTitle("Android视图动画");
        initAnimation();
        initUI();
    }

    private void initAnimation() {
        initAlphaAnimation();
        initRotateAnimation();
        initTranslateAnimation();
        initScaleAnimation();
        initAnimationSet();
    }

    private void initAnimationSet() {

        /**
         * Constructor to use when building an AnimationSet from code
         *
         * @param shareInterpolator Pass true if all of the animations in this set
         *        should use the interpolator associated with this AnimationSet.
         *        Pass false if each animation should use its own interpolator.
         *                          就是讲子动画是否使用这个集合动画的变速器
         */
        mAnimationSet = new AnimationSet(false);
        mAnimationSet.setDuration(ANIMATION_DURATION);
        mAnimationSet.addAnimation(mAlphaAnimation);
        mAnimationSet.addAnimation(mRotateAnimation);
        mAnimationSet.addAnimation(mScaleAnimation);
        mAnimationSet.addAnimation(mTranslateAnimation);
    }

    private void initScaleAnimation() {
        mScaleAnimation = new ScaleAnimation(0, 5, 0, 5, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        mScaleAnimation.setDuration(ANIMATION_DURATION);
    }

    private void initTranslateAnimation() {
        mTranslateAnimation = new TranslateAnimation(0, 100, 0, 100);
        //  mTranslateAnimation = new TranslateAnimation(0, 100, 0, 100, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        mTranslateAnimation.setDuration(ANIMATION_DURATION);
        //每一个Animation都可以设置监听器
        mTranslateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始的时候执行
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束的时候执行
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复时候执行
            }
        });
    }

    private void initRotateAnimation() {
        /**
         * Constructor to use when building a RotateAnimation from code
         *
         * @param fromDegrees Rotation offset to apply at the start of the
         *        animation.
         *
         * @param toDegrees Rotation offset to apply at the end of the animation.
         *
         * @param pivotX The X coordinate of the point about which the object is
         *        being rotated, specified as an absolute number where 0 is the left
         *        edge.
         * @param pivotY The Y coordinate of the point about which the object is
         *        being rotated, specified as an absolute number where 0 is the top
         *        edge.
         */
        mRotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5F,Animation.RELATIVE_TO_SELF, 0.5F);
        mRotateAnimation.setDuration(ANIMATION_DURATION);
    }

    private void initAlphaAnimation() {
        /**
         * Constructor to use when building an AlphaAnimation from code
         *
         * @param fromAlpha Starting alpha value for the animation, where 1.0 means
         *        fully opaque and 0.0 means fully transparent.
         * @param toAlpha Ending alpha value for the animation.
         */
        mAlphaAnimation = new AlphaAnimation(0, 1);//透明度从0到1
        mAlphaAnimation.setDuration(ANIMATION_DURATION);
        //mAlphaAnimation.setRepeatMode(Animation.RESTART);//从头开始重复(默认)
        //mAlphaAnimation.setRepeatMode(Animation.REVERSE);//从尾部开始重复
        //mAlphaAnimation.setRepeatCount(ANIMATION_REPEAT_COUNT);//设置重复的次数
        //mAlphaAnimation.setFillAfter(true);//设置动画结束后是否保留在动画执行后的状态
        //mAlphaAnimation.setStartOffset(1000);//设置动画执行推迟的时间
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
        mImage = (ImageView) findViewById(R.id.img);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1://透明度动画
                mImage.startAnimation(mAlphaAnimation);
                break;

            case R.id.button2://旋转动画
                mImage.startAnimation(mRotateAnimation);
                break;

            case R.id.button3://平移动画
                mImage.startAnimation(mTranslateAnimation);
                break;

            case R.id.button4://缩放动画
                mImage.startAnimation(mScaleAnimation);
                break;

            case R.id.button5://动画集合
                mImage.startAnimation(mAnimationSet);

            case R.id.button6://动画集合
                mImage.startAnimation(mAnimationSet);
                break;
        }
    }
}