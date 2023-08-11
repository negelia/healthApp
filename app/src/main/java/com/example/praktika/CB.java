package com.example.praktika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CB extends AppCompatActivity {

    EditText chss, sad, dad, pd;
    //int cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb);


        chss = (EditText) findViewById(R.id.height);
        sad = (EditText) findViewById(R.id.weight);
        dad = (EditText) findViewById(R.id.height2);
        pd = (EditText) findViewById(R.id.weight2);
    }

    public void viewClick(View view) {
        int cb = 0;

        String chssRes = chss.getText().toString ();
        String sadRes = sad.getText().toString();
        String dadRes = dad.getText().toString();
        String pdRes = pd.getText().toString();

        if (
                chssRes.startsWith(".") || sadRes.startsWith(".") || dadRes.startsWith(".") || pdRes.startsWith(".")
                        || chssRes.startsWith(",") || sadRes.startsWith(",") || dadRes.startsWith(".") || pdRes.startsWith(".")
                        || chssRes.startsWith("-") || sadRes.startsWith("-") || dadRes.startsWith(".") || pdRes.startsWith(".")
                        || chssRes.startsWith("_")|| sadRes.startsWith("_") || dadRes.startsWith(".") || pdRes.startsWith(".")
                        || chssRes.matches("")|| sadRes.matches("") || dadRes.startsWith(".") || dadRes.startsWith(".")
                        || chssRes.contains(",")|| sadRes.contains(",") || dadRes.startsWith(".") || dadRes.startsWith(".")
                        || chssRes.contains("-")|| sadRes.contains("-") || dadRes.startsWith(".") || dadRes.startsWith(".")
                        || chssRes.contains(" ")|| sadRes.contains(" ") || dadRes.startsWith(".") || dadRes.startsWith(".")
                        || chssRes.contains(".")|| sadRes.contains(".") || dadRes.contains(".")|| pdRes.contains(".")
        )
        {
            Toast toast = Toast.makeText(this, "Проверьте правильности ввода данных!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            if (chssRes != null && sadRes != null && dadRes != null && pdRes != null){
                    if (chssRes != sadRes && chssRes != dadRes &&  chssRes != pdRes && sadRes != dadRes && sadRes != pdRes
                                && dadRes != pdRes && (Integer.parseInt(sadRes) - Integer.parseInt(dadRes) != 0)) {
                        cb = (Integer.parseInt(chssRes) * 10) / (Integer.parseInt(sadRes) - Integer.parseInt(dadRes));
                        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(CB.this);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("test3", String.valueOf(cb));
                        editor.apply();
                        Intent intent = new Intent(CB.this, Result2.class);
                        startActivity(intent);
                    }
            }

        }
    }
}