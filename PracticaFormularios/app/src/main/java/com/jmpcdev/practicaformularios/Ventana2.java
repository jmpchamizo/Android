package com.jmpcdev.practicaformularios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Ventana2 extends AppCompatActivity {

    private TextView txvData;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);

        txvData = findViewById(R.id.txvData);
        txvData.setText(getData());
        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String getData(){
        ArrayList<String> courses = getIntent().getStringArrayListExtra("courses");
        String result = "";

        result += getResources().getString(R.string.schedule) + " " + getIntent().getExtras().getString("schedule") + " \n";
        if (courses.size() > 0){
            result += getResources().getString(R.string.course) + " ";
            for (String course : courses){
                result += course + ", ";
            }
        }

        return result.substring(0, result.length()-2);
    }
}
