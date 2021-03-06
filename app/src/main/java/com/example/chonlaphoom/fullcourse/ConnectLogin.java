package com.example.chonlaphoom.fullcourse;


/**
 * Created by nuttnarok on 4/10/2015.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class ConnectLogin extends AsyncTask<String, Integer, String> {
    private HttpPost httppost;
    private HttpClient httpclient;
    private List<NameValuePair> nameValuePairs;
    private DialogConnect dialogConnect;
    private Context context;

    public String  get;
    public ArrayList<String> email = new ArrayList<String>();
    public ArrayList<String> name = new ArrayList<String>();

    ConnectLogin(Context context,String URL){
        this.context = context;

        //สร้างส่วนประกอบที่จำเป็นในการเชื่อมกับ Server
        this.httpclient = new DefaultHttpClient();
        this.httppost = new HttpPost(URL);
        this.nameValuePairs = new ArrayList<NameValuePair>();

        //สร้าง Dialog ตอนเชื่อมต่อกับ Server
        //มีการส่ง ConnectServer ให้กับ Dialog เพื่อใช้ในการยกเลิก
        dialogConnect = new DialogConnect(this.context, this);
        dialogConnect.setTitle(this.context.getString(R.string.app_name));
        dialogConnect.setMessage("กรุณารอสักครู่");
    }

    //Function สำหรับเพิ่มตัวแปรในการส่งค่าแบบ Post
    public void addValue(String key, String value){

        nameValuePairs.add(new BasicNameValuePair(key, value));
    }

    //ก่อนที่จะทำ doInBackground จะทำงานที่ Function นี้ก่อน
    protected void onPreExecute() {
        dialogConnect.show();
    }

    //เริ่มทำงานแบบ Background
    protected String doInBackground(String... params) {
        InputStream is = null;
        String result = null;
        get="doInBack";
        //เริ่มการเชื่อมต่กับ Server
        try {
            //ทำการส่งตัวแปรต่างๆ ในรูปแบบของ UTF-8
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,HTTP.UTF_8));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

            //อ่านผลลัพธ์ในรูปแบบของ UTF-8
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            is.close();
            result = sb.toString();



            //ถ้าขณะเชื่อมต่อกับ Server มีปัญหา จะแสดง Log Error
        } catch (ClientProtocolException e) {
            Log.e("ConnectServer", e.toString());
        } catch (IOException e) {
            Log.e("ConnectServer", e.toString());
        }

        return result;
        // return new JSONObject(json.substring(json.indexOf("{"), json.lastIndexOf("}") + 1));
    }

    //ถ้าทำงานที่ doInBackground เสร็จแล้ว จะมาทำงานที่ Function นี้
    protected void onPostExecute(String result) {
        //list ที่ใช้เก็บข้อมูล



        //ถ้า result เป็น null คือ ไม่สามารถเชื่อมต่อกับ server ได้
        //ถ้าเชื่อมต่กับ server ได้ จะทำงานต่อไปนี้
        if(result != null){
            //เริ่มการแปลง JSON เป็นข้อมูล
            try {
                //แปลงผลลัพธ์ที่ได้มาเป็น JSON Object
                JSONObject jObject = new JSONObject(result);


                //ถ้าถึงข้อมูลจาก database ได้จะมีผลลัพธ์ status กลับมาว่า OK
                if(jObject.getString("status").equals("OK")){
                    //แปลงผลลัพธ์ที่ได้มาเป็น JSON Array
                    JSONArray jResult = jObject.getJSONArray("result");
                    get = "OK";
                 //   email.add("OK");

                    //ดึงขนาดของข้อมูลใน jResult
                    int size = jResult.length();

                    //วน Loop เอาค่าใส่ใน List
                    for(int i=0;i<size;i++){

                        String data1 = jResult.getJSONObject(i).getString("email");
                        //String random  = jResult.getJSONObject(i).getString("F_id");
                        String data2  = jResult.getJSONObject(i).getString("name");

                        email.add(data1);
                        name.add(data2);

                    }

                    //ถ้าดึงข้อมูลจาก database มีปัญหาจะแสดง error
                }else{

                    ((MainActivity)context).errorConnectToServer();
                }
                ((MainActivity)context).setList(email,name);


                //ถ้าขณะแปลงข้อมูล JSON มีปัญหาจะมาทำงานส่วนนี้
            } catch (JSONException e) {
                Log.e("ConnectServer", "Error parsing data " + e.toString() + "/" + result);

                ((MainActivity)context).errorConnectToServer();
            }

            //ถ้าเชื่อมต่อกับ server ไม่ได้จะทำงานต่อไปนี้
        }else{
            ((MainActivity)context).cannotConnectToServer();
        }

        dialogConnect.dismiss();
    }

    public String returnValue()
    {
        return get;


    }
}