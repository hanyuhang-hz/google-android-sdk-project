package com.example.ex03_05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        String str = "手机屏幕分辨率为:" + dm.widthPixels + " x " + dm.heightPixels;
        mTextView01 = findViewById(R.id.mTextView01);
        mTextView01.setText(str);
    }
}