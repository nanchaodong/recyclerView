package com.wolf.recyclerview.utils;

import android.databinding.BindingAdapter;
import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
}
