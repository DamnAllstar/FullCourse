package com.example.chonlaphoom.fullcourse;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Thanaphon on 4/10/2015.
 */
public class menu4_Fragment extends Fragment {
    View rootview;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootview = inflater.inflate(R.layout.activity_setting,container,false);
        context=container.getContext();
        return rootview;
    }


}
