package com.example.chonlaphoom.fullcourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Recommend extends ActionBarActivity implements NewsFeed.OnFragmentInteractionListener {

    //Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new NewsFeed())
                    .commit();
        }

        //btnDone = (Button) findViewById(R.id.btnDone);
        //btnDone.setOnClickListener((View.OnClickListener) this);

    }

    public void onClick(View view) {
        //click button code here na
        Intent Newfeeds = new Intent(Recommend.this,NewFeeds.class);
        startActivity(Newfeeds);

    }


    @Override
    public void onFragmentInteraction(String id) {

    }
}
