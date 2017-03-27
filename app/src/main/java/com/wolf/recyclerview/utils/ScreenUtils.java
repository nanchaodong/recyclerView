package com.wolf.recyclerview.utils;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by nanchaodong on 2017/3/22.
 */

public class ScreenUtils {

    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }
}
