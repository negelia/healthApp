package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Index extends AppCompatActivity {

    String[] gender = { "Мужской", "Женский"};
    String[] age = { "16-28 лет", "29-34 года", "35-45 лет", "45-55 лет", "больше 55 лет"};
    Button btn;
    public static final String APP_PREFERENCES = "data";
    public static final String APP_PREFERENCES_NAME = "title";

    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Spinner spinner = findViewById(R.id.gender);
        Spinner spinner1 = findViewById(R.id.editTextTextPersonName2);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, gender);
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, age);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
        spinner1.setOnItemSelectedListener(itemSelectedListener);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void viewClick(View view) {
        Intent intent = new Intent(this, BMI.class);
        startActivity(intent);

    }

    public void coefCirkClick(View view) {
        Intent intent = new Intent(this, CirRaspCoef.class);
        startActivity(intent);

    }

    public void lifeindexClick(View view) {
        Intent intent = new Intent(this, LifeIndex.class);
        startActivity(intent);
    }

    public void heartClick(View view) {
        Intent intent = new Intent(this, Heart.class);
        startActivity(intent);
    }

    public void coefClick(View view) {
        Intent intent = new Intent(this, CB.class);
        startActivity(intent);
    }

    public void stepsClick(View view) {
        Intent intent = new Intent(this, StepsCount.class);
        startActivity(intent);
    }

    public void indexClick(View view) {
        Intent intent = new Intent(this, BMI.class);
        startActivity(intent);

        btn = (Button) findViewById(R.id.button3);
        String text = (btn).getText().toString();

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_NAME, text);
        editor.apply();
    }


    public void changeClick(View view) {

        Intent intent = new Intent(this, Functions.class);
        startActivity(intent);
    }

    public void cerdoClick(View view) {
        Intent intent = new Intent(this, Cerdo.class);
        startActivity(intent);
    }

    public void result(View view) {
        Intent intent = new Intent(this, AllTest.class);
        startActivity(intent);
    }

    public void index(View view) {
        Intent intent = new Intent(this, Index.class);
        startActivity(intent);
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}