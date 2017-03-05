package com.customview.pranay.coordinatorlayoutbehaviors;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Pranay on 05-03-2017.
 */

public class ListViewBehavior extends CoordinatorLayout.Behavior {
    public ListViewBehavior() {
    }

    public ListViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        if(child instanceof ListView && ev.getActionMasked() == MotionEvent.ACTION_DOWN){

            ListView lv = (ListView )child;
            List<View> dependentsLst = parent.getDependents(child);

            int txtTop = dependentsLst.get(0).getTop();
            int top = lv.getTop();

            if(top - txtTop > 450 && lv.getFirstVisiblePosition() >= 3){
                lv.setTop(lv.getTop() - 550);
            }else if(lv.getFirstVisiblePosition() < 3 && top - txtTop < 550){
                lv.setTop(lv.getTop() +  550);
            }
        }
        return false;
    }
}
