package com.example.kingdle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import android.widget.Toast;
/***************************************
 Component: Broadcast Receiver
 Author: Yukan Zhang
 Functionality: Low battery and no internet broadcast receiver
 Show Taast when battery is low or no internet connection
 * Stop the user downloading information from API
 * ***************************************/
public class ConnectivityControl extends BroadcastReceiver {
    float previous;
    @Override
    public void onReceive(Context context, Intent intent) {
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean noConn = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if(noConn) Toast.makeText(context,"NO INTERNET CONNECTION! Please check you internet connection!",Toast.LENGTH_SHORT).show();
            else Toast.makeText(context,"Welcome to Kingdle!",Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction().equals(intent.ACTION_BATTERY_CHANGED)){
            int level =intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            float batteryPct = level * 100 / (float)scale;

            if(batteryPct == 21.0) previous = 21;
            if(batteryPct == 19.0) previous = 19;

            if(batteryPct == 20.0 && previous == 21 ) {
                Toast.makeText(context,"LOW BATTERY! You cannot search online API",Toast.LENGTH_SHORT).show();
                previous = 0;
            }
            else if(batteryPct == 20.0 && previous == 19) {
                Toast.makeText(context,"ONLINE SEARCH BACK!", Toast.LENGTH_SHORT).show();
                previous = 0;
            }
        }
    }
}
