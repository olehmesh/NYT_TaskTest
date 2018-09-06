package com.olehmesh.nyt_tasktest.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.olehmesh.nyt_tasktest.models.EntityDatabase;


@Database(entities = {EntityDatabase.class}, version = 1, exportSchema = false)

public abstract class DatabaseManager extends RoomDatabase {

    public abstract DaoMethods daoMethods();

}

