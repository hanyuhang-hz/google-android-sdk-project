package com.example.ex04_21;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private List<String> items = null;
    private List<String> paths = null;
    private String rootPath = "/sdcard";
    private TextView mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPath = findViewById(R.id.mPath);
        getFileDir(rootPath);
    }

    private void getFileDir(String filePath) {
        mPath.setText(filePath);

        items = new ArrayList<>();
        paths = new ArrayList<>();
        File f = new File(filePath);
        File[] files = f.listFiles();       //files返回null，可能没权限

        if(!filePath.equals(rootPath)) {
            items.add("Back to " + rootPath);
            paths.add(rootPath);
            items.add("Back to ../");
            paths.add(f.getParent());
        }
        if (files != null) {
            for(int i=0;i<files.length;i++) {
                File file = files[i];
                items.add(file.getName());
                paths.add(file.getPath());
            }
        }

        ArrayAdapter<String> fileList = new ArrayAdapter<>(this, R.layout.file_row, items);
        setListAdapter(fileList);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        File file = new File(paths.get(position));
        if(file.canRead()) {
            if(file.isDirectory()) {
                getFileDir(paths.get(position));
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Message")
                        .setMessage("[" + file.getName() + "] is File!")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Message")
                    .setMessage("权限不足!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
        }
    }
}