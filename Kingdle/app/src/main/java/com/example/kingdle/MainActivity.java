package com.example.kingdle;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.IBinder;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{
    private NavController navController;

    /*
    Author: Yukan Zhang
    Timer connection
    */
    TimerService timer;
    boolean bound;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TimerService.TimerBinder TimerBinder = (TimerService.TimerBinder) iBinder;
            timer = TimerBinder.getTime();
            timer.runTimer1();
            timer.notify = true;
            timer.running = true;
            bound = true;
            Log.v("Main","GetBinder");
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            timer.running = false;
            timer.notify = false;
            bound = false;
           // Log.v("Main","unBinder");
        }
    };

    /*
    Timer connection end
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(navView, this.navController);
        NavigationUI.setupActionBarWithNavController(this, this.navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity", "on Destory");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MainActivity", "on Resume");

        /*
        Author: Yukan Zhang
        Timer connection
        */
        if(bound) {
            unbindService(connection);
            timer.running = false;
            timer.seconds1 = 0;
            timer.notify = false;
            bound = false;
        }


        /*
        Timer connection end
        */
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MainActivity", "on Pause");

        /*
        Author: Yukan Zhang
        Timer connection
        */
        if(!bound) {
            Intent intent = new Intent(this, TimerService.class);
            bindService(intent, connection, Context.BIND_AUTO_CREATE);
        }


        /*
        Timer connection end
        */

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity", "on Stop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", "on Destory");

        /*
        Author: Yukan Zhang
        Timer connection
        */
        if(bound) {
            unbindService(connection);
            timer.running = false;
            bound = false;
        }
        /*
        Timer connection end
        */
    }
}