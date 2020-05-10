package com.youngsoft.climblog.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ClimbDiscipline_Table")
public class ClimbDiscipline {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String climbDisciplineName;
    private String description;

    public ClimbDiscipline(String climbDisciplineName, String description) {
        this.climbDisciplineName = climbDisciplineName;
        this.description = description;
    }

    public static ClimbDiscipline[] populateClimbDisciplineData() {
        return new ClimbDiscipline[]{
                new ClimbDiscipline("Free Solo", "Climbing without aid or protection."),
                new ClimbDiscipline("Bouldering", "Climbing short routes, with a a crash-pad, or nothing, to protect your fall."),
                new ClimbDiscipline("Sport Climb", "Climbing a route with bolts, securing the rope with carabiners."),
                new ClimbDiscipline("Trad Climb", "Climbing without aid or protection."),
                new ClimbDiscipline("Top-Roping", "A style in climbing in which the climber is securely attached to a rope which then passes up, through an anchor system at the top of the climb, and down to a belayer at the foot of the climb."),
                new ClimbDiscipline("Free Base", "Climbing with your only protection being a parachute that is deployed in the event of a fall. A combination of free soloing, and BASE jumping.")
        };
    }

    public int getId() {
        return id;
    }
    public String getClimbDisciplineName() {
        return climbDisciplineName;
    }
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setClimbDisciplineName(String climbDisciplineName) {
        this.climbDisciplineName = climbDisciplineName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
