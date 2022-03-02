package com.example.senddata.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.senddata.model.ApiResults;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserEntity userEntity);

    @Query("SELECT DISTINCT * FROM table_name")
    LiveData<UserEntity> getAll();

    @Query("DELETE FROM table_name")
    void deleteAll();

    @Query("SELECT COUNT(userId) FROM table_name")
    LiveData<Integer> getCount();
}
