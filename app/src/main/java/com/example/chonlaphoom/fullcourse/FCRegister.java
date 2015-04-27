package com.example.chonlaphoom.fullcourse;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amin on 4/26/2015.
 */
public class FCRegister extends ActionBarActivity {

    private Spinner appe,fish,meat,main,salad,dessert;
    private ImageButton submit;




    public  ArrayList<String> listApp;
    public  ArrayList<String> listMain;
    public  ArrayList<String> listDessert;
    public  ArrayList<String> listFish;
    public  ArrayList<String> listSalad;
    public  ArrayList<String> listMeat;

    String getUserName;

    EditText change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fc_register);

        change = (EditText)findViewById(R.id.editText2);

        ConnectServer connectServer = new ConnectServer(FCRegister.this, "http://naneport.arg.in.th/eatwell/full/addFull.php");

        ConnectGetFoodByApp  connectGetFoodByApp = new ConnectGetFoodByApp(FCRegister.this, "http://naneport.arg.in.th/eatwell/full/getFoodByAppe.php");
        connectGetFoodByApp.execute();
        ConnectGetFoodByMain  connectGetFoodByMain = new ConnectGetFoodByMain(FCRegister.this, "http://naneport.arg.in.th/eatwell/full/getFoodByMain.php");
        connectGetFoodByMain.execute();
        ConnectGetFoodByMeat connectGetFoodByMeat = new ConnectGetFoodByMeat(FCRegister.this, "http://naneport.arg.in.th/eatwell/full/getFoodByMeat.php");
        connectGetFoodByMeat.execute();
        ConnectGetFoodByFish  connectGetFoodByFish = new ConnectGetFoodByFish(FCRegister.this, "http://naneport.arg.in.th/eatwell/full/getFoodByFish.php");
        connectGetFoodByFish.execute();
        ConnectGetFoodBySalad  connectGetFoodBySalad = new ConnectGetFoodBySalad(FCRegister.this, "http://naneport.arg.in.th/eatwell/full/getFoodBySalad.php");
        connectGetFoodBySalad.execute();
        ConnectGetFoodByDessert  connectGetFoodByDessert = new ConnectGetFoodByDessert(FCRegister.this, "http://naneport.arg.in.th/eatwell/full/getFoodByDessert.php");
        connectGetFoodByDessert.execute();



     //   addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

    }

    // add array แบบ dynamic
    public void addItemsOnSpinner2Main(ArrayList<String> list) {
        String test;

        //   List<String> list = new ArrayList<String>();
    //    list.add("Ice Cream");
    //    list.add("Honey Toast");
     //   list.add("Berry Cake");
     //   list.add("Tokyo Banana");
    //    test= String.valueOf(listMain.get(0));
     //   Toast.makeText(this, test, Toast.LENGTH_LONG).show();
   //   for(int i = 0;i<listMain.size();i++) {
   //         test = String.valueOf(listMain.get(i));
   //         list.add(test);
   //     }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        main.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinner2Dessert(ArrayList<String> list) {
        String test;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dessert.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinner2Fish(ArrayList<String> list) {
        String test;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fish.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinner2Meat(ArrayList<String> list) {
        String test;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        meat.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinner2Salad(ArrayList<String> list) {
        String test;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        salad.setAdapter(dataAdapter);
    }

    public void addItemsOnSpinner2App(ArrayList<String> list) {
        String test;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appe.setAdapter(dataAdapter);
    }
    //

    //รั บ Listener ของอั นที่  ไม่ ใช่ dynamic
    public void addListenerOnSpinnerItemSelection() {

        appe = (Spinner) findViewById(R.id.Rappe);
        appe.setOnItemSelectedListener(new DropDownList());

        fish = (Spinner) findViewById(R.id.Rfish);
        fish.setOnItemSelectedListener(new DropDownList());

        meat    = (Spinner) findViewById(R.id.Rmeat);
        meat.setOnItemSelectedListener(new DropDownList());

        salad = (Spinner) findViewById(R.id.Rsalad);
        salad.setOnItemSelectedListener(new DropDownList());

        main = (Spinner) findViewById(R.id.Rmain);
        main.setOnItemSelectedListener(new DropDownList());

        dessert = (Spinner) findViewById(R.id.Rdessert);
        dessert.setOnItemSelectedListener(new DropDownList());

     //   drink = (Spinner) findViewById(R.id.Rdrink);
     //   drink.setOnItemSelectedListener(new DropDownList());

    }

    public void addListenerOnButton() {

        appe = (Spinner) findViewById(R.id.Rappe);
      //  soup = (Spinner) findViewById(R.id.Rsoup);
        fish = (Spinner) findViewById(R.id.Rfish);
        meat = (Spinner) findViewById(R.id.Rmeat);
        main = (Spinner) findViewById(R.id.Rmain);
        dessert = (Spinner) findViewById(R.id.Rdessert);
        salad = (Spinner) findViewById(R.id.Rsalad);
    //    drink = (Spinner) findViewById(R.id.Rdrink);
        submit = (ImageButton) findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                Toast.makeText(FCRegister.this,
                        "Result : " +
                                "\nAppetizer : " + String.valueOf(appe.getSelectedItem()) +
                                "\nFish Dish : " + String.valueOf(fish.getSelectedItem()) +
                                "\nMeat Dish : " + String.valueOf(meat.getSelectedItem()) +
                                "\nMain Dish : " + String.valueOf(main.getSelectedItem()) +
                                "\nSalad : " + String.valueOf(salad.getSelectedItem())+
                                "\nDessert : " + String.valueOf(dessert.getSelectedItem())        ,
                        Toast.LENGTH_SHORT).show();

         //       connectServer.addValue("fullName",change.getText().toString());
         //       connectServer.addValue("User",getUserName);
         //       connectServer.addValue("Main",String.valueOf(main.getSelectedItem()));
         //       connectServer.addValue("Dessert",String.valueOf(dessert.getSelectedItem()));
        //        connectServer.addValue("Fish",String.valueOf(fish.getSelectedItem()));
         //       connectServer.addValue("Salad",String.valueOf(salad.getSelectedItem()));
         //       connectServer.addValue("Meat",String.valueOf(meat.getSelectedItem()));
        //       connectServer.addValue("Appetize",String.valueOf(appe.getSelectedItem()));


            }

        });
    }

    ///ถ้าไม่สามารถเชื่อมต่อกับ Server ได้จะมาทำงานที่ Function นี้
    public void cannotConnectToServer() {
        Toast.makeText(this, "ไม่สามารถเชื่อมต่อกับ Server", Toast.LENGTH_LONG).show();
    }

    //ถ้าดึงข้อมูลจาก Server มีปัญหา จะมาทำงานที่ Function นี้
    public void errorConnectToServer() {
        //    Toast.makeText(this, "ไม่พบข้อมูลที่ค้นหา", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "login fail", Toast.LENGTH_LONG).show();

    }

    public void getApp(ArrayList<String> name)
    {
        String test;
        Context context = getApplicationContext();
        listApp = name;
        addItemsOnSpinner2App(listApp);
    //    test= String.valueOf(listName.get(0));
     //   Toast.makeText(this, test, Toast.LENGTH_LONG).show();

    }

    public void getMain(ArrayList<String> name)
    {
        String test;
        Context context = getApplicationContext();
        listMain = name;
     //   String main = "main";

        addItemsOnSpinner2Main(listMain);

    //      test= String.valueOf(listMain.get(0));
    //      Toast.makeText(this, test, Toast.LENGTH_LONG).show();

    }

    public void getMeat(ArrayList<String> name)
    {
        String test;
        Context context = getApplicationContext();
        listMeat = name;
        addItemsOnSpinner2Meat(listMeat);
        //    test= String.valueOf(listName.get(0));
        //   Toast.makeText(this, test, Toast.LENGTH_LONG).show();

    }

    public void getSalad(ArrayList<String> name)
    {
        String test;
        Context context = getApplicationContext();
        listSalad = name;
        addItemsOnSpinner2Salad(listSalad);
        //    test= String.valueOf(listName.get(0));
        //   Toast.makeText(this, test, Toast.LENGTH_LONG).show();

    }

    public void getDessert(ArrayList<String> name)
    {
        String test;
        Context context = getApplicationContext();
        listDessert = name;
        addItemsOnSpinner2Dessert(listDessert);
        //    test= String.valueOf(listName.get(0));
        //   Toast.makeText(this, test, Toast.LENGTH_LONG).show();

    }

    public void getFish(ArrayList<String> name)
    {
        String test;
        Context context = getApplicationContext();
        listFish = name;
        addItemsOnSpinner2Fish(listFish);
        //    test= String.valueOf(listName.get(0));
        //   Toast.makeText(this, test, Toast.LENGTH_LONG).show();

    }
}