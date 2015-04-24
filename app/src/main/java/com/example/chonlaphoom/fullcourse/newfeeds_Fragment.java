package com.example.chonlaphoom.fullcourse;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Thanaphon on 4/10/2015.
 */
public class newfeeds_Fragment extends android.support.v4.app.Fragment implements NewsFeed.OnFragmentInteractionListener {

    //Button btnDone;
    //##########################Tynk's Original#####################################
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.fragment_new_feeds);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new NewsFeed())
                    .commit();
        }

        //btnDone = (Button) findViewById(R.id.btnDone);
        //btnDone.setOnClickListener((View.OnClickListener) this);

    }*/



    @Override
    public void onFragmentInteraction(String id) {

    }

    //#####################################################################

    //#################Tan's Fragment Edition#######################################
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootview = inflater.inflate(R.layout.fragment_new_feeds,container,false);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new NewsFeed())
                    .commit();
        }

        return rootview;
    }
    //#############################################################################
}
