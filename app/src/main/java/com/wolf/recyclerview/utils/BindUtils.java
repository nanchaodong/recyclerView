package com.wolf.recyclerview.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public class BindUtils {

    @BindingAdapter("imageUrl")
    public static void showImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
