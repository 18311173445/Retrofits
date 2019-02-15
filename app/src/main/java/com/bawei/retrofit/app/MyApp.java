package com.bawei.retrofit.app;

import android.app.Application;

import com.bawei.retrofit.utils.GreenUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        GreenUtils.getInstance().initGreen(this);
    }
}
