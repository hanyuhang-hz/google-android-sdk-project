package com.example.ex03_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = 0.0;
                EditText et = findViewById(R.id.height);
                if (et.getText().toString().equals("")) {
                    Log.d("test", "str empty!");
                } else if (isNumeric(et.getText().toString())){
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

                //requestCode:0
                startActivityForResult(intent, 0);
            }
        });
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("test","requestCode:" + requestCode + " resultCode:" + resultCode + " data:" + data);
        switch (resultCode) {
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                String sex = bundle.getString("sex");
                double height = bundle.getDouble("height");
                EditText et = findViewById(R.id.height);
                et.setText("height:" + height);
                break;
        }
    }
}