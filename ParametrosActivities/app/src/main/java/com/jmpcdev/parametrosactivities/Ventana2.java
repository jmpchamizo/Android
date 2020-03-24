package com.jmpcdev.parametrosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ventana2 extends AppCompatActivity {

    private TextView txv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);

        txv = (TextView) findViewById(R.id.txvData);
        fillData();
        btn = (Button) findViewById(R.id.btnClose);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void fillData(){
        String result = "";
        Bundle bundle = getIntent().getExtras();
        result += "Nombre: " + bundle.getString("name") + "\n";
        result += "Apellidos: " + bundle.getString("surname") + "\n";
        result += "Fecha de Nacimiento: " + bundle.getString("birthdate") + "\n";
        txv.setText(result);
    }


}
