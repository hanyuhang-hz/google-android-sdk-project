package com.example.ex04_22;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends Activity {

    private ImageView imageView;
    private Button button;
    private TextView textView;
    private String fileName = "/sdcard/DCIM/sdk.PNG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView = findViewById(R.id.imageView);
                textView = findViewById(R.id.textView);
                File f = new File(fileName);
                if(f.exists()) {
                    Bitmap bitmap = BitmapFactory.decodeFile(fileName);
                    imageView.setImageBitmap(bitmap);       //显示不出来
                    textView.setText(fileName);
                } else {
                    textView.setText("文件不存在");
                }
            }
        });
    }
}