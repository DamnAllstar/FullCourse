package com.example.chonlaphoom.fullcourse;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by amin on 4/26/2015.
 */
public class FCinfo extends ActionBarActivity {
    int id =0;

    ConnectGetFCInfo connectGetFCInfo;
    ArrayList<String> food_name;
    ArrayList<String> rest_name;
    ArrayList<Integer> food_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fc_info);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("ID");
        }

        connectGetFCInfo = new ConnectGetFCInfo(FCinfo.this, "http://naneport.arg.in.th/eatwell/full/getFullFood.php");
        connectGetFCInfo.addValue("fullId",String.valueOf(id));
        connectGetFCInfo.execute();

        TextView text = (TextView) findViewById(R.id.by);
        text.setText("by "+String.valueOf(id));

        text = (TextView) findViewById(R.id.name);
        text.setText("EBI");
        text = (TextView) findViewById(R.id.appetizer);
        text.setText("Nude dle");
        text = (TextView) findViewById(R.id.soup);
        text.setText("Lobster soup");
        text = (TextView) findViewById(R.id.fish);
        text.setText("2 fish");
        text = (TextView) findViewById(R.id.meat);
        text.setText("Bacon cabbage");
        text = (TextView) findViewById(R.id.main);
        text.setText("Shrimp");
        text = (TextView) findViewById(R.id.salad);
        text.setText("Meat salad");
        text = (TextView) findViewById(R.id.dessert);
        text.setText("Jelly");
        text = (TextView) findViewById(R.id.drink);
        text.setText("Jizz");
    }

    ///ถ้าไม่สามารถเชื่อมต่อกับ Server ได้จะมาทำงานที่ Function นี้
    public void cannotConnectToServer() {
        Toast.makeText(this, "ไม่สามารถเชื่อมต่อกับ Server", Toast.LENGTH_LONG).show();
    }

    //ถ้าดึงข้อมูลจาก Server มีปัญหา จะมาทำงานที่ Function นี้
    public void errorConnectToServer() {
            Toast.makeText(this, "ไม่พบข้อมูลที่ค้นหา", Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "login fail", Toast.LENGTH_LONG).show();

    }

    public void setList(ArrayList<String> food_name , ArrayList<String> rest_name , ArrayList<Integer> food_price){

        this.food_name = food_name;
        this.rest_name = rest_name;
        this.food_price = food_price;

        Context context = getApplicationContext();
        Toast.makeText(context,String.valueOf(this.food_name.get(0))+String.valueOf(this.food_price.get(0))
                +String.valueOf(this.rest_name.get(0))
                ,Toast.LENGTH_SHORT).show();
    }
}
