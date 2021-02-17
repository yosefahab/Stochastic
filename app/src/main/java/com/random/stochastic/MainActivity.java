package com.random.stochastic;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String sharedPref = "Theme";
    String GT, theme = "theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sh = getSharedPreferences(sharedPref, MODE_PRIVATE);
        GT = sh.getString(theme, "Morning");
        assert GT != null;
        switch (GT) {
            case "Morning":
                setTheme(R.style.MorningTheme);
                break;
            case "Midnight":
                setTheme(R.style.MidnightTheme);
                break;
            case "Black and White":
                setTheme(R.style.BlackAndWhite);
                break;
            case "Colorful":
                setTheme(R.style.ColorfulTheme);
                break;
            case "Frosty":
                setTheme(R.style.FrostyTheme);
                break;
        }
        //TODO: add ads
        setContentView(R.layout.activity_main);
    }

    public void Navigate_Settings(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
    public void Navigate_Coin(View view) {
        Intent intent = new Intent(MainActivity.this, TossCoin.class);
        startActivity(intent);
    }

    public void Navigate_Dice(View view) {
        Intent intent = new Intent(MainActivity.this, RollDice.class);
        startActivity(intent);
    }

    public void Navigate_PRNG(View view) {
        Intent intent = new Intent(MainActivity.this, RandomNumber.class);
        startActivity(intent);
    }

    public void Navigate_PickForMe(View view) {
        Intent intent = new Intent(MainActivity.this, PickForMe.class);
        startActivity(intent);
    }
}