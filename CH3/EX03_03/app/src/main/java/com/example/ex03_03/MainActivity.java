package com.example.ex03_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView01;
    private TextView mTextView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView01 = findViewById(R.id.myTextView01);
        mTextView01.setText("应用Drawable后台色");
        Resources resources = getBaseContext().getResources();
        Drawable HippoDrawable = resources.getDrawable(R.color.purple_200);
        mTextView01.setBackgroundDrawable(HippoDrawable);

        mTextView02 = findViewById(R.id.myTextView02);
        mTextView02.setText("文字着色");
        mTextView02.setTextColor(Color.MAGENTA);
    }
}