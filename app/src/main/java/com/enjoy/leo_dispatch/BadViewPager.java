package com.enjoy.leo_dispatch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class BadViewPager extends ViewPager {

    private int mLastX, mLastY;

    public BadViewPager(@NonNull Context context) {
        super(context);
    }

    public BadViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    //google 在ViewPager内部做了事件冲突处理
    //以下是我们自己处理事件冲突
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        //        内部拦截法：子view处理事件冲突  （在ListView里也有处理）
        //        if (event.getAction() == MotionEvent.ACTION_DOWN){
        //            super.onInterceptTouchEvent(event);
        //            return false;
        //        }
        //        return true;


        // 外部拦截法：父容器处理冲突
        // 我想要把事件分发给谁就分发给谁
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mLastX = (int) event.getX();
                mLastY = (int) event.getY();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    return true;
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }

        return super.onInterceptTouchEvent(event);

    }
}
