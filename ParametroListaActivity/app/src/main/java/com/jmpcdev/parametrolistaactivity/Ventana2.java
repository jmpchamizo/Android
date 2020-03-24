package com.jmpcdev.parametrolistaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Ventana2 extends AppCompatActivity {

    private Button btn;
    private TextView txvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);

        txvData = findViewById(R.id.txvData);
        txvData.setText(datasToString(getIntent().getStringArrayListExtra("clientes")));
        btn = findViewById(R.id.btnClose);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private String datasToString(ArrayList<String> datas){
        String result = "";
        for (String data : datas){
            result += data + "\n";
        }
        return result;
    }

}
