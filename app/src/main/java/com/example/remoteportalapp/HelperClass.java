package com.example.remoteportalapp;

import android.icu.text.SimpleDateFormat;
import android.view.Gravity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import java.util.Date;

public class HelperClass {

    private static Date date = new Date();


    public static String getCurrentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        String strDate = formatter.format(date);
        return  strDate;
    }

    public static String getCurrentDate(){
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm");
        String strTime =  formatterTime.format(date);
        return strTime;
    }

    public static void handleMenuSlide(FragmentActivity fragmentActivity){
        final DrawerLayout drawer  = (DrawerLayout) fragmentActivity.findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(Gravity.LEFT)) {
            System.out.print("okay");
            //drawer.closeDrawer(Gravity.LEFT);
        }else{
            drawer.openDrawer(GravityCompat.START);
        }

    }
}
