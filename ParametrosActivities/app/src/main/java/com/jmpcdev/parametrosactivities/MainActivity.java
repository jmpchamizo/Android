package com.jmpcdev.parametrosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txvName, txvSurname, txvBirthdate;
    EditText edtName, edtSurname, edtBirthdate;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvName = (TextView) findViewById(R.id.txvName);
        txvSurname = (TextView) findViewById(R.id.txvSurname);
        txvBirthdate = (TextView) findViewById(R.id.txvBirthdate);
        edtName = (EditText) findViewById(R.id.edtName);
        edtSurname = (EditText) findViewById(R.id.edtSurname);
        edtBirthdate = (EditText) findViewById(R.id.edtBirthDate);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ventana2.class);
                i.putExtra("name", edtName.getText().toString());
                i.putExtra("surname", edtSurname.getText().toString());
                i.putExtra("birthdate", edtBirthdate.getText().toString());
                startActivity(i);
            }
        });

    }
}
