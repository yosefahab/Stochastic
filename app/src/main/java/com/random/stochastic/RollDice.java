package com.random.stochastic;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class RollDice extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice);
    }

    public void DiceRoll(View v) {
        Random random = new Random();
        int x = random.nextInt(6) + 1; // number between 0 exclusive and 7 exclusive
        TextView tv = (TextView) findViewById(R.id.DiceFace);
        String face = String.valueOf(x);
        tv.setText(face);
    }
}