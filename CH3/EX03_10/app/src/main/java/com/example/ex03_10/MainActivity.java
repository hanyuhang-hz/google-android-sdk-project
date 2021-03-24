package com.example.ex03_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = findViewById(R.id.height);
                double height = 0.0;
                if (et.getText().toString().equals("")) {
                    Log.d("test", "str empty!");
                } else {
                    height = Double.parseDouble(et.getText().toString());
                }
                String sex;
                RadioButton rb_female = findViewById(R.id.sex_female);
                if(rb_female.isChecked()) {
                    sex = "F";
                } else {
                    sex = "M";
                }
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, OtherActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("height", height);
                bundle.putString("sex", sex);
                // putExtras!
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}