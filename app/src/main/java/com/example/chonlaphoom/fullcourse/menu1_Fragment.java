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
public class menu1_Fragment extends Fragment implements FCFragment.OnFragmentInteractionListener,View.OnClickListener {

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


    @Override
    public void onClick(View v) {
        ImageButton button = (ImageButton)v.findViewById(R.id.AddFC);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(menu1_Fragment.this.getActivity(), FCRegister.class);
                startActivity(intent);
            }
        });


    }
}
