package com.youngsoft.climblog.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AscentType_Table")
public class AscentType {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String ascentName;
    private String description;

    public AscentType(String ascentName, String description) {
        this.ascentName = ascentName;
        this.description = description;
    }

    public static AscentType[] populateAscentTypeData() {
        return new AscentType[]{
                new AscentType("On-Sight", "A clean ascent, with no prior practice or beta."),
                new AscentType("Flash", "Led the route, without falling or resting, on the first attempt, but used prior inspection and/or beta."),
                new AscentType("Redpoint", "Led the route, without falling or resting, but not on the first attempt."),
                new AscentType("Pinkpoint", "Led a sport route, without falling or resting, but not on the first attempt, using pre-placed gear."),
                new AscentType("Headpoint", "The practice of top-roping a hard trad route before leading it cleanly."),
                new AscentType("Hang Dog", "Led the route, but rested on gear or fell on the way up."),
                new AscentType("Attempt", "Incomplete attempt at a route.")
        };
    }

    public int getId() {
        return id;
    }
    public String getAscentName() {
        return ascentName;
    }
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }



}
