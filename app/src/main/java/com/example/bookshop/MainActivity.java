package com.example.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    EditText name,pass;
    Button insert,update,delete,read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editText);
        pass =findViewById(R.id.editText2);
        insert=findViewById(R.id.button);
        update=findViewById(R.id.button2);
        delete=findViewById(R.id.button3);
        read=findViewById(R.id.button4);
    }
}
