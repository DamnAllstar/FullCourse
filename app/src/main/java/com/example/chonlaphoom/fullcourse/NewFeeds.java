package com.example.chonlaphoom.fullcourse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class NewFeeds extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks ,NewsFeed.OnFragmentInteractionListener,FCFragment.OnFragmentInteractionListener{
    ArrayList<String> list;
    ArrayList<Integer> fullcourse_id;
    String get;
    String getUser;
    ArrayAdapter arrayAdapter;
    ListView listView;

    ConnectGetResName connectServer;

    MainActivity mainActivity = new MainActivity();
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feeds);


        Intent intent = new Intent();
        intent = getIntent();
        getUser =  intent.getStringExtra("user");
        Toast.makeText(this,"Welcome back "+getUser, Toast.LENGTH_LONG).show();

        //connectServer = new ConnectGetResName(NewFeeds.this, "http://naneport.arg.in.th/eatwell/full/getRestau.php");
        //connectServer.execute();

        mNavigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        //mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        Fragment objFragment = null;


        //Bundle bundle = new Bundle();
        switch(position){
            case 0:
                //objFragment = new newfeeds_Fragment();
                //mTitle="Home";
                connectServer = new ConnectGetResName(NewFeeds.this, "http://naneport.arg.in.th/eatwell/full/getRestau.php");
                connectServer.setCase(position);
                connectServer.execute();
                break;
            case 1:
                /*
                objFragment = new menu1_Fragment();
                mTitle="My FullCourses";
                */
                connectServer = new ConnectGetResName(NewFeeds.this, "http://naneport.arg.in.th/eatwell/full/getRestau.php");
                connectServer.setCase(position);
                connectServer.execute();
                break;
            case 2:
                /*
                objFragment = new menu2_Fragment();
                mTitle="My Favorites";*/
                connectServer = new ConnectGetResName(NewFeeds.this, "http://naneport.arg.in.th/eatwell/full/getRestau.php");
                connectServer.setCase(position);
                connectServer.execute();
                break;
            case 3:
                /*
                objFragment = new menu3_Fragment();
                mTitle="Subscribe";*/
                connectServer = new ConnectGetResName(NewFeeds.this, "http://naneport.arg.in.th/eatwell/full/getRestau.php");
                connectServer.setCase(position);
                connectServer.execute();
                break;
            case 4:
                /*objFragment = new menu4_Fragment();
                mTitle="Logout";*/
                connectServer = new ConnectGetResName(NewFeeds.this, "http://naneport.arg.in.th/eatwell/full/getRestau.php");
                connectServer.setCase(position);
                connectServer.execute();
                break;
        }
        // update the main content by replacing fragments
        /*
        objFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.container, objFragment)
                .commit();
                */
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section0);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section1);
                break;
            case 4:
                mTitle = getString(R.string.title_section3);
                break;
            case 5:
                mTitle = getString(R.string.title_section4);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.new_feeds, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public void onFragmentInteraction(String id) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
   /* public static class PlaceholderFragment extends Fragment {
        //
         // The fragment argument representing the section number for this
         // fragment.
         //
        private static final String ARG_SECTION_NUMBER = "section_number";

        //
         // Returns a new instance of this fragment for the given section
         // number.
         //
        public static PlaceholderFragment newInstance(int sectionNumber) {
            Log.d("debug","PlaceholderFragment");
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d("debug","Placeholder.onCreateView");
            View rootView = inflater.inflate(R.layout.fragment_new_feeds, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            Log.d("debug","Placeholder.onAttach");
            super.onAttach(activity);
            ((NewFeeds) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
    */

    ///ถ้าไม่สามารถเชื่อมต่อกับ Server ได้จะมาทำงานที่ Function นี้
    public void cannotConnectToServer() {
        Toast.makeText(this, "ไม่สามารถเชื่อมต่อกับ Server", Toast.LENGTH_LONG).show();
    }

    //ถ้าดึงข้อมูลจาก Server มีปัญหา จะมาทำงานที่ Function นี้
    public void errorConnectToServer() {
            Toast.makeText(this, "ไม่พบข้อมูลที่ค้นหา", Toast.LENGTH_LONG).show();
       // Toast.makeText(this, "login fail", Toast.LENGTH_LONG).show();

    }


    public void getRes(ArrayList<String> name , int switch_case , ArrayList<Integer> fullcourse_id){

        Fragment objFragment = null;
        Context context = getApplicationContext();
        list = name;
        this.fullcourse_id = fullcourse_id;

        Bundle bundle = new Bundle();
        bundle.putStringArrayList("popular", list);
        bundle.putIntegerArrayList("fullcourse_id",this.fullcourse_id);

        switch (switch_case) {
            case 0:
                objFragment = new newfeeds_Fragment();
                mTitle = "Home";

                break;
            case 1:
                Log.d("test", "case 1");
                objFragment = new menu1_Fragment();
                mTitle = "My FullCourses";

                break;
            case 2:
                objFragment = new menu2_Fragment();
                mTitle = "My Favorites";
                break;
            case 3:
                objFragment = new menu3_Fragment();
                mTitle = "Subscribe";
                break;
            case 4:
                objFragment = new menu4_Fragment();
                mTitle = "Logout";
                break;
        }

        objFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.container, objFragment)
                .commit();
        //get = String.valueOf(list.get(0));
        //Toast.makeText(this, get, Toast.LENGTH_LONG).show();

        //arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
    }

}
