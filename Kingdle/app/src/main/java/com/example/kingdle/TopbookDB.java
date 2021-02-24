package com.example.kingdle;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TopbookTable.class}, version = 1, exportSchema = false)
public abstract class TopbookDB extends RoomDatabase  {

    public abstract TopbookDao TopbookDao();

    private static volatile TopbookDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TopbookDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TopbookDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TopbookDB.class, "topbook_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
