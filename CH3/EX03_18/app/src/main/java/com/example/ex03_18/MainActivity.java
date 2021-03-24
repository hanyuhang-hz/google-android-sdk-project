package com.example.ex03_18;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    public ProgressDialog mDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence dialogTitle = getString(R.string.str_dialog_title);
                final CharSequence dialogBody = getString(R.string.str_dialog_body);
                mDialog = ProgressDialog.show(MainActivity.this, dialogTitle,dialogBody,true);
                new Thread() {
                    public void run() {
                        try {
                            sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            mDialog.dismiss();
                        }
                    }
                }.start();
            }
        });
    }
}