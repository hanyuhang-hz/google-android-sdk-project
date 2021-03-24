package com.example.ex03_17;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, R.string.app_about);
        menu.add(0, 1, 1, R.string.str_exit);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case 0:
                openOptionsDialog();
                break;
            case 1:
                finish();
                break;
        }
        return true;
    }

    private void openOptionsDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_about)
                .setMessage(R.string.app_about_msg)
                .setPositiveButton(R.string.str_ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
    }
}