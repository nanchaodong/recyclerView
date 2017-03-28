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
    @BindingAdapter("imageId")
    public static void showImage(ImageView imageView,int drawableId){
        Glide.with(imageView.getContext()).load(drawableId).placeholder(R.mipmap.ic_loading).into(imageView);
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

    @BindingAdapter("gradle")
    public static void gradle(TextView textView, String gradle){
        textView.setText(gradle + "学分");
    }
    @BindingAdapter("reg_cc")
    public static void commit(TextView textView, String reg_cc){
        textView.setText(reg_cc + "已报名");

    }
}
