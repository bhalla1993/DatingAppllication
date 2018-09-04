package com.wenkey.utils;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;

import com.wenkey.R;


/**
 * Created by Ali Assadi on 10/15/2017.
 */

public class Tools {
    public static View createTabIcon(@NonNull Context context, @DrawableRes int resId) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_badge, null);
        AppCompatImageView icon = (AppCompatImageView) view.findViewById(R.id.icon);
        icon.setImageResource(resId);
        icon.setAlpha(0.4f);
        return view;
    }
}
