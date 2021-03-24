package com.example.ex03_10;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);

        Bundle bundle = this.getIntent().getExtras();
        double height = bundle.getDouble("height");
        String sex = bundle.getString("sex");
        String sexText;
        if(sex.equals("F")) {
            sexText = "女";
        } else {
            sexText = "男";
        }
        TextView textView = findViewById(R.id.textView);
        textView.setText("性别:" + sexText + " 身高:" + height);
    }
}