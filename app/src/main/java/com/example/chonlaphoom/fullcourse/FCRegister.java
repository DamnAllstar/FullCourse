package com.example.chonlaphoom.fullcourse;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amin on 4/26/2015.
 */
public class FCRegister extends ActionBarActivity {

    private Spinner appe, soup , fish,meat,main,salad,dessert,drink;
    private ImageButton submit;

    
    ArrayList<String> listName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fc_register);


        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }

    // add array แบบ dynamic
    public void addItemsOnSpinner2() {

        soup = (Spinner) findViewById(R.id.Rsoup);
        List<String> list = new ArrayList<String>();
        list.add("Ice Cream");
        list.add("Honey Toast");
        list.add("Berry Cake");
        list.add("Tokyo Banana");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soup.setAdapter(dataAdapter);
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

        drink = (Spinner) findViewById(R.id.Rdrink);
        drink.setOnItemSelectedListener(new DropDownList());

    }

    public void addListenerOnButton() {

        appe = (Spinner) findViewById(R.id.Rappe);
        soup = (Spinner) findViewById(R.id.Rsoup);
        fish = (Spinner) findViewById(R.id.Rfish);
        meat = (Spinner) findViewById(R.id.Rmeat);
        main = (Spinner) findViewById(R.id.Rmain);
        dessert = (Spinner) findViewById(R.id.Rdessert);
        salad = (Spinner) findViewById(R.id.Rsalad);
        drink = (Spinner) findViewById(R.id.Rdrink);
        submit = (ImageButton) findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(FCRegister.this,
                        "Result : " +
                                "\nAppetizer : " + String.valueOf(appe.getSelectedItem()) +
                                "\nSoup : " + String.valueOf(soup.getSelectedItem()) +
                                "\nFish Dish : " + String.valueOf(fish.getSelectedItem()) +
                                "\nMeat Dish : " + String.valueOf(meat.getSelectedItem()) +
                                "\nMain Dish : " + String.valueOf(main.getSelectedItem()) +
                                "\nSalad : " + String.valueOf(salad.getSelectedItem())+
                                "\nDessert : " + String.valueOf(dessert.getSelectedItem())+
                                "\nDrink : " + String.valueOf(drink.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
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

    public void getName(ArrayList<String> name)
    {
        Context context = getApplicationContext();
        listName = name;

    }
}