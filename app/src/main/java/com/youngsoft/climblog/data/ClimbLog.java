package com.youngsoft.climblog.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity(tableName = "ClimbLog_Table")
public class ClimbLog {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private long date;
    private String name;
    private int gradeTypeCode;
    private int gradeValueCode;
    private int ascentTypeCode;
    private int location;
    private boolean firstAscentCode;
    private boolean isOutdoorClimbCode;
    private int climbDisciplineCode;
    private int numberOfAttempts;
    private boolean isMultiPitch;
    private int pitchCount;

    public ClimbLog(long date, String name, int gradeTypeCode, int gradeValueCode, int ascentTypeCode, int location, boolean firstAscentCode, boolean isOutdoorClimbCode, int climbDisciplineCode, int numberOfAttempts, boolean isMultiPitch, int pitchCount) {
        this.date = date;
        this.name = name;
        this.gradeTypeCode = gradeTypeCode;
        this.gradeValueCode = gradeValueCode;
        this.ascentTypeCode = ascentTypeCode;
        this.location = location;
        this.firstAscentCode = firstAscentCode;
        this.isOutdoorClimbCode = isOutdoorClimbCode;
        this.climbDisciplineCode = climbDisciplineCode;
        this.numberOfAttempts = numberOfAttempts;
        this.isMultiPitch = isMultiPitch;
        this.pitchCount = pitchCount;
    }

    public static ClimbLog[] populateClimbLogData() {
        long tempDate = Calendar.getInstance().getTimeInMillis();
        return new ClimbLog[]{
                new ClimbLog(tempDate - 2 * (24 * 60 * 60000), "Action Directe", 1, 1, 1, 3, true, true, 1, 1, false, 1),
                new ClimbLog(tempDate - 2 * (24 * 60 * 60000), "Silence", 1, 1, 1, 4, true, true, 2, 1, false, 1),
                new ClimbLog(tempDate - 1 * (24 * 60 * 60000), "Marina Superstar", 1, 1, 1, 5, true, true, 3, 1, false, 1),
                new ClimbLog(tempDate - 1 * (24 * 60 * 60000), "La Planta de Shiva", 1, 1, 1, 6, true, true, 1, 1, false, 1),
                new ClimbLog(tempDate - 0 * (24 * 60 * 60000), "La Dura Dura", 1, 1, 1, 8, true, true, 2, 1, false, 1),
                new ClimbLog(tempDate - 0 * (24 * 60 * 60000), "Brad Pitt", 1, 1, 1, 9, true, true,3, 1, false, 1),
                new ClimbLog(tempDate + 1 * (24 * 60 * 60000), "Golpe de Estado", 1, 1, 1, 10, true, true, 1, 1, false, 1),
                new ClimbLog(tempDate + 1 * (24 * 60 * 60000), "El Bon Combat", 1, 1, 1, 11, true, true,2, 1, false, 1),
                new ClimbLog(tempDate + 2 * (24 * 60 * 60000), "First Round First Minute", 1, 1, 1, 10, true, true, 3, 1, false, 1)
        };
    }

    public int getId() {
        return id;
    }
    public long getDate() {
        return date;
    }
    public String getName() {
        return name;
    }
    public int getGradeTypeCode() {
        return gradeTypeCode;
    }
    public int getGradeValueCode() {
        return gradeValueCode;
    }
    public int getAscentTypeCode() {
        return ascentTypeCode;
    }
    public int getLocation() {
        return location;
    }
    public boolean getFirstAscentCode() {
        return firstAscentCode;
    }
    public boolean getIsOutdoorClimbCode() {
        return isOutdoorClimbCode;
    }
    public int getClimbDisciplineCode() { return climbDisciplineCode; }
    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
    public boolean getIsMultiPitch() {
        return isMultiPitch;
    }
    public int getPitchCount() {
        return pitchCount;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDate(long input) {
        date = input;
    }
    public void setName(String input) {
        name = input;
    }
    public void setGradeTypeCode(int input) {
        gradeTypeCode = input;
    }
    public void setGradeValueCode(int input) {
        gradeValueCode = input;
    }
    public void setAscentTypeCode(int input) {
        ascentTypeCode = input;
    }
    public void setLocation(int input) {
        location = input;
    }
    public void setFirstAscentCode(boolean input) {
        firstAscentCode = input;
    }
    public void setOutdoorClimbCode(boolean input) {
        isOutdoorClimbCode = input;
    }
    public void setClimbDisciplineCode(int input) {
        climbDisciplineCode = input;
    }
    public void setNumberOfAttempts(int input) {
        numberOfAttempts = input;
    }
    public void setMultiPitch(boolean multiPitch) {
        isMultiPitch = multiPitch;
    }
    public void setPitchCount(int pitchCount) {
        this.pitchCount = pitchCount;
    }
}
