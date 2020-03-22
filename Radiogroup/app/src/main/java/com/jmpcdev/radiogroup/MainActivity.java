package com.jmpcdev.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txvMessage;
    private RadioButton rbtRed, rbtGreen, rbtYellow, rbtBlue;
    private RadioGroup rdgroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbtRed = (RadioButton) findViewById(R.id.rbtRed);
        rbtGreen = (RadioButton) findViewById(R.id.rbtGreen);
        rbtBlue = (RadioButton) findViewById(R.id.rbtBlue);
        rbtYellow = (RadioButton) findViewById(R.id.rbtYellow);
        txvMessage = (TextView) findViewById(R.id.txvMessage);
        rdgroup = (RadioGroup) findViewById(R.id.rdgroup);
        rdgroup.check(R.id.rbtGreen);


        rdgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                showColor(checkedId);
            }
        });

    }

    public void showColor(int checkedId){
        switch (checkedId){
            case R.id.rbtRed:
                txvMessage.setTextColor(Color.RED);
                break;
            case R.id.rbtGreen:
                txvMessage.setTextColor(Color.GREEN);
                break;
            case R.id.rbtBlue:
                txvMessage.setTextColor(Color.BLUE);
                break;
            case R.id.rbtYellow:
                txvMessage.setTextColor(Color.YELLOW);
                break;
        }
    }


}
