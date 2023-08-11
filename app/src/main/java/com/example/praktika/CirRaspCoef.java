package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CirRaspCoef extends AppCompatActivity {

    EditText psh, chss, zhel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cir_rasp_coef);
        psh = (EditText) findViewById(R.id.height);
        chss = (EditText) findViewById(R.id.weight);
        zhel = (EditText) findViewById(R.id.weight);
    }

    public void viewClick(View view) {
        String result = "";

        String pshValue = psh.getText().toString();
        String chssValue = chss.getText().toString();
        String zhelValue = zhel.getText().toString();

        if (
                pshValue.startsWith(".") || chssValue.startsWith(".") || zhelValue.startsWith(".")
                        || pshValue.startsWith(",") || chssValue.startsWith(",") || zhelValue.startsWith(".")
                        || pshValue.startsWith("-") || chssValue.startsWith("-") || zhelValue.startsWith(".")
                        || pshValue.startsWith("_")|| chssValue.startsWith("_") || zhelValue.startsWith(".")
                        || pshValue.matches("")|| chssValue.matches("") || zhelValue.startsWith(".")
                        || pshValue.contains(",")|| chssValue.contains(",") || zhelValue.startsWith(".")
                        || pshValue.contains("-")|| chssValue.contains("-") || zhelValue.startsWith(".")
                        || pshValue.contains(" ")|| chssValue.contains(" ") || zhelValue.startsWith(".")
                        || pshValue.contains(".")|| chssValue.contains(".") || zhelValue.contains(".")
        )
        {
            Toast toast = Toast.makeText(this, "Проверьте правильности ввода данных!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            if (pshValue != null && chssValue != null && zhelValue != null){
                float coef = ((Float.parseFloat(zhelValue)/100)*Float.parseFloat(pshValue))/Float.parseFloat(chssValue);

                if (5 > coef)
                    result = "Низкий уровень";
                else if (5 <= coef && coef <= 10)
                    result = "Неудовлетворительно";
                else if (10 <= coef && coef <= 30)
                    result = "Удовлетворительно";
                else if (30 <= coef && coef <= 60)
                    result = "Хорошо";
                else if (60 <= coef)
                    result = "Очень хорошо";
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(CirRaspCoef.this);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("test6", result);
                editor.apply();
            }

            Intent intent = new Intent(CirRaspCoef.this, Result5.class);
            startActivity(intent);
        }
    }
}