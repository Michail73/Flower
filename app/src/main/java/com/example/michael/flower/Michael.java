package com.example.michael.flower;

import android.app.Application;

/**
 * Created by Michael on 08.12.2016.
 */

public class Michael extends Application {

    public static Michael INSTANCE;
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
