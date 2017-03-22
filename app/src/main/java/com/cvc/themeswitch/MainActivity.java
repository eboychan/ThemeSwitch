package com.cvc.themeswitch;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mSharedPreferences;
    Button first;
    Button second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Theme Switching
        mSharedPreferences = getSharedPreferences("Theme", 0);
        Boolean secondTheme = mSharedPreferences.getBoolean("key", false);
        // Light theme is default in manifest, only have to check for dark
        if(secondTheme){
            this.setTheme(R.style.AppTheme_Dark);
        }
        setContentView(R.layout.activity_main);

        first = (Button) findViewById(R.id.btnOne);
        second = (Button) findViewById(R.id.btnTwo);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putBoolean("key", true);
                editor.commit();
                recreate();

            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putBoolean("key", false);
                editor.commit();
                recreate();
            }
        });
    }
}

