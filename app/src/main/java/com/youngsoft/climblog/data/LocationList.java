package com.youngsoft.climblog.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LocationList_Table")
public class LocationList {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String locationName;
    private int climbCount;
    private double gpsLongitude;
    private double gpsLatitude;
    private boolean isGps;
    private boolean isOutdoor;

    public LocationList(String locationName, int climbCount, double gpsLongitude, double gpsLatitude, boolean isGps, boolean isOutdoor) {
        this.locationName = locationName;
        this.climbCount = climbCount;
        this.gpsLongitude = gpsLongitude;
        this.gpsLatitude = gpsLatitude;
        this.isGps = isGps;
        this.isOutdoor = isOutdoor;
    }

    public static LocationList[] populateLocationListData() {
        return new LocationList[]{
                new LocationList("None", 0, 0,0, false, true),
                new LocationList("None", 0, 0,0, false, false),
                new LocationList("Frankenjura", 1, 49.0200132,10.7512452, true, true),
                new LocationList("Flatanger", 1, 64.4568316,10.7566342, true, true),
                new LocationList("Arco", 0, 45.9186038,10.8626971, true, true),
                new LocationList("Domusnovas", 1, 0, 0, false, true),
                new LocationList("Villanueva del Rosario", 1, 0, 0, false, true),
                new LocationList("Oliana", 1, 0, 0, false, true),
                new LocationList("Stanage", 1, 53.347304,-1.6420158, true, true),
                new LocationList("Siurana", 1, 41.258055,0.9301405, true, true),
                new LocationList("La Cova de l'Ocell", 1, 41.7466596,2.1916766, true, true),
                new LocationList("Margalef", 1, 41.2850023, 0.7518995, true,true),
                new LocationList("Crux", 0, 52.2251713,21.0075133, true,false),
        };
    }

    public int getId() {
        return id;
    }
    public String getLocationName() {
        return locationName;
    }
    public int getClimbCount() {
        return climbCount;
    }
    public double getGpsLongitude() {
        return gpsLongitude;
    }
    public double getGpsLatitude() {
        return gpsLatitude;
    }
    public boolean getIsGps() {
        return isGps;
    }
    public boolean getIsOutdoor() {
        return isOutdoor;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLocationName(String input) {
        locationName = input;
    }
    public void setClimbCount(int input) {
        climbCount = input;
    }
    public void setGpsLongitude(double input) {
        gpsLongitude = input;
    }
    public void setGpsLatitude(double input) {
        gpsLatitude = input;
    }
    public void setIsGps(boolean input) {
        isGps = input;
    }
    public void setIsOutdoor(boolean outdoor) {
        isOutdoor = outdoor;
    }

}
