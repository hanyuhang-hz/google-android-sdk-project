package com.example.ex03_22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editTextTextPassword2);
        mCheckBox = findViewById(R.id.checkBox);

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mCheckBox.isChecked()) {
                    mEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}