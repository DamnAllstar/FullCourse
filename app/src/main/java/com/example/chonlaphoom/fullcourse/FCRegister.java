package com.example.chonlaphoom.fullcourse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amin on 4/26/2015.
 */
public class FCRegister extends ActionBarActivity {

    private Spinner appe, soup , fish,meat,main,salad,dessert,drink;
    private Button submit;
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

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("Ice Cream");
        list.add("Honey Toast");
        list.add("Berry Cake");
        list.add("Tokyo Banana");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
    //

    //รั บ Listener ของอั นที่  ไม่ ใช่ dynamic
    public void addListenerOnSpinnerItemSelection() {
        appe = (Spinner) findViewById(R.id.spinner1);
        appe.setOnItemSelectedListener(new DropDownList());

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(new DropDownList());

        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner4.setOnItemSelectedListener(new DropDownList());

        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner5.setOnItemSelectedListener(new DropDownList());

        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner6.setOnItemSelectedListener(new DropDownList());
    }

    public void addListenerOnButton() {

        appe = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(FCRegister.this,
                        "Result : " +
                                "\nAppetizer : " + String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()) +
                                "\nSpinner 3 : " + String.valueOf(spinner3.getSelectedItem()) +
                                "\nSpinner 4 : " + String.valueOf(spinner4.getSelectedItem()) +
                                "\nSpinner 5 : " + String.valueOf(spinner5.getSelectedItem()) +
                                "\nSpinner 6 : " + String.valueOf(spinner6.getSelectedItem()),
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