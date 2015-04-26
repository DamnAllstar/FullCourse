package com.example.chonlaphoom.fullcourse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This is MY FULLCOURSE page
 */
public class menu1_Fragment extends Fragment implements FCFragment.OnFragmentInteractionListener{

    @Override
    public void onFragmentInteraction(String id) {

    }

    //#####################################################################

    //#################Tan's Fragment Edition#######################################
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootview = inflater.inflate(R.layout.activity_my_full_course,container,false);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new FCFragment())
                    .commit();
        }

        return rootview;
    }
    //#####################################################################

}
