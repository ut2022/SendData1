package com.example.senddata.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.senddata.model.ApiResults;

public class UserRepository {

    public UserDao userDao;
    public LiveData<UserEntity> getAllPosts;
    public LiveData<Integer> getCount;

    public UserRepository(Application application){
        userDao= UserDatabase.userDao();
        getAllPosts=userDao.getAll();
        getCount = userDao.getCount();
    }
    public LiveData<UserEntity> getAllPosts(){
        return getAllPosts;
    }

    public void insert(UserEntity userEntity) {
        new insertAsyncTask(userDao).execute(userEntity);
    }

    private static class insertAsyncTask extends AsyncTask <UserEntity,Void,Void> {
        private UserDao PostuserDao;

        public insertAsyncTask(UserDao userDao) {
            this.PostuserDao = userDao;
        }

        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            PostuserDao.insert(userEntities[0]);
            return null;
        }
    }
    public LiveData<Integer> getCount() {
        return getCount;
    }
}
