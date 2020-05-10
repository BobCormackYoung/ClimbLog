package com.youngsoft.climblog.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDAO {

    // Inserting multiple items for each type
    @Insert
    void insertMultipleGradeValue(GradeValue... gradeValues);

    @Insert
    void insertMultipleAscentType(AscentType... ascentTypes);

    @Insert
    void insertMultipleGradeType(GradeType... gradeTypes);

    @Insert
    void insertMultipleClimbDiscipline(ClimbDiscipline... climbDisciplines);

    @Insert
    void insertMultipleLocationList(LocationList... locationLists);

    @Insert
    void insertMultipleClimbLog(ClimbLog... climbLogs);

    @Insert
    void insertSingleClimbLog(ClimbLog... climbLog);

    @Insert
    void insertNewLocation(LocationList locationList);

    @Query("SELECT * FROM ClimbLog_Table ORDER BY date DESC")
    LiveData<List<ClimbLog>> getAllClimbLogsSortByDate();
}
