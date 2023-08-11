package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LifeIndex extends AppCompatActivity {
    EditText zhel, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_index);
        zhel = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
    }

    public void viewClick(View view) {
        float Lifeindex = 0;

        String zhelValue = zhel.getText().toString();
        String weightValue = weight.getText().toString();

        if (
                zhelValue.startsWith(".") || weightValue.startsWith(".")
                        || zhelValue.startsWith(",") || weightValue.startsWith(",")
                        || zhelValue.startsWith("-") || weightValue.startsWith("-")
                        || zhelValue.startsWith("_")|| weightValue.startsWith("_")
                        || zhelValue.matches("")|| weightValue.matches("")
                        || zhelValue.contains(",")|| weightValue.contains(",")
                        || zhelValue.contains("-")|| weightValue.contains("-")
                        || zhelValue.contains(" ")|| weightValue.contains(" ")
                        || zhelValue.contains(".")|| weightValue.contains(".")
        )
        {
            Toast toast = Toast.makeText(this, "Проверьте правильности ввода данных!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            if (zhelValue != null && weightValue != null){
                Lifeindex = Float.parseFloat(zhelValue)/Float.parseFloat(weightValue);
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(LifeIndex.this);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("test5", String.valueOf(Lifeindex));
                editor.apply();
            }

            Intent intent = new Intent(LifeIndex.this, Result4.class);
            startActivity(intent);
        }
    }
}