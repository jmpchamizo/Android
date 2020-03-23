package com.jmpcdev.menudieta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spn;
    private Button btn;
    private TextView txvMenu;
    private CheckBox chbs[] = new CheckBox[3];
    private String[] menu = {"", "", ""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chbs[0] = (CheckBox) findViewById(R.id.chb1);
        chbs[1] = (CheckBox) findViewById(R.id.chb2);
        chbs[2] = (CheckBox) findViewById(R.id.chb3);
        setListenersChbs();
        txvMenu = (TextView) findViewById(R.id.txvMenu);
        spn = (Spinner) findViewById(R.id.spn);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.options));
        spn.setAdapter(adapter);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Cambiamos el texto de los checkbox en función de la comida elegida
                setCheckboxText(getArrayFood(position));
                //Forzamos a que ningún checkbox este marcado cuando cambiamos a otra comida
                initializeCheckbox(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvMenu.setText(getMenu());
            }
        });

    }


    private void setListenersChbs(){
        for (int i = 0; i < chbs.length; i++){
            final int pos = i;
            chbs[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //Cambiamos la checkbox checked
                    changeCheckedCheckbox(pos, isChecked);
                    //Almacenamos el menu en el array de menus
                    saveMenu();
                }
            });
        }
    }


    private void setCheckboxText(String[] foods){
        for (int i = 0; i < chbs.length; i++){
            chbs[i].setText(foods[i]);
        }
    }


    private void changeCheckedCheckbox(int id, boolean isChecked){
        int count = 0;
        for (CheckBox chb : chbs){
            if(isChecked){
                chb.setChecked(false);
            } else {
                chb.setChecked(chb.isChecked());
            }
            if (count == id){
                chb.setChecked(isChecked);
            }
            count++;
        }
    }

    private void initializeCheckbox(int position){
        String m = menu[position];
        if (m == ""){
            changeCheckedCheckbox(-1, true);
        } else {
            changeCheckedCheckbox(Integer.parseInt(m.substring(m.length()-1)), true);
        }
    }


    private void saveMenu(){
        for (int i = 0; i < chbs.length; i++){
            if (chbs[i].isChecked()){
                menu[spn.getSelectedItemPosition()] = spn.getSelectedItem().toString() + ": " + chbs[i].getText().toString() + i;
                return;
            }
        }
        menu[spn.getSelectedItemPosition()] = "";
    }


    private String[] getArrayFood(int position){
        switch (position) {
            case 0:
                return getResources().getStringArray(R.array.breakfast);
            case 1:
                return getResources().getStringArray(R.array.lunch);
            case 2:
                return getResources().getStringArray(R.array.dinner);
            default:
                return null;
        }
    }

    private String getMenu(){
        String result = "";
        for (String m : menu){
            if(m != ""){
                result += m.substring(0, m.length()-1) + "\n";
            }
        }
        return result;
    }
}
