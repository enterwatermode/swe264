package com.example.kingdle;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
/***********************************
 Component: Room Database
 Author: Yukan Zhang
 Functionality: table creation
                store data collected by TimerService
 ***********************************/
@Entity(tableName = "service_table")
public class ServiceTable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "last_read")
    public int last_read;
}
