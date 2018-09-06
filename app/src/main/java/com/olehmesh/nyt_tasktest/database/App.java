package com.olehmesh.nyt_tasktest.database;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

    public static App instance;

    private DatabaseManager database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, DatabaseManager.class, "database_news")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public DatabaseManager getDatabase() {
        return database;
    }
}
