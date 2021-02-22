package com.example.kingdle;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
/***********************************
 Component: Room Database
 Author: Yukan Zhang
 Functionality:DAO interface
               access local database
 ***********************************/
@Dao
public interface ServiceDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ServiceTable stable);

    @Query("DELETE FROM service_table")
    void deleteAll();

    @Query("SELECT last_read FROM service_table WHERE id=(SELECT max(id) FROM service_table)")
    int getLastReadDuration();
}
