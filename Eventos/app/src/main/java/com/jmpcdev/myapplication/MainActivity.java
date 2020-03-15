package com.jmpcdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2, resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edt1 = (EditText) findViewById((R.id.edt1));
        this.edt2 = (EditText) findViewById((R.id.edt2));
        this.resultado = (EditText) findViewById((R.id.edt3));
    }


    public void sumar(View view){
        int num1 = Integer.parseInt(this.edt1.getText().toString());
        int num2 = Integer.parseInt(this.edt2.getText().toString());
        int suma = num1 + num2;
        this.resultado.setText(Integer.toString(suma));
    }




}
