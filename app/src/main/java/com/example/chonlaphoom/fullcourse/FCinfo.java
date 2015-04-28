package com.example.chonlaphoom.fullcourse;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by amin on 4/26/2015.
 */
public class FCinfo extends ActionBarActivity {
    int id =0;

    ConnectGetFCInfo connectGetFCInfo;
    ConnectGetFullOwner connectGetFullOwner;
    ArrayList<String> food_name;
    ArrayList<String> rest_name;
    ArrayList<Integer> food_price;
    String getOwner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fc_info);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "GOTHIC.TTF");
        Typeface myTypeface2 = Typeface.createFromAsset(getAssets(), "GOTHICI.TTF");

        TextView myFName = (TextView)findViewById(R.id.name);
        TextView myNameCt = (TextView)findViewById(R.id.nameCt);
        TextView myBy = (TextView)findViewById(R.id.by);
        TextView mytextView9 = (TextView)findViewById(R.id.textView9);
        TextView myAppetizer = (TextView)findViewById(R.id.appetizer);
        TextView mytextView8 = (TextView)findViewById(R.id.textView8);
        TextView mytextView10 = (TextView)findViewById(R.id.textView10);
        TextView mytextView11 = (TextView)findViewById(R.id.textView11);
        TextView mytextView12= (TextView)findViewById(R.id.textView12);
        TextView mytextView13 = (TextView)findViewById(R.id.textView13);
        TextView mytextView14 = (TextView)findViewById(R.id.textView14);
        TextView mytextSoup = (TextView)findViewById(R.id.soup);
        TextView mytextSoup_2 = (TextView)findViewById(R.id.soup_2);
        TextView mytextFish= (TextView)findViewById(R.id.fish);
        TextView mytextMeat = (TextView)findViewById(R.id.meat);
        TextView mytextMain = (TextView)findViewById(R.id.main);
        TextView mytextSalad = (TextView)findViewById(R.id.salad);
        TextView mytextDessert = (TextView)findViewById(R.id.dessert);
        TextView mytextDrink = (TextView)findViewById(R.id.drink);

        myFName.setTypeface(myTypeface);
        myNameCt.setTypeface(myTypeface);
        mytextView8.setTypeface(myTypeface);
        mytextView9.setTypeface(myTypeface);
        mytextView10.setTypeface(myTypeface);
        mytextView11.setTypeface(myTypeface);
        mytextView12.setTypeface(myTypeface);
        mytextView13.setTypeface(myTypeface);
        mytextView14.setTypeface(myTypeface);
        mytextSoup.setTypeface(myTypeface);

        myBy.setTypeface(myTypeface2);
        myAppetizer.setTypeface(myTypeface2);
        mytextSoup_2.setTypeface(myTypeface2);
        mytextDrink.setTypeface(myTypeface2);
        mytextDessert.setTypeface(myTypeface2);
        mytextFish.setTypeface(myTypeface2);
        mytextMain.setTypeface(myTypeface2);
        mytextMeat.setTypeface(myTypeface2);
        mytextSalad.setTypeface(myTypeface2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("ID");
        }

        connectGetFCInfo = new ConnectGetFCInfo(FCinfo.this, "http://naneport.arg.in.th/eatwell/full/getFullFood.php");
        connectGetFCInfo.addValue("fullId",String.valueOf(id));
        connectGetFCInfo.execute();


        connectGetFullOwner = new ConnectGetFullOwner(FCinfo.this, "http://naneport.arg.in.th/eatwell/full/getFullOwner.php");
        connectGetFullOwner.addValue("fullId",String.valueOf(id));
        connectGetFullOwner.execute();



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

    public void getFullOwner(ArrayList<String> owner)
    {
        getOwner = String.valueOf(owner.get(0));

        TextView text = (TextView) findViewById(R.id.by);
        text.setText("by ");
        text = (TextView) findViewById(R.id.nameCt);
        text.setText(getOwner);

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


     //   Toast.makeText(this, getOwner, Toast.LENGTH_LONG).show();

    }
}
