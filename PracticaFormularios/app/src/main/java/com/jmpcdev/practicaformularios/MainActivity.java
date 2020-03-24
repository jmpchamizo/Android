package com.jmpcdev.practicaformularios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CheckBox chbs[] = new CheckBox[3];
    private RadioButton rdbs[] = new RadioButton[3];
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chbs[0] = findViewById(R.id.chbJava);
        chbs[1] = findViewById(R.id.chbJavaScript);
        chbs[2] = findViewById(R.id.chbPython);
        rdbs[0] = findViewById(R.id.rdbMorning);
        rdbs[1] = findViewById(R.id.rdbAfternoon);
        rdbs[2] = findViewById(R.id.rdbIndifferent);
        rdbs[2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                disabledCheckBoxes(isChecked);
                uncheckCheckBoxes();
            }
        });
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ventana2.class);
                i.putStringArrayListExtra("courses", getCourses());
                i.putExtra("schedule", getSchedule());
                startActivity(i);
            }
        });
    }

    private void disabledCheckBoxes(boolean isChecked){
        for (CheckBox chb : chbs){
            chb.setEnabled(!isChecked);
        }
    }

    private void uncheckCheckBoxes(){
        for (CheckBox chb : chbs){
            chb.setChecked(false);
        }
    }


    private ArrayList<String> getCourses(){
        ArrayList<String> result = new ArrayList();
        for (CheckBox chb : chbs){
            if (chb.isChecked()){
                result.add(chb.getText().toString());
            }
        }
        return result;
    }

    private String getSchedule(){
        for (RadioButton rdb : rdbs){
            if (rdb.isChecked()){
                return rdb.getText().toString();
            }
        }
        return null;
    }
}
