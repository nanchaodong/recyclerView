package com.wolf.recyclerview.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.common.net.InetAddresses;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.wolf.recyclerview.activity.WebActivity;
import com.wolf.recyclerview.constant.Constant;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/15.
 */

public class JumperManager {

    public static void showWebActivity(Context context, String url){
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(Constant.INTENT_URL, url);
        context.startActivity(intent);
    }
}
