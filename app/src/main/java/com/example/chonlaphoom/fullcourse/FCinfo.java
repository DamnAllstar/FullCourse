package com.example.chonlaphoom.fullcourse;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by amin on 4/26/2015.
 */
public class FCinfo extends ActionBarActivity {
    int id =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fc_info);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("ID");
        }
        TextView text = (TextView) findViewById(R.id.by);
        text.setText("by "+String.valueOf(id));
        text = (TextView) findViewById(R.id.name);
        text.setText("EBI");
        text = (TextView) findViewById(R.id.appetizer);
        text.setText("Nude dle");
        text = (TextView) findViewById(R.id.soup);
        text.setText("Lobster soup");
        text = (TextView) findViewById(R.id.fish);
        text.setText("2 fish");
        text = (TextView) findViewById(R.id.meat);
        text.setText("Bacon cabbage");
        text = (TextView) findViewById(R.id.main);
        text.setText("Shrimp");
        text = (TextView) findViewById(R.id.salad);
        text.setText("Meat salad");
        text = (TextView) findViewById(R.id.dessert);
        text.setText("Jelly");
        text = (TextView) findViewById(R.id.drink);
        text.setText("Jizz");
    }
}
