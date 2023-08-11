package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class AllTest extends AppCompatActivity {

    ArrayList<Model> results = new ArrayList<Model>();
    public static final String APP_PREFERENCES = "data";
    public static final String APP_PREFERENCES_NAME = "title";
    public static final String APP_PREFERENCES_RESULT = "result";

    SharedPreferences mSettings;
    TextView txt, txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_test);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        txt = (TextView) findViewById(R.id.name);
        txt1 = (TextView) findViewById(R.id.result);

        setData();
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, results);
        recyclerView.setAdapter(adapter);

        /*RecyclerView recyclerView = findViewById(R.id.recycleView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, results);
        recyclerView.setAdapter(adapter);*/
    }

    public void NextClick(View view) {
    }

    public void setData(){
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(AllTest.this);
        results.add(new Model ("Индекс массы тела", pref.getString("test1", "")));
        results.add(new Model ("Счётчик шагов", pref.getString("test2", "")));
        results.add(new Model ("Коэффициент выносливости", pref.getString("test3", "")));
        results.add(new Model ("Регуляция сердечно-сосудистой системы", pref.getString("test4", "")));
        results.add(new Model ("Жизненный индекс", pref.getString("test5", "")));
        results.add(new Model ("Циркулярно-респираторный коэффициент", pref.getString("test6", "")));
        results.add(new Model ("Вегетативный индекс Кердо", pref.getString("test7", "")));
        results.add(new Model ("Индекс функциональных изменений", pref.getString("test8", "")));
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void index(View view) {
        Intent intent = new Intent(this, Index.class);
        startActivity(intent);
    }

    public void result(View view) {
        Intent intent = new Intent(this, AllTest.class);
        startActivity(intent);
    }
}