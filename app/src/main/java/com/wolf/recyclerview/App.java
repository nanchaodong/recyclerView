package com.wolf.recyclerview;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by nanchaodong on 2017/3/23.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
