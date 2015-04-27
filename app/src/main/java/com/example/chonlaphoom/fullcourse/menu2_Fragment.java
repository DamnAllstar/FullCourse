package com.example.chonlaphoom.fullcourse;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Thanaphon on 4/10/2015.
 */
public class menu2_Fragment extends Fragment implements Favorite.OnFragmentInteractionListener {

    public void onFragmentInteraction(String id) {

    }

    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootview = inflater.inflate(R.layout.activity_favorite,container,false);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new Favorite())
                    .commit();
        }

        return rootview;

    }

}