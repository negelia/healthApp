package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cerdo extends AppCompatActivity {

    EditText dad, chss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerdo);
        dad = (EditText) findViewById(R.id.height);
        chss = (EditText) findViewById(R.id.weight);
    }

    public void viewClick(View view) {
        String result = "";

        String dadValue = dad.getText().toString();
        String chssValue = chss.getText().toString();

        if (
                dadValue.startsWith(".") || chssValue.startsWith(".")
                        || dadValue.startsWith(",") || chssValue.startsWith(",")
                        || dadValue.startsWith("-") || chssValue.startsWith("-")
                        || dadValue.startsWith("_")|| chssValue.startsWith("_")
                        || dadValue.matches("")|| chssValue.matches("")
                        || dadValue.contains(",")|| chssValue.contains(",")
                        || dadValue.contains("-")|| chssValue.contains("-")
                        || dadValue.contains(" ")|| chssValue.contains(" ")
                        || dadValue.contains(".")|| chssValue.contains(".")
        )
        {
            Toast toast = Toast.makeText(this, "Проверьте правильности ввода данных!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            if (dadValue != null && chssValue != null){
                int cerdo = 100 * (1 - (Integer.parseInt(dadValue))/(Integer.parseInt(chssValue)));

                if (31 <= cerdo)
                    result = "Выраженная симпатикотония";
                else if (16 <= cerdo && cerdo <= 30)
                    result = "Симпатикотония";
                else if (-15 <= cerdo && cerdo <= 15)
                    result = "Норма";
                else if (-16 <= cerdo && cerdo <= 30)
                    result = "Парасимпатикотония";
                else if (cerdo <= -30)
                    result = "Выраженная парасимпатикотония";
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(Cerdo.this);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("test7", result);
                editor.apply();
            }

            Intent intent = new Intent(Cerdo.this, Result6.class);
            startActivity(intent);
        }
    }
}