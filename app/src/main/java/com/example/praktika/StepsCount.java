package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StepsCount extends AppCompatActivity {
    EditText steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_count);

        steps = (EditText) findViewById(R.id.steps);
    }

    public void view1Click(View view) {
        String result = "";

        String count = steps.getText().toString();

        if (
                count.startsWith(".")
                        || count.startsWith(",")
                        || count.startsWith("-")
                        || count.startsWith("_")
                        || count.matches("")
                        || count.contains(",")
                        || count.contains("-")
                        || count.contains(" ")
                        || count.contains(".")
        )
        {
            Toast toast = Toast.makeText(this, "Проверьте правильности ввода данных!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            if (count != null){
                int res = Integer.parseInt(count);

                if (res<5000)
                    result = "Сидячая работа";
                else if (7500 <= res && res <= 9999)
                    result = "Несколько активная работа";
                else if (10000 <= res && res <= 12000)
                    result = "Активный образ жизни";
                else if (12500 <= res)
                    result = "Очень активный образ жизни";
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(StepsCount.this);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("test2", result);
                editor.apply();
            }

            Intent intent = new Intent(StepsCount.this, Result1.class);
            startActivity(intent);
        }
    }
}