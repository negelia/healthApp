package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Functions extends AppCompatActivity {

    EditText chss, sad, dad, weight, height, age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);
        chss = (EditText) findViewById(R.id.height);
        sad = (EditText) findViewById(R.id.height4);
        dad = (EditText) findViewById(R.id.height5);
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height6);
        age = (EditText) findViewById(R.id.height7);

    }

    public void viewClick(View view) {
        float FunctionsIndex = 0;

        String chssValue = chss.getText().toString();
        String sadValue = sad.getText().toString();
        String dadValue = dad.getText().toString();
        String weightValue = weight.getText().toString();
        String heightValue = height.getText().toString();
        String ageValue = age.getText().toString();

        if (
                sadValue.startsWith(".") || chssValue.startsWith(".") || dadValue.startsWith(".") || weightValue.startsWith(".") || heightValue.startsWith(".") || ageValue.startsWith(".")
                        || sadValue.startsWith(",") || chssValue.startsWith(",") || dadValue.startsWith(",") || weightValue.startsWith(",") || heightValue.startsWith(",") || ageValue.startsWith(",")
                        || sadValue.startsWith("-") || chssValue.startsWith("-") || dadValue.startsWith("-") || weightValue.startsWith("-") || heightValue.startsWith("-") || ageValue.startsWith("-")
                        || sadValue.startsWith("_")|| chssValue.startsWith("_") || dadValue.startsWith("_") || weightValue.startsWith("_") || heightValue.startsWith("_") || ageValue.startsWith("_")
                        || sadValue.matches("")|| chssValue.matches("") || dadValue.matches("") || weightValue.matches("") || heightValue.matches("") || ageValue.matches("")
                        || sadValue.contains(",")|| chssValue.contains(",") || dadValue.startsWith(",") || weightValue.startsWith(",") || heightValue.startsWith(",") || ageValue.startsWith(",")
                        || sadValue.contains("-")|| chssValue.contains("-") || dadValue.startsWith("-") || weightValue.startsWith("-") || heightValue.startsWith("-") || ageValue.startsWith("-")
                        || sadValue.contains(" ")|| chssValue.contains(" ") || dadValue.startsWith(" ") || weightValue.startsWith(" ") || heightValue.startsWith(" ") || ageValue.startsWith(" ")
                        || sadValue.contains(".")|| chssValue.contains(".") || dadValue.contains(".") || weightValue.contains(".") || heightValue.contains(".") || ageValue.contains(".")
        )
        {
            Toast toast = Toast.makeText(this, "Проверьте правильности ввода данных!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            if (chssValue != null && sadValue != null && dadValue != null && weightValue != null && heightValue != null && ageValue != null
            && chssValue != sadValue && chssValue != dadValue &&  chssValue != weightValue && chssValue != heightValue && chssValue != ageValue
                    && sadValue != dadValue &&  sadValue != weightValue && sadValue != heightValue && sadValue != ageValue
                    && dadValue != weightValue && dadValue != heightValue && dadValue != ageValue
                    && weightValue != heightValue && weightValue != ageValue
                    && heightValue != ageValue){
                if (Integer.parseInt(ageValue) > 16 && Integer.parseInt(ageValue) < 100){
                    FunctionsIndex = (float) ((0.011*Float.parseFloat(chssValue))
                            +(0.014*Float.parseFloat(sadValue))
                            +(0.008*Float.parseFloat(dadValue))
                            +(0.014*Float.parseFloat(ageValue))
                            +(0.009*Float.parseFloat(weightValue))
                            -(0.009*Float.parseFloat(heightValue))
                            -0.27);
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(Functions.this);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("test8", String.valueOf(FunctionsIndex));
                    editor.apply();

                    Intent intent = new Intent(Functions.this, Result7.class);
                    startActivity(intent);
                }
            }
        }
    }
}