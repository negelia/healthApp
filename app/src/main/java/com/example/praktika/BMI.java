package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.content.Intent;
import android.widget.Toast;

public class BMI extends AppCompatActivity {

    EditText height, weight;
    Button btn;
    public static final String APP_PREFERENCES = "data";
    public static final String APP_PREFERENCES_RESULT = "result";

    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);

        /*calculate = (Button) findViewById(R.id.button2);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });*/
    }

    public void visibility(){
        //btn = findViewById(R.id.button2);
        btn.setVisibility(View.INVISIBLE);
    }

    public void viewClick(View view) {

        String result = "серёжа самый лучший, ты чё, гонишь тут >:(";

        String heightBMI = height.getText().toString();
        String weightBMI = weight.getText().toString();



        if (
                heightBMI.startsWith(".") || weightBMI.startsWith(".")
        || heightBMI.startsWith(",") || weightBMI.startsWith(",")
        || heightBMI.startsWith("-") || weightBMI.startsWith("-")
                || weightBMI.startsWith("_")|| heightBMI.startsWith("_")
                        || weightBMI.matches("")|| heightBMI.matches("")
                        || weightBMI.contains(",")|| heightBMI.contains(",")
                        || weightBMI.contains("-")|| heightBMI.contains("-")
                        || weightBMI.contains(" ")|| heightBMI.contains(" ")
                        || weightBMI.contains(".")|| heightBMI.contains(".")
        )
        {
            Toast toast = Toast.makeText(this, "Проверьте правильности ввода данных!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
                try {
                    float bmi = Float.parseFloat(weightBMI)/((Float.parseFloat(heightBMI) * Float.parseFloat(heightBMI))/100);

                    if (bmi <= 18.5)
                        result = "Недостаток массы тела";
                    else if (bmi > 18.5 && bmi <= 25)
                        result = "Норма";
                    else if (bmi > 25 && bmi <= 30)
                        result = "Избыточная масса тела";
                    else if (bmi > 30 && bmi <= 35)
                        result = "Первая степень ожирения";
                    else if (bmi > 35 && bmi <= 40)
                        result = "Вторая степень ожирения";
                    else if (40 <= bmi)
                        result = "Третья степень ожирения";

                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(BMI.this);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("test1", result);
                    editor.apply();

                    Intent intent = new Intent(this, Result.class);
                    startActivity(intent);
                }catch (Exception ignored){}
        }
    }

    /*private void calculateBMI(){
        String heightBMI = height.getText().toString();
        String weightBMI = weight.getText().toString();

        if (heightBMI != null && weightBMI != null){
            float bmi = Float.parseFloat(weightBMI)/(Float.parseFloat(heightBMI)/100 * Float.parseFloat(heightBMI)/100);

            if (16 <= bmi && bmi <= 18.5)
                result = "Недостаток массы тела";
            else if (18.5 <= bmi && bmi <= 25)
                result = "Норма";
            else if (25 <= bmi && bmi <= 30)
                result = "Избыточная масса тела";
            else if (30 <= bmi && bmi <= 35)
                result = "Первая степень ожирения";
            else if (35 <= bmi && bmi <= 40)
                result = "Вторая степень ожирения";
            else if (40 <= bmi)
                result = "Третья степень ожирения";
        }
    }*/
}