package com.example.ex03_11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);

        Intent intent = this.getIntent();
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

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherActivity.this.setResult(RESULT_OK, intent);
                OtherActivity.this.finish();
            }
        });
    }
}