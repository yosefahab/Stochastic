package com.random.stochastic;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class PickForMe extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_for_me);
    }

    Button save;
    EditText txt;
    ListView show;
    ArrayList<String> Items = new ArrayList<>();

    public void saveItem(View view) {
        txt = (EditText) findViewById(R.id.list_item);
        show = (ListView) findViewById(R.id.listView);
        save = (Button) findViewById(R.id.addItem);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getInput = txt.getText().toString();
                if (Items.contains(getInput)) {
                    Toast.makeText(getBaseContext(), "Item already in list", Toast.LENGTH_SHORT).show();
                } else if (getInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Input Field is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Items.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(PickForMe.this, android.R.layout.simple_list_item_1, Items);
                    show.setAdapter(adapter);
                    ((EditText) findViewById(R.id.list_item)).setText(" ");
                }
            }


        });
    }

    public void pickItem(View view) {
        if (!Items.isEmpty()) {
            TextView tv = (TextView) findViewById(R.id.randomItem);
            Random random = new Random();
            int x = random.nextInt(Items.size());
            tv.setText(Items.get(x));
        } else {
            Toast.makeText(getBaseContext(), "Enter Items First!", Toast.LENGTH_SHORT).show();
        }
    }

    public void emptyList(View view) {
        if (!Items.isEmpty()) {
            Items.clear();
            show.setAdapter(null);
        } else {
            Toast.makeText(getBaseContext(), "List already Empty!", Toast.LENGTH_SHORT).show();
        }
    }
}
