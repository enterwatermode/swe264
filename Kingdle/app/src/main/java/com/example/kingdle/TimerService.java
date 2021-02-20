package com.example.kingdle;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class TimerService extends Service {
    private  final IBinder binder = new TimerBinder();
    private Handler handler = new Handler();

    public int seconds1 = 0;
    public boolean running = false;

    public boolean notify = false;
    public final int LIMIT = 5;
    public static final int NOTIFICAION_ID = 5321;

    public TimerService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    public class  TimerBinder extends Binder {
        TimerService getTime(){
            return TimerService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("service","on Create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        seconds1 = 0;
        //running = false;
        Log.v("service","on Destroy");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notification(){
        if(seconds1 == LIMIT && notify == true) {

            Log.v("mock_notification", "see you again");
            NotificationManager notificationManager = (NotificationManager) this.getSystemService(this.NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder = null;

            NotificationChannel notificationChannel = new NotificationChannel("NOTIFICATION_CHANNEL_ID", "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
            //int importance = NotificationManager.IMPORTANCE_DEFAULT;
            //NotificationChannel notificationChannel = new NotificationChannel("ID", "Name", importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(getApplicationContext(), notificationChannel.getId());

            builder = builder
                    .setSmallIcon(R.drawable.ic_book_foreground)
                    .setContentTitle("You spent " + readTimer() + " last time")
                    .setContentText("Wish to see you again!")
                    .setVibrate(new long[]{0, 1000})
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true);
            notificationManager.notify(NOTIFICAION_ID, builder.build());
        }
    }

    public void runTimer1(){
        handler.post(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void run() {
                if((running)){
                    seconds1 ++;
                    Log.v("count", String.valueOf(seconds1));
                }
                handler.postDelayed(this, 1000);
                notification();

            }
        });
    }

    public String readTimer(){
        int hours = 0 ;
        int minutes = 0 ;
        int secs = 0 ;
        hours = TimerControl.last_read/3600;
        minutes = ( TimerControl.last_read%3600)/60;
        secs =  TimerControl.last_read%60;

        return String.valueOf(hours) + ":"+ String.valueOf(minutes)+":"+String.valueOf(secs);
    }

}