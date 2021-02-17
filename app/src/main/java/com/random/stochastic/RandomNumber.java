package com.random.stochastic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RandomNumber extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);
    }

    EditText A;
    EditText B;
    TextView r;
    Button generate;
    int min, max, output;
    Random x = new Random();

    public void Randomise(View view) {
        A = (EditText) findViewById(R.id.IntervalA);
        B = (EditText) findViewById(R.id.IntervalB);
        r = (TextView) findViewById(R.id.RandomNum);
        generate = (Button) findViewById(R.id.Randomise);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TempMin, TempMax;
                TempMin = A.getText().toString();
                TempMax = B.getText().toString();

                if (!TempMin.equals("") && !TempMax.equals("")) {
                    min = Integer.parseInt(TempMin);
                    max = Integer.parseInt(TempMax);
                    if (max > min) {
                        output = x.nextInt(max - min) + 1 + min;
                        r.setText(""+output);
                    } else {
                        Toast.makeText(getBaseContext(), "Start of Interval must be less than End!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getBaseContext(), "Specify Interval first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}