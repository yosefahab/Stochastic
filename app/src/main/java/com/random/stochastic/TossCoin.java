package com.random.stochastic;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class TossCoin extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss_coin);
    }

    public void CoinToss(View v) {
        double x = Math.random();
        String face;
        TextView tv = (TextView) findViewById(R.id.coinText);
        if (x < 0.5) {
            face = "Heads";
        } else {
            face = "Tails";
        }

        tv.setText(face);

    }
}