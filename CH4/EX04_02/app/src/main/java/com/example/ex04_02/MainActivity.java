package com.example.ex04_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        // 无效
        imageButton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d("test",hasFocus + "");
                if (hasFocus == true) {
                    textView.setText("ImageButton 状态:Got Focus!");
                    imageButton.setImageResource(R.drawable.iconfull);
                } else {
                    textView.setText("ImageButton 状态:Lost Focus!");
                    imageButton.setImageResource(R.drawable.iconempty);
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("ImageButton 状态:Got Click!");
                imageButton.setImageResource(R.drawable.iconfull);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Button 状态:Lost Click!");
                imageButton.setImageResource(R.drawable.iconempty);
            }
        });
    }
}