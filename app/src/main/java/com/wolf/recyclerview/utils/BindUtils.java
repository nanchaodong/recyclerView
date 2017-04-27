package com.wolf.recyclerview.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.squareup.picasso.Picasso;
import com.wolf.recyclerview.R;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public class BindUtils {

    @BindingAdapter("imageUrl")
    public static void showImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_loading).into(imageView);
    }

    @BindingAdapter("imageId")
    public static void showImage(ImageView imageView, int drawableId) {
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
    public static void gradle(TextView textView, String gradle) {
        textView.setText(gradle + "学分");
    }

    @BindingAdapter("reg_cc")
    public static void commit(TextView textView, String reg_cc) {
        textView.setText(reg_cc + "已报名");

    }

    @BindingAdapter("weiboUrl")
    public static void showWeiboUrl(final ImageView imageView, final String url) {
        Glide.with(imageView.getContext()).load(url).asBitmap().placeholder(R.mipmap.ic_loading).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                int imageWidth = resource.getWidth();
                int imageHeight = resource.getHeight();
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = imageWidth;
                layoutParams.height = imageHeight;
                imageView.setLayoutParams(layoutParams);
                Glide.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_loading).into(imageView);

            }
        });

        Picasso.with(imageView.getContext()).load(url).into(imageView);

    }

    @BindingAdapter("weiboArticlePicUrl")
    public static void showWeiboArticlePicture(ImageView imageView, String url) {
        Context context = imageView.getContext();
        int screenDistance = ScreenUtils.getScreenWidth(context);
        int recyWidth = screenDistance - 2 * context.getResources().getDimensionPixelSize(R.dimen.d10);
        int recyWithOutPadding = recyWidth - 2 * context.getResources().getDimensionPixelSize(R.dimen.d5);
        int imageDistance = recyWithOutPadding / 3;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = imageDistance;
        layoutParams.height = imageDistance;
        imageView.setLayoutParams(layoutParams);
        Picasso.with(imageView.getContext()).load(url).placeholder(R.mipmap.ic_loading).into(imageView);


    }

    @BindingAdapter("shape")
    public static void setwidthAndHeight(View view, String param) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        Context context = relativeLayout.getContext();
        int screenDistance = ScreenUtils.getScreenWidth(context);
        int recyWidth = screenDistance - 2 * context.getResources().getDimensionPixelSize(R.dimen.d10);
        int recyWithOutPadding = recyWidth - 2 * context.getResources().getDimensionPixelSize(R.dimen.d5);
        int imageDistance = recyWithOutPadding / 3;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.width = imageDistance;
        layoutParams.height = imageDistance;
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackgroundResource(R.drawable.common_weibo_article_pic_selector);

    }

    @BindingAdapter("zan")
    public static void showZan(ImageView imageView, boolean flag) {
        imageView.setImageResource(flag ? R.mipmap.zan_selected : R.mipmap.zan);
    }
}
