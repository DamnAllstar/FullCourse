package com.example.chonlaphoom.fullcourse;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;


import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //In this next line, note that 'btn' will never be used, it's
        //grayed out in the "Button btn...", and in the (R.id.btn) it is
        //shown in red font, indicating I probably need to declare a resource of some kind?


        ImageButton btn = (ImageButton)findViewById(R.id.btnStartAnotherActivity);
        ImageButton btn2 = (ImageButton)findViewById(R.id.btnStartAnotherActivity2);
        email = (EditText)findViewById(R.id.editText2);
        password =(EditText)findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show text from text edit
                Context context = getApplicationContext();

                Toast.makeText(context, email.getText().toString()+" "+password.getText().toString(), Toast.LENGTH_SHORT).show();

                //go to recommend
                //Intent intent = new Intent(MainActivity.this, Recommend.class);
                //startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
