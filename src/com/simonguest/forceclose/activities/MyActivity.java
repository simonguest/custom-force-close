package com.simonguest.forceclose.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.simonguest.forceclose.handler.CustomExceptionActivity;
import com.simonguest.forceclose.R;

public class MyActivity extends CustomExceptionActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button selfDestructButton = (Button)findViewById(R.id.button);
        selfDestructButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int y = 5/0;
            }
        });
    }
}
