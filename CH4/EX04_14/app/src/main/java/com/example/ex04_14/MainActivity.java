package com.example.ex04_14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.AnalogClock;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    protected static final int GUINOTIFIER = 0x1234;

    private TextView textView;
    private AnalogClock analogClock;

    public Calendar calendar;
    public int minutes;
    public int hour;

    public Handler handler;
    private Thread clockThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        analogClock = findViewById(R.id.myAnalogClock);

        handler = new Handler() {
            @SuppressLint("HandlerLeak")
            public void handleMessage(Message msg) {
                Log.d("test", msg+"");
                switch (msg.what) {
                    case MainActivity.GUINOTIFIER:
                        textView.setText(hour + " : " + minutes);
                        break;
                }
                super.handleMessage(msg);
            }
        };

        clockThread = new LooperThread();
        clockThread.start();
    }

    class LooperThread extends Thread {
        public void run() {
            super.run();
            try {
                do {
                    long time = System.currentTimeMillis();
                    calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(time);
                    hour = calendar.get(Calendar.HOUR);
                    minutes = calendar.get(Calendar.MINUTE);
                    Thread.sleep(2000);
                    Message m = new Message();
                    m.what = MainActivity.GUINOTIFIER;
                    MainActivity.this.handler.sendMessage(m);
                } while (MainActivity.LooperThread.interrupted()==false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

