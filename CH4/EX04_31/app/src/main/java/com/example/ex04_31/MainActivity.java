package com.example.ex04_31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static boolean bIfDebug = false;
    public static String TAG = "HIPPO_DEBUG";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)      //触碰屏幕一次，回调了两次!!!
    {
        // TODO Auto-generated method stub
        InputDevice inputDevice = event.getDevice();

        //http://developer.android.com/reference/android/view/KeyCharacterMap.html
        //Returns NUMERIC, PREDICTIVE or ALPHA.
        switch(inputDevice.getKeyboardType())
        {
            case KeyCharacterMap.ALPHA:
                Log.i(TAG, "getKeyboardType:KeyCharacterMap.ALPHA");
                Toast.makeText(MainActivity.this, "getKeyboardType:KeyCharacterMap.ALPHA",Toast.LENGTH_SHORT).show();
                break;
            case KeyCharacterMap.PREDICTIVE:
                Log.i(TAG, "getKeyboardType:KeyCharacterMap.PREDICTIVE");
                Toast.makeText(MainActivity.this, "getKeyboardType:KeyCharacterMap.PREDICTIVE",Toast.LENGTH_SHORT).show();
                break;
            case KeyCharacterMap.NUMERIC:
                Log.i(TAG, "getKeyboardType:KeyCharacterMap.NUMERIC");
                Toast.makeText(MainActivity.this, "getKeyboardType:KeyCharacterMap.NUMERIC",Toast.LENGTH_SHORT).show();
                break;
        }

        int deviceId = event.getDeviceId();
        int source = event.getSource();

        Log.i(TAG, "Input Device Name: "+inputDevice.getName());
        Log.i(TAG, "Input Device ID: " + deviceId);
        Log.i(TAG, "Source of the event: " + source);
        Log.i(TAG, "X:" + event.getX() + ",Y:" + event.getY());

        String strToast = "Input Device Name: " + inputDevice.getName() + "\n";
        strToast +=  "Input Device ID: " + deviceId + "\n";
        strToast += "Source of the event: " + source + "\n";
        strToast += "X:" + event.getX() + ",Y:" + event.getY();
        Toast.makeText(MainActivity.this, strToast,Toast.LENGTH_LONG).show();

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // TODO Auto-generated method stub
        InputDevice inputDevice = event.getDevice();

        int deviceId = event.getDeviceId();
        int source = event.getSource();
        Log.i(TAG, "Input Device Name: "+inputDevice.getName());
        Log.i(TAG, "Input Device ID: " + deviceId);
        Log.i(TAG, "Source of the event: " + source);
        Log.i(TAG, "Key:" + event.getKeyCode());

        Toast.makeText(MainActivity.this, "Input Device Name: "+inputDevice.getName(),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "Input Device ID: " + deviceId,Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "Source of the event: " + source,Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "Key:" + event.getKeyCode(),Toast.LENGTH_SHORT).show();

        return super.onKeyDown(keyCode, event);
    }

    public void exitActivity(int exitMethod)
    {
        //throw new RuntimeException("Exit!");
        try
        {
            switch(exitMethod)
            {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    android.os.Process.killProcess(android.os.Process.myPid());
                    break;
                case 2:
                    finish();
                    break;
            }
        }
        catch(Exception e)
        {
            if(bIfDebug)
            {
                Log.e(TAG, e.toString());
                e.printStackTrace();
            }
            finish();
        }
    }

    @Override
    protected void onPause()
    {
        // TODO Auto-generated method stub
        exitActivity(1);
        super.onPause();
    }
}