package com.example.ex03_14;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fontButton = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);

        fontButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/HandmadeTypewriter.ttf"));
            }
        });
    }
}