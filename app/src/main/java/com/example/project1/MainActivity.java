package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class MainActivity<Button2> extends AppCompatActivity {

    static int right = 0;
    static int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton[][] Preradio = createButton();
        Button btn = findViewById(R.id.button1);
        LinearLayout mainl = (LinearLayout) findViewById(R.id.linear1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mainl.removeAllViews();
                RadioButton[][] Postradio = createButton();

                Button btn2 = new Button(MainActivity.this);
                btn2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                btn2.setText((CharSequence) "next");
                btn2.setTextSize(40);

                mainl.addView(btn2);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int result = 0;
                        for (int i = 0; i < Preradio.length; i++) {
                            Boolean[] Pre = new Boolean[4];
                            Boolean[] next = new Boolean[4];

                            Pre[0] = Preradio[i][0].isChecked();
                            Pre[1] = Preradio[i][1].isChecked();
                            Pre[2] = Preradio[i][2].isChecked();
                            Pre[3] = Preradio[i][3].isChecked();

                            next[0] = Postradio[i][0].isChecked();
                            next[1] = Postradio[i][1].isChecked();
                            next[2] = Postradio[i][2].isChecked();
                            next[3] = Postradio[i][3].isChecked();

                            if (Arrays.deepEquals(Pre, next)) {

                                result = result + 1;
                            }
                        }

                        right = result;
                        wrong = 5 - result;
                        System.out.println(result);
                        Intent i = new Intent(MainActivity.this, MainActivity2.class);
                        i.putExtra("True", String.valueOf(result));
                        i.putExtra("False", String.valueOf(wrong));
                        i.putExtra("total",String.valueOf(5));
                        startActivity(i);
                    }
                });

            }
        });

    }

    private RadioButton[][] createButton() {
        LinearLayout mainl = (LinearLayout) findViewById(R.id.linear1);
        RadioButton[][] radioButtons = new RadioButton[5][4];

        for (int i = 0; i < radioButtons.length; i++) {
            RadioGroup RGroup = new RadioGroup(this);
            RGroup.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            RGroup.setOrientation(LinearLayout.HORIZONTAL);

            TextView txt = new TextView(this);

            txt.setText((CharSequence) String.valueOf(i + 1));
            txt.setTextSize(40);
            txt.setTextColor(Color.WHITE);
            txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            RadioButton R1A = new RadioButton(this);
            R1A.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            R1A.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            R1A.setTextColor(Color.WHITE);
            R1A.setTextSize(40);
            R1A.setText((CharSequence) "A");


            RadioButton R1B = new RadioButton(this);
            R1B.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            R1B.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            R1B.setTextColor(Color.WHITE);
            R1B.setTextSize(40);
            R1B.setText((CharSequence) "B");

            RadioButton R1C = new RadioButton(this);
            R1C.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            R1C.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            R1C.setTextColor(Color.WHITE);
            R1C.setTextSize(40);
            R1C.setText((CharSequence) "C");

            RadioButton R1D = new RadioButton(this);
            R1D.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            R1D.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            R1D.setTextColor(Color.WHITE);
            R1D.setTextSize(40);
            R1D.setText((CharSequence) "D");

            RGroup.addView(txt);
            RGroup.addView(R1A);
            RGroup.addView(R1B);
            RGroup.addView(R1C);
            RGroup.addView(R1D);

            radioButtons[i][0] = R1A;
            radioButtons[i][1] = R1B;
            radioButtons[i][2] = R1C;
            radioButtons[i][3] = R1D;

            mainl.addView(RGroup);

        }
        return radioButtons;

    }

}



