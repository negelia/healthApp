package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Heart extends AppCompatActivity {

    EditText chss, sad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);
        chss = (EditText) findViewById(R.id.height);
        sad = (EditText) findViewById(R.id.weight);
    }

    public void viewClick(View view) {
        String result = "";

        String chssValue = chss.getText().toString();
        String sadValue = sad.getText().toString();

        if (
                sadValue.startsWith(".") || chssValue.startsWith(".")
                        || sadValue.startsWith(",") || chssValue.startsWith(",")
                        || sadValue.startsWith("-") || chssValue.startsWith("-")
                        || sadValue.startsWith("_")|| chssValue.startsWith("_")
                        || sadValue.matches("")|| chssValue.matches("")
                        || sadValue.contains(",")|| chssValue.contains(",")
                        || sadValue.contains("-")|| chssValue.contains("-")
                        || sadValue.contains(" ")|| chssValue.contains(" ")
                        || sadValue.contains(".")|| chssValue.contains(".")
        )
        {
            Toast toast = Toast.makeText(this, "Проверьте правильности ввода данных!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            if (chssValue != null && sadValue != null){
                float Heartlevel = (Float.parseFloat(chssValue)*Float.parseFloat(sadValue))/100;

                if (74 >= Heartlevel)
                    result = "Высокий уровень регуляции";
                else if (75 <= Heartlevel && Heartlevel <= 80)
                    result = "Выше среднего";
                else if (81 <= Heartlevel && Heartlevel <= 90)
                    result = "Норма";
                else if (91 <= Heartlevel && Heartlevel <= 100)
                    result = "Ниже среднего";
                else if (100 <= Heartlevel)
                    result = "Низкое значение регуляции";
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(Heart.this);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("test4", result);
                editor.apply();
            }

            Intent intent = new Intent(Heart.this, Result3.class);
            startActivity(intent);
        }
    }
}