package com.youngsoft.climblog.data;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

@Database(entities = {AscentType.class, ClimbLog.class, GradeValue.class, GradeType.class, LocationList.class, ClimbDiscipline.class}, version = 1, exportSchema = false)
public abstract class DataDatabase extends RoomDatabase {

    private static DataDatabase instance;

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //Log.i("Callback","running async task");
            //new PopulateDbAsyncTask(instance).execute();

            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    instance.dataDao().insertMultipleAscentType(AscentType.populateAscentTypeData());
                    instance.dataDao().insertMultipleGradeType(GradeType.populateGradeTypeData());
                    instance.dataDao().insertMultipleGradeValue(GradeValue.populateGradeValueData());
                    instance.dataDao().insertMultipleClimbDiscipline(ClimbDiscipline.populateClimbDisciplineData());
                    instance.dataDao().insertMultipleLocationList(LocationList.populateLocationListData());
                    instance.dataDao().insertMultipleClimbLog(ClimbLog.populateClimbLogData());
                }
            });
        }
    };

    public static synchronized DataDatabase getInstance(Context context) {
        if (instance == null) {
            Log.i("DataDatabase", "In constructor, instance = null");
            //Populate database on first creation
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DataDatabase.class, "dataDatabase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    public abstract DataDAO dataDao();


}
