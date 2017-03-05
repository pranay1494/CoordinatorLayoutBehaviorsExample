package com.customview.pranay.coordinatorlayoutbehaviors;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Pranay on 05-03-2017.
 */

public class TextViewBehavior extends CoordinatorLayout.Behavior {
    public TextViewBehavior() {
    }

    public TextViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof ListView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        if (child instanceof TextView &&dependency instanceof ListView){
            ListView listView = (ListView) dependency;
            TextView textView = (TextView) child;
            if (listView.getFirstVisiblePosition()>=3){
                textView.setTextSize(20);
            }else{
                textView.setTextSize(80);
            }
        }
        return false;
    }
}
