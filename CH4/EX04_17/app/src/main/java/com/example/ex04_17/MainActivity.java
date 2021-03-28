package com.example.ex04_17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private ProgressBar progressBar;
    public int intCount = 0;
    protected static final int GUI_STOP_NOTIFIER = 0x108;
    protected static final int GUI_THREADING_NOTIFIER = 0x109;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setMax(100);
                progressBar.setProgress(0);
                intCount = 0;
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                for(int i=0;i<10;i++) {
                                    try {
                                        intCount = (i+1)*20;
                                        Log.d("test", "1:" + intCount);
                                        Thread.sleep(1000);
                                        if(i==4) {
                                            Message m = new Message();
                                            m.what = MainActivity.GUI_STOP_NOTIFIER;
                                            MainActivity.this.handler.sendMessage(m);
                                            break;
                                        } else {
                                            Message m = new Message();
                                            m.what = MainActivity.GUI_THREADING_NOTIFIER;
                                            MainActivity.this.handler.sendMessage(m);
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                ).start();
            }
        });
    }
    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what) {
                case MainActivity.GUI_STOP_NOTIFIER:
                    textView.setText(R.string.str_progress_done);
                    progressBar.setVisibility(View.GONE);
                    //Thread.currentThread().interrupt();         //线程终止
                    break;
                case MainActivity.GUI_THREADING_NOTIFIER:
                    progressBar.setIndeterminate(false);
                    Log.d("test", "3:" + intCount);
                    if(!Thread.currentThread().isInterrupted()) {
                        Log.d("test", "2:" + intCount);
                        progressBar.setProgress(intCount);      //没有设置下去?
                        //textView.setText("Progress:" + progressBar.getProgress());
                        textView.setText("Progress:" + intCount);
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    };
}