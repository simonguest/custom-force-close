package com.simonguest.forceclose.handler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.util.Log;
import com.simonguest.forceclose.R;

public class CustomException implements Thread.UncaughtExceptionHandler {
    private Context localContext;

    public CustomException(Context context)
    {
        localContext = context;
    }
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        Log.d("com.simonguest.forceclose", "We can do crazy stuff here!");

        new Thread() {
            @Override
            public void run() {
                Looper.prepare();

                AlertDialog.Builder builder = new AlertDialog.Builder(localContext);
                builder.setTitle("Custom Error Reporting")
                        .setMessage("Here is a nice, friendly message to indicate that something went wrong.")
                        .setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // bye bye
                                System.exit(0);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                Looper.loop();
            }
        }.start();

    }
}
