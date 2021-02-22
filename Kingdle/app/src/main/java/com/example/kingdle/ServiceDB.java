package com.example.kingdle;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/***********************************
 Component: Room Database
 Author: Yukan Zhang
 Functionality: Local service database
                store data collected for TimerService
 ***********************************/
@Database(entities = {ServiceTable.class}, version = 1, exportSchema = false)
public abstract class ServiceDB extends RoomDatabase  {

    public abstract ServiceDao serviceDao();

    private static volatile ServiceDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ServiceDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ServiceDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ServiceDB.class, "service_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}