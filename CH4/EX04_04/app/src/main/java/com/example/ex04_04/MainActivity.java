package com.example.ex04_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView textView1;
    public TextView textView2;
    public CheckBox checkBox;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        checkBox = findViewById(R.id.checkBox);
        button = findViewById(R.id.button);
        checkBox.setChecked(false);
        button.setEnabled(false);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    button.setEnabled(true);
                    textView2.setText("");
                } else {
                    button.setEnabled(false);
                    textView1.setText(R.string.text1);
                    textView2.setText(R.string.no);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    textView2.setText(R.string.ok);
                }
            }
        });
    }
}