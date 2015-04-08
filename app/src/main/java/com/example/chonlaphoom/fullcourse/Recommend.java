package com.example.chonlaphoom.fullcourse;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;


public class Recommend extends ActionBarActivity implements View.OnClickListener {

    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);
    }

    public void onClick(View view) {
        //click button code here na
        Intent Newfeed = new Intent(Recommend.this,NewFeed.class);
        startActivity(Newfeed);

    }


}
