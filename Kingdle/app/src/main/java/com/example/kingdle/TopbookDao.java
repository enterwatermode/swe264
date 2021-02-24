
package com.example.kingdle;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TopbookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TopbookTable t);

    @Query("SELECT * FROM Topbook_table")
    List<TopbookTable> getAll();
}

