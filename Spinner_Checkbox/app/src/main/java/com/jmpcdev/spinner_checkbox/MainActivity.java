package com.jmpcdev.spinner_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox chbText, chbBackground;
    private Spinner spn;
    private TextView txv;
    private CompoundButton.OnCheckedChangeListener chbCheckedChageListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            showFormat();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] options = {"Azul", "Verde"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);

        txv = (TextView) findViewById(R.id.txv);
        chbText = (CheckBox) findViewById(R.id.chbText);
        chbText.setOnCheckedChangeListener(chbCheckedChageListener);
        chbBackground = (CheckBox) findViewById(R.id.chbBackground);
        chbBackground.setOnCheckedChangeListener(chbCheckedChageListener);
        spn = (Spinner) findViewById(R.id.spn);
        spn.setAdapter(adapter);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showFormat();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void showFormat(){
        String spnItem = (String) spn.getSelectedItem();
        if(chbText.isChecked() && spnItem.equals("Azul")){
            txv.setTextColor(Color.BLUE);
        }
        if(chbText.isChecked() && spnItem.equals("Verde")){
            txv.setTextColor(Color.GREEN);
        }
        if(chbBackground.isChecked() && spnItem.equals("Azul")){
            txv.setBackgroundColor(Color.BLUE);
        }
        if(chbBackground.isChecked() && spnItem.equals("Verde")){
            txv.setBackgroundColor(Color.GREEN);
        }
    }
}
