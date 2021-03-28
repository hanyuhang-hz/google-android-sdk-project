package com.example.ex04_32;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
    private EditText ed;
    private Button button1;
    private InputConnection conn;
    private int choiceIndex=0;
    private String[] items=new String[]{"any","and","ant","animation","android",
            "bus","buy","bullet","bull","busy"};

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*对象初始化*/
        ed=(EditText)findViewById(R.id.editText01);
        button1=(Button)findViewById(R.id.button01);
        /*取得InputConnection*/
        conn=ed.onCreateInputConnection(new EditorInfo());

        /*启动文字联想*/
        button1.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*判断是否有选取文字*/
                if(conn.getSelectedText(0)!=null)
                {
                    /*取得选取的文字*/
                    String choiceWord=conn.getSelectedText(0).toString();
                    /*选取的文字加上底线*/
                    conn.setComposingRegion(ed.getSelectionStart(),ed.getSelectionEnd());
                    /*比对字符串内容，取出联想出的文字*/
                    List<String> li=new ArrayList<String>();
                    for(int i=0;i<items.length;i++)
                    {
                        if(items[i].indexOf(choiceWord)!=-1)
                        {
                            li.add(items[i]);
                        }
                    }

                    if(li.size()==0){
                        /*跳出无联想文字的提示*/
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("文字联想")
                                .setMessage("没有可以提示的文字!")
                                .setNeutralButton("OK", null)
                                .show();
                    }else{
                        /*选项归零*/
                        choiceIndex=0;
                        /*将List转为String[]*/
                        final String[] tmpS=new String[li.size()];
                        li.toArray(tmpS);
                        /*跳出联想文字供选择*/
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("文字联想")
                                .setSingleChoiceItems(tmpS,0,new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int whichButton)
                                    {
                                        choiceIndex=whichButton;
                                    }
                                })
                                .setPositiveButton("确认",new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        /*将选取的文字取代为联想文字*/
                                        conn.setComposingText(tmpS[choiceIndex],1);
                                        /*将底线取消*/
                                        conn.finishComposingText();
                                    }
                                })
                                .setNegativeButton("取消",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        /*取消文字的选取*/
                                        conn.finishComposingText();
                                        ed.setSelection(0,0);
                                    }
                                })
                                .show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"您未选取文字!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}