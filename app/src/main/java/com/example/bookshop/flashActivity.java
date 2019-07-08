package com.example.bookshop;

import android.content.Intent;
import android.os.Handler;
import java.lang.Runnable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class flashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(flashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}
