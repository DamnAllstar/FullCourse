package com.example.chonlaphoom.fullcourse;

import android.widget.ImageView;

/**
 * Created by amin on 4/23/2015.
 */
public class NFItemlist {


    private String itemTitle;
    private int flag;

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }


    public NFItemlist(String title , int flag){
        this.itemTitle = title;
        this.flag = flag;
    }
}