package com.wolf.recyclerview.utils;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.wolf.recyclerview.R;
import com.wolf.recyclerview.bean.Video;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public class BindUtils {

    @BindingAdapter("imageUrl")
    public static void showImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_loading).into(imageView);
    }

    @BindingAdapter("price")
    public static void showPrice(TextView textView, int price) {
        float a = price / 100.0f;
        String b = String.valueOf(a);
        textView.setText("¥" + b);
    }

    @BindingAdapter("oldPrice")
    public static void showOldPrice(TextView textView, int oldPrice) {
        float a = oldPrice / 100.0f;
        String b = String.valueOf(a);
        textView.setText("¥" + b);
        textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @BindingAdapter("sold")
    public static void soldOut(TextView textView, int sold) {
        textView.setText(sold + "件已售");
    }

    @BindingAdapter("soldImageUrl")
    public static void showShopImage(final ImageView imageView, String url) {
        final ViewGroup.LayoutParams lp = imageView.getLayoutParams();
        final int width = lp.width;
        ViewTarget<View, Bitmap> target = new ViewTarget<View, Bitmap>(imageView) {
            @Override
            public void onResourceReady(final Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                int  scaleType = resource.getHeight() / resource.getWidth();
                int imageHeight = width * scaleType;
                lp.height = imageHeight;
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setLayoutParams(lp);
                        imageView.setImageBitmap(resource);
                    }
                });


            }
        };
        Glide.with(imageView.getContext()).load(url).asBitmap().placeholder(R.mipmap.ic_loading).into(target);


    }
}
