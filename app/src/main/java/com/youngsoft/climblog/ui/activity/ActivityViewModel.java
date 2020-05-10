package com.youngsoft.climblog.ui.activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.youngsoft.climblog.data.ClimbLog;
import com.youngsoft.climblog.data.DataRepository;

import java.util.List;

public class ActivityViewModel extends AndroidViewModel {

    private DataRepository dataRepository;
    private LiveData<List<ClimbLog>> allClimbLogsSortedByDate;

    public ActivityViewModel(@NonNull Application application) {
        super(application);
        dataRepository = new DataRepository(application);

        allClimbLogsSortedByDate = dataRepository.getAllClimbLogsSortByDate();
    }

    public LiveData<List<ClimbLog>> getAllClimbLogsSortedByDate() {
        return allClimbLogsSortedByDate;
    }
}