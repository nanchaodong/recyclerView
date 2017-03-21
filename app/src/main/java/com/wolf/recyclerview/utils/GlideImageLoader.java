package com.wolf.recyclerview.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wolf.recyclerview.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(imageView.getContext()).load((String) path).placeholder(R.mipmap.ic_loading).error(R.mipmap.ic_loading).into(imageView);
    }
}
