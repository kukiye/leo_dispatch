package com.enjoy.srl_vp;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomVPInner extends ViewPager {

    private float startX;
    private float startY;
    private float x;
    private float y;
    private float deltaX;
    private float deltaY;

    public CustomVPInner(Context context) {
        super(context);
    }

    public CustomVPInner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

   /* @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                x = ev.getX();
                y = ev.getY();
                deltaX = Math.abs(x - startX);
                deltaY = Math.abs(y - startY);
                if (deltaX < deltaY) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }*/
}
