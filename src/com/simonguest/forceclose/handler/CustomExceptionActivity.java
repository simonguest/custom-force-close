package com.simonguest.forceclose.handler;

import android.app.Activity;
import android.os.Bundle;

public class CustomExceptionActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new CustomException(this));
    }
}
