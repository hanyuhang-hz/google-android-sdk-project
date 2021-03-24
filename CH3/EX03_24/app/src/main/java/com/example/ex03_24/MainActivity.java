package com.example.ex03_24;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("test", getApplicationInfo().targetSdkVersion + "");
        if(getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.GINGERBREAD + 30) {
            showNotSupportDialog(getApplicationInfo().targetSdkVersion);
        }
    }

    private void showNotSupportDialog(int version) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("targetSdkVersion is " + version + "! " + this.getString(R.string.err_not_support))
                .setNeutralButton(this.getString(R.string.dlg_exit), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    protected void onPause() {
        exitActivity();
        super.onPause();
    }

    public void exitActivity() {
        try {
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
            finish();
        }
    }
}