package com.olehmesh.nyt_tasktest.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.olehmesh.nyt_tasktest.models.EntityDatabase;

import java.util.List;

@Dao
public interface DaoMethods {

    @Query("SELECT * FROM EntityDatabase")
    List<EntityDatabase> getAll();

    @Insert
    void insert(EntityDatabase entityDatabase);

    @Delete
    void delete(EntityDatabase entityDatabase);

}
