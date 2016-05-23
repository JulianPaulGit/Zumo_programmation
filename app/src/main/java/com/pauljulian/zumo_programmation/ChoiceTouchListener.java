package com.pauljulian.zumo_programmation;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Drag listener
 */
public final class ChoiceTouchListener implements View.OnTouchListener {

    private int delta_x, delta_y;
    private Rect rect = new Rect(300,100,600,600);
    private ViewGroup viewGroup;

    public ChoiceTouchListener(ViewGroup viewGroup) {
        super();
        this.viewGroup = viewGroup;

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lparams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                delta_x = X - lparams.leftMargin;
                delta_y = Y - lparams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                // When the user release the action
                invisible(view);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = X - delta_x;
                layoutParams.topMargin = Y - delta_y;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                view.setLayoutParams(layoutParams);
                break;
        }
        viewGroup.invalidate();
        return true;
    }

    public void invisible(View view) {
        view.setVisibility(view.INVISIBLE);
    }

}