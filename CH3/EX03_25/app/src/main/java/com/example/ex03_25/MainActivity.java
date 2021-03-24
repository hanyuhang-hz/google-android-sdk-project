package com.example.ex03_25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    public static final int requestCode1 = 0x1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClassName("com.example.ex03_25_b", "com.example.ex03_25_b.MainActivity");
                    Bundle bundle = new Bundle();
                    bundle.putString("STR_INPUT", " Hi, I'm from ex03_25");
                    intent.putExtras(bundle);
                    startActivityForResult(intent, requestCode1);
                } catch (Exception e) {
                    e.printStackTrace();
                    textView.setText("请先安装ex03_25_b!!!");
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return ;
        }

        switch (requestCode) {
            case requestCode1:
                String contents = data.getStringExtra("EX03_25_B_Back");
                textView.setText("From EX03_25_B: " + contents);
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}