package com.example.chonlaphoom.fullcourse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;


import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.FacebookSdk;

import org.json.JSONArray;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    EditText email;
    EditText password;
    ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;
    ConnectServer connectServer;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printHashKey();
        FacebookSdk.sdkInitialize(getApplicationContext());
        Log.d("Chonlaphoom", "onCreateMain");
        setContentView(R.layout.activity_main);

        //In this next line, note that 'btn' will never be used, it's
        //grayed out in the "Button btn...", and in the (R.id.btn) it is
        //shown in red font, indicating I probably need to declare a resource of some kind?

        ImageButton btn = (ImageButton)findViewById(R.id.btnStartAnotherActivity);
        ImageButton btn2 = (ImageButton)findViewById(R.id.btnStartAnotherActivity2);
        Button mewmew = (Button)findViewById(R.id.MP);

        email = (EditText)findViewById(R.id.editText2);
        password =(EditText)findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show text from text edit
                Context context = getApplicationContext();

                Toast.makeText(context, email.getText().toString()+" "+password.getText().toString(), Toast.LENGTH_SHORT).show();

                ConnectServer connectServer = new ConnectServer(MainActivity.this, "http://naneport.arg.in.th/eatwell/full/login.php");
                connectServer.addValue("editeText2",email.getText().toString());
                connectServer.addValue("editeText",password.getText().toString());
                connectServer.execute();

                //go to recommend
                Intent intent = new Intent(MainActivity.this, NewFeeds.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
            }
        });
//to mark a place get data in here 0 for lat 1 for lng
        final double[][] LL = new double[3][2];
        LL[0][0] = 0.50;
        LL[0][1] = 0.50;
        LL[1][0] = 0.15;
        LL[1][1] = 0.15;
        LL[2][0] = 0.8;
        LL[2][1] = 0.8;

        mewmew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GMap.class);

                Bundle LLsend = new Bundle();
                LLsend.putSerializable("list", LL);

                intent.putExtras(LLsend);

                intent.putExtra("Arl",LL);  //Array passing
                intent.putExtra("type",0);  //use type 1 to use a one place marking function
                //type 0 to use many place marking function !!assign in the array above
                //Type 1 passing variable
                intent.putExtra("Lat",18.769289);
                intent.putExtra("Lng",98.976250);
                intent.putExtra("title","New place");
                intent.putExtra("detail","This is stupid");
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


    public void printHashKey() {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.chonlaphoom.fullcourse",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("Chonlaphoom", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
    ///ถ้าไม่สามารถเชื่อมต่อกับ Server ได้จะมาทำงานที่ Function นี้
    public void cannotConnectToServer() {
        Toast.makeText(this, "ไม่สามารถเชื่อมต่อกับ Server", Toast.LENGTH_LONG).show();
    }

    //ถ้าดึงข้อมูลจาก Server มีปัญหา จะมาทำงานที่ Function นี้
    public void errorConnectToServer() {
        Toast.makeText(this, "ไม่พบข้อมูลที่ค้นหา", Toast.LENGTH_LONG).show();
    }

    public void setList(ArrayList<String> list){
        this.list = list;


        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, this.list);
        listView.setAdapter(arrayAdapter);
    }
}
