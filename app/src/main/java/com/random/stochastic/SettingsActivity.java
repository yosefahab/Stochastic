package com.random.stochastic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsActivity extends MainActivity {

    String sharedPref = "Theme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final Spinner mySpinner = findViewById(R.id.ThemeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.themes, android.R.layout.simple_dropdown_item_1line);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter((adapter));
        mySpinner.setSelection(5);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String SelectedTheme = parent.getItemAtPosition(position).toString();
                int i = mySpinner.getSelectedItemPosition();
                if (i != 5) {
                    String theme = "theme";
                    SharedPreferences sharedPreferences = getSharedPreferences(sharedPref,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(theme, SelectedTheme); //keyword = theme and value = selected theme
                    editor.apply();
                    restartApp();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void restartApp() {
        Intent i = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
