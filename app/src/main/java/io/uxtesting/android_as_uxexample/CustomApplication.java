package io.uxtesting.android_as_uxexample;

import android.app.Application;

import io.uxtesting.UXTesting;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        UXTesting.Init(this, "MY_APP_KEY");
    }

}
