package com.zz.titlebar.initializers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.widget.TextView;

public class RippleTitleBarInitializer extends TransparentTitleBarInitializer {

    @Override
    public TextView getLeftView(Context context) {
        TextView leftView = super.getLeftView(context);
        Drawable drawable = getRippleDrawable(context);
        if (drawable != null) {
            setViewBackground(leftView, drawable);
        }
        return leftView;
    }

    @Override
    public TextView getRightView(Context context) {
        TextView rightView = super.getRightView(context);
        Drawable drawable = getRippleDrawable(context);
        if (drawable != null) {
            setViewBackground(rightView, drawable);
        }
        return rightView;
    }

    /**
     * 获取水波纹的点击效果
     */
    public Drawable getRippleDrawable(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true)) {
            return getDrawableResources(context, typedValue.resourceId);
        }
        return null;
    }
}
