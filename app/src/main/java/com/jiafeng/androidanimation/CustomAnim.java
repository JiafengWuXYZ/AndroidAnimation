package com.jiafeng.androidanimation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

/**
 * 自定义旋转动画
 * Created by Jiafeng on 2016/11/18.
 */

public class CustomAnim extends Animation {
    private int mCenterWidth;
    private int mCenterHeight;

    private Camera mCamera = new Camera();
    private float mRotateY = 0.0f;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        setDuration(2000);
        setFillAfter(true);
        setInterpolator(new BounceInterpolator());
        mCenterWidth = height/2;
        mCenterWidth = width/2;
    }

    public void setRotateY(float rotateY) {
        mRotateY = rotateY;
    }

    /**
     *
     * @param interpolatedTime 插值器的时间因子，0.0f ~ 1.0f
     * @param t 矩阵封装类，获取当前的矩阵
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        final Matrix matrix = t.getMatrix();
        mCamera.save();
        mCamera.rotateY(mRotateY*interpolatedTime);
        mCamera.translate(300*interpolatedTime,0,0);
        mCamera.getMatrix(matrix);
        mCamera.restore();

        matrix.preTranslate(mCenterWidth,mCenterHeight);
        matrix.postTranslate(-mCenterWidth,-mCenterHeight);
    }
}
