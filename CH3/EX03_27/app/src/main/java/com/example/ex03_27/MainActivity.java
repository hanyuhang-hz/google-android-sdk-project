package com.example.ex03_27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ViewFlipper;


public class MainActivity extends AppCompatActivity {

    private ViewFlipper myViewFilpper;
    private float oldTouchValue;
    private ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        myViewFilpper = findViewById(R.id.myViewFlipper);

        // myImageView1设置动画效果
        myImageView = findViewById(R.id.myImageView1);
        Animation animation = new TranslateAnimation(10,200,10,400);
        animation.setDuration(2000);
        animation.setRepeatCount(-1);
        myImageView.setAnimation(animation);
        animation.startNow();
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                oldTouchValue = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentValue = event.getX();
                if (oldTouchValue < currentValue) {                 // 手指向右滑动,动画从左向右
                    myViewFilpper.setInAnimation(AnimationHelper.inFromLeftAnimation());
                    myViewFilpper.setOutAnimation(AnimationHelper.outToRightAnimation());
                    myViewFilpper.showNext();
                } else if (oldTouchValue > currentValue) {          // 手指向左滑动，动画从右向左
                    myViewFilpper.setInAnimation(AnimationHelper.inFromRightAnimation());
                    myViewFilpper.setOutAnimation(AnimationHelper.outToLeftAnimation());
                    myViewFilpper.showPrevious();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(event);
    }
}