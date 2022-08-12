package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tx = findViewById(R.id.tex);
        TextView txt = findViewById(R.id.totalq);
        TextView txt2 = findViewById(R.id.rtrue);
        TextView txt3 = findViewById(R.id.rfalse);



        Intent intent = getIntent();
        String right  = intent.getStringExtra("True");
        String wrong = intent.getStringExtra("False");


        txt.setText("\n"+(right));
        txt2.setText(right);
        txt3.setText(wrong);




    }
}