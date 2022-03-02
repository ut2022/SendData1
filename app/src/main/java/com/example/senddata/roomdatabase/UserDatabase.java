package com.example.senddata.roomdatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {UserEntity.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String dbName="user";

    public static UserDao userDao() {
        return null;
    }

    public static volatile UserDatabase INSTANCE = null;

    public static UserDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (UserDatabase.class){
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, UserDatabase.class, dbName)
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
    }
        return INSTANCE;
    }


    public static Callback callback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyn(INSTANCE);
        }
    };
    static  class  PopulateDbAsyn extends AsyncTask<Void,Void,Void> {
        private UserDao userDao;
        public PopulateDbAsyn(UserDatabase userDatabase)
        {
            userDao=userDatabase.userDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.deleteAll();
            return null;
        }
    }
}
