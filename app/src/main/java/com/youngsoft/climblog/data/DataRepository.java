package com.youngsoft.climblog.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DataRepository {

    private final String TAG = "DataRepository";
    private DataDAO dataDao;

    private LiveData<List<ClimbLog>> allClimbLogsSortedByDate;

    public DataRepository(Application application) {
        DataDatabase dataDatabase = DataDatabase.getInstance(application);
        dataDao = dataDatabase.dataDao();
        allClimbLogsSortedByDate = dataDao.getAllClimbLogsSortByDate();
    }

    public LiveData<List<ClimbLog>> getAllClimbLogsSortByDate() {
        return allClimbLogsSortedByDate;
    }

}
