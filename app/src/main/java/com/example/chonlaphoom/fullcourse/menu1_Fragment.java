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
 * This is MY FULLCOURSE page
 */
public class menu1_Fragment extends Fragment implements FCFragment.OnFragmentInteractionListener {

    public void onFragmentInteraction(String id) {

    }
    //#####################################################################

    //#################Tan's Fragment Edition#######################################
    View rootview;
    View Allview;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootview = inflater.inflate(R.layout.activity_my_full_course,container,false);

        Bundle bundle = getArguments();
        FCFragment fcFragment = new FCFragment();
        if (savedInstanceState == null) {
            fcFragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .add(R.id.container, fcFragment)
                    .commit();
        }

        return rootview;
    }


}
