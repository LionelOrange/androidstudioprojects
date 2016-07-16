package com.example.chen.teachshare.utils;

import android.content.Context;
import android.graphics.BitmapFactory;

/**
 * Created by Administrator on 2016/5/26.
 */
public class BitmapUtils {
    public static float getBitmapRatio(Context context, int resourceId) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), resourceId, options);
        return options.outHeight/(float)options.outWidth;
    }
}
