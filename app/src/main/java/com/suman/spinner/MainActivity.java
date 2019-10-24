package com.suman.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spincountry, spinplayer;

    private String nepaliplayers[]={"Paras","Sandeep","Sompal"};
    private String indianplayers[]={"Rohit","kohli","Dhoni"};
    private String countries[]={"Nepal","India"};
    private AutoCompleteTextView autoText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spincountry = findViewById(R.id.spinCountry);
        spinplayer= findViewById(R.id.spinPlayers);
        autoText = findViewById(R.id.autoText);



        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,countries);

        spincountry.setAdapter(adapter);

        ArrayAdapter<String> nepArray = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,nepaliplayers);
        autoText.setAdapter(nepArray);
        autoText.setThreshold(1);

        spincountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spincountry.getSelectedItem().toString().equals("India")){
                    ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, indianplayers);

                    spinplayer.setAdapter(arrayAdapter);
                }
                else {

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, nepaliplayers);
                    spinplayer.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
