package com.example.chonlaphoom.fullcourse;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by Chonlaphoom on 4/16/2015.
 */
public class MainFragment extends android.support.v4.app.Fragment {

    private TextView mTextDetail;


    private CallbackManager mCallbackManager;
    private FacebookCallback<LoginResult> mCallback=new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();

            if(profile != null){
                 mTextDetail.setText("Welcome" + profile.getName());
            }
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };

    public MainFragment(){

    }

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        return inflater.inflate(R.layout.activity_main, container, false);
    }

    public void onViewCreated(View view , Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        LoginButton  LoginButton = (LoginButton) view.findViewById(R.id.login_button);
        LoginButton.setReadPermissions("user_friends");
        LoginButton.setFragment(this);
        LoginButton.registerCallback(mCallbackManager,mCallback);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
