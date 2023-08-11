package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    TextView txt;
    public static final String APP_PREFERENCES = "data";
    public static final String APP_PREFERENCES_RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txt = (TextView) findViewById(R.id.textView5);


        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(Result.this);
        txt.setText(pref.getString("test1", ""));
    }

    public void NextClick(View view) {
        Intent intent = new Intent(this, StepsCount.class);
        startActivity(intent);
    }
}