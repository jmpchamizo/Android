package com.jmpcdev.parametrolistaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText edts[] = new EditText[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edts[0] = findViewById(R.id.edt1);
        edts[1] = findViewById(R.id.edt2);
        edts[2] = findViewById(R.id.edt3);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ventana2.class);
                i.putStringArrayListExtra("clientes", getData());
                startActivity(i);
            }
        });

    }

    private ArrayList<String> getData(){
        ArrayList<String> result = new ArrayList<>();
        for (EditText edt : edts){
            result.add(edt.getText().toString());
        }
        return result;
    }


}
