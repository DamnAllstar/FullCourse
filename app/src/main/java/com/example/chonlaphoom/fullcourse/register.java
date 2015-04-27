package com.example.chonlaphoom.fullcourse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class register extends ActionBarActivity {

    EditText name;
    EditText email;
    EditText password;
    EditText repassword;
    EditText sirname;

    String forCheckEmail;
    String part1;
    String part2;
    ConnectInsertDel connectServer;
    String get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "GOTHIC.TTF");


        EditText myDisplayName= (EditText)findViewById(R.id.editText3);
        EditText mySirname = (EditText)findViewById(R.id.editText4);
        EditText myEmail = (EditText)findViewById(R.id.editText5);
        EditText myCPassword = (EditText)findViewById(R.id.editText6);
        EditText myCRepass = (EditText)findViewById(R.id.editText7);
        TextView myRegist = (TextView)findViewById(R.id.textRegist);
        myDisplayName.setTypeface(myTypeface);
        mySirname.setTypeface(myTypeface);
        myEmail.setTypeface(myTypeface);
        myCPassword.setTypeface(myTypeface);
        myCRepass.setTypeface(myTypeface);
        myRegist.setTypeface(myTypeface);

        ImageButton regist = (ImageButton)findViewById(R.id.imageButton);
        name = (EditText)findViewById(R.id.editText3);
        sirname = (EditText)findViewById(R.id.editText4);
        email = (EditText)findViewById(R.id.editText5);
        password = (EditText)findViewById(R.id.editText6);
        repassword = (EditText)findViewById(R.id.editText7);


        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = getApplicationContext();
                //      Toast.makeText(context,name.getText().toString()+" "+email.getText().toString()+" "+password.getText().toString()
                //     +" "+repassword.getText().toString(),Toast.LENGTH_SHORT).show();

                //      String[] parts = email.getText().toString().split("@");
                //      String part1            = parts[0];
                //      String part2            = parts[1];
                //      Toast.makeText(context,part1,Toast.LENGTH_SHORT).show();

                if(password.getText().toString().equals(repassword.getText().toString()) ) {

                    if(email.getText().toString().contains("@") ) {


                        connectServer = new ConnectInsertDel(register.this, "http://naneport.arg.in.th/eatwell/full/test2.php");

                        connectServer.addValue("regisemail", email.getText().toString());
                        connectServer.addValue("regisname", name.getText().toString());
                        connectServer.addValue("regissirname", sirname.getText().toString());
                        connectServer.addValue("regispassword", password.getText().toString());
                        connectServer.addValue("reregispassword", repassword.getText().toString());

                        Toast.makeText(context,"Register successed",Toast.LENGTH_SHORT).show();
                        connectServer.execute();
                        Intent intent = new Intent(register.this, MainActivity.class);
                        startActivity(intent);
                    }else{Toast.makeText(context,"check @ in email box",Toast.LENGTH_SHORT).show();}

                }else{Toast.makeText(context,"password should be equal  repassword",Toast.LENGTH_SHORT).show();}

            /*
                try {
                    connectServer.execute();
                } catch () {
                    e.printStackTrace();
                }

     //           Intent intent = new Intent(register.this, MainActivity.class);
     //           startActivity(intent);

                //check @ in email box
                String[] parts = email.getText().toString().split("@");
                String part1            = parts[0];
                String part2            = parts[1];
                //

                if(part1 != null && part2 != null) {
                   connectServer.execute();
                }
                else
                {
              //      Toast.makeText(context,"please do some shit with @ in email box fuck",Toast.LENGTH_SHORT).show();
                }
            */}
        });
    }



}
