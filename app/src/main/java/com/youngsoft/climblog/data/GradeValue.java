package com.youngsoft.climblog.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "GradeValue_Table")
public class GradeValue {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int gradeTypeCode;
    private String gradeName;
    private double relativeDifficulty;

    public GradeValue(int gradeTypeCode, String gradeName, double relativeDifficulty) {
        this.gradeTypeCode = gradeTypeCode;
        this.gradeName = gradeName;
        this.relativeDifficulty = relativeDifficulty;
    }

    public static GradeValue[] populateGradeValueData() {
        return new GradeValue[]{
                new GradeValue(1, "3", 1),
                new GradeValue(1, "3+", 2),
                new GradeValue(1, "4", 3),
                new GradeValue(1, "4+", 4),
                new GradeValue(1, "5", 5),
                new GradeValue(1, "5+", 6),
                new GradeValue(1, "6a", 7),
                new GradeValue(1, "6a+", 8),
                new GradeValue(1, "6b", 9),
                new GradeValue(1, "6b+", 10),
                new GradeValue(1, "6c", 11),
                new GradeValue(1, "6c+", 12),
                new GradeValue(1, "7a", 13),
                new GradeValue(1, "7a+", 14),
                new GradeValue(1, "7b", 15),
                new GradeValue(1, "7b+", 16),
                new GradeValue(1, "7c", 17),
                new GradeValue(1, "7c+", 18),
                new GradeValue(1, "8a", 19),
                new GradeValue(1, "8a+", 20),
                new GradeValue(1, "8b", 21),
                new GradeValue(1, "8b+", 22),
                new GradeValue(1, "8c", 23),
                new GradeValue(1, "8c+", 24),
                new GradeValue(1, "9a", 25),
                new GradeValue(1, "9a+", 26),
                new GradeValue(1, "9b", 27),
                new GradeValue(1, "9b+", 28),
                new GradeValue(1, "9c", 29),
                new GradeValue(1, "9c+", 29),
                new GradeValue(2, "4a", 1),
                new GradeValue(2, "4b", 2),
                new GradeValue(2, "4c", 3),
                new GradeValue(2, "5a", 4),
                new GradeValue(2, "5b", 5),
                new GradeValue(2, "5c", 6),
                new GradeValue(2, "6a", 8),
                new GradeValue(2, "6b", 11),
                new GradeValue(2, "6c", 16),
                new GradeValue(2, "7a", 19),
                new GradeValue(2, "7b", 22),
                new GradeValue(2, "7c", 25),
                new GradeValue(2, "8a", 28),
                new GradeValue(2, "8b", 31),
                new GradeValue(2, "8c", 34),
                new GradeValue(3, "VB", 1),
                new GradeValue(3, "V0-", 2),
                new GradeValue(3, "V0", 3),
                new GradeValue(3, "V0+", 4),
                new GradeValue(3, "V1", 5),
                new GradeValue(3, "V2", 6),
                new GradeValue(3, "V3", 7.5),
                new GradeValue(3, "V4", 9.5),
                new GradeValue(3, "V5", 11.5),
                new GradeValue(3, "V6", 13),
                new GradeValue(3, "V7", 14),
                new GradeValue(3, "V8", 15.5),
                new GradeValue(3, "V9", 17),
                new GradeValue(3, "V10", 18),
                new GradeValue(3, "V11", 19),
                new GradeValue(3, "V12", 20),
                new GradeValue(3, "V13", 21),
                new GradeValue(3, "V14", 22),
                new GradeValue(3, "V15", 23),
                new GradeValue(3, "V16", 24),
                new GradeValue(3, "V17", 25),
                new GradeValue(3, "V18", 26),
                new GradeValue(3, "V19", 27),
                new GradeValue(3, "V20", 28),
                new GradeValue(3, "V21", 29),
                new GradeValue(4, "1", 1),
                new GradeValue(4, "2", 2),
                new GradeValue(4, "2+", 3),
                new GradeValue(4, "3-", 4),
                new GradeValue(4, "3", 5),
                new GradeValue(4, "3+", 6),
                new GradeValue(4, "4a", 7),
                new GradeValue(4, "4b", 8),
                new GradeValue(4, "4c", 9),
                new GradeValue(4, "5a", 10),
                new GradeValue(4, "5b", 11),
                new GradeValue(4, "5c", 12),
                new GradeValue(4, "6a", 13),
                new GradeValue(4, "6a+", 14),
                new GradeValue(4, "6b", 15),
                new GradeValue(4, "6b+", 16),
                new GradeValue(4, "6c", 17),
                new GradeValue(4, "6c+", 18),
                new GradeValue(4, "7a", 19),
                new GradeValue(4, "7a+", 20),
                new GradeValue(4, "7b", 21),
                new GradeValue(4, "7b+", 22),
                new GradeValue(4, "7c", 23),
                new GradeValue(4, "7c+", 24),
                new GradeValue(4, "8a", 25),
                new GradeValue(4, "8a+", 26),
                new GradeValue(4, "8b", 27),
                new GradeValue(4, "8b+", 28),
                new GradeValue(4, "8c", 29),
                new GradeValue(4, "8c+", 30),
                new GradeValue(4, "9a", 31),
                new GradeValue(4, "9a+", 32),
                new GradeValue(4, "9b", 33),
                new GradeValue(4, "9b+", 34),
                new GradeValue(4, "9c", 35),
                new GradeValue(4, "9c+", 36),
                new GradeValue(5, "Mod", 1.5),
                new GradeValue(5, "Diff", 2.5),
                new GradeValue(5, "Vdiff", 3.5),
                new GradeValue(5, "HVD", 5),
                new GradeValue(5, "Sev", 6.25),
                new GradeValue(5, "HS", 7.5),
                new GradeValue(5, "VS", 8),
                new GradeValue(5, "HVS", 10.5),
                new GradeValue(5, "E1", 12),
                new GradeValue(5, "E2", 13.5),
                new GradeValue(5, "E3", 15),
                new GradeValue(5, "E4", 17),
                new GradeValue(5, "E5", 19),
                new GradeValue(5, "E6", 21.5),
                new GradeValue(5, "E7", 23.5),
                new GradeValue(5, "E8", 25.5),
                new GradeValue(5, "E9", 27),
                new GradeValue(5, "E10", 29),
                new GradeValue(5, "E11", 32.5),
                new GradeValue(5, "E12", 34.5),
                new GradeValue(5, "E13", 36),
                new GradeValue(6, "I", 1),
                new GradeValue(6, "II", 2),
                new GradeValue(6, "III", 3),
                new GradeValue(6, "III+", 4),
                new GradeValue(6, "IV-", 5),
                new GradeValue(6, "IV-", 6),
                new GradeValue(6, "IV+", 7),
                new GradeValue(6, "V-", 7.8),
                new GradeValue(6, "V", 8.75),
                new GradeValue(6, "V+", 9.75),
                new GradeValue(6, "VI-", 10.5),
                new GradeValue(6, "VI", 11.5),
                new GradeValue(6, "VI+", 13),
                new GradeValue(6, "VII-", 14),
                new GradeValue(6, "VII", 15.5),
                new GradeValue(6, "VII+", 16.5),
                new GradeValue(6, "VIII-", 18),
                new GradeValue(6, "VIII", 19),
                new GradeValue(6, "VIII+", 20.5),
                new GradeValue(6, "IX-", 21.5),
                new GradeValue(6, "IX", 23),
                new GradeValue(6, "IX+", 24),
                new GradeValue(6, "X-", 25.5),
                new GradeValue(6, "X", 26.5),
                new GradeValue(6, "X+", 28),
                new GradeValue(6, "XI-", 29),
                new GradeValue(6, "XI", 30.25),
                new GradeValue(6, "XI+", 31.5),
                new GradeValue(6, "XII-", 32.75),
                new GradeValue(6, "XII", 34),
                new GradeValue(6, "XII+", 35.25),
                new GradeValue(7, "5.1", 1),
                new GradeValue(7, "5.2", 2),
                new GradeValue(7, "5.3", 3.5),
                new GradeValue(7, "5.4", 4.5),
                new GradeValue(7, "5.5", 6),
                new GradeValue(7, "5.6", 7),
                new GradeValue(7, "5.7", 8.5),
                new GradeValue(7, "5.8", 9.5),
                new GradeValue(7, "5.9", 10.5),
                new GradeValue(7, "5.10a", 11.5),
                new GradeValue(7, "5.10b", 13),
                new GradeValue(7, "5.10c", 14),
                new GradeValue(7, "5.10d", 15),
                new GradeValue(7, "5.11a", 16),
                new GradeValue(7, "5.11b", 17),
                new GradeValue(7, "5.11c", 18),
                new GradeValue(7, "5.11d", 19),
                new GradeValue(7, "5.12a", 20),
                new GradeValue(7, "5.12b", 21),
                new GradeValue(7, "5.12c", 22),
                new GradeValue(7, "5.12d", 23),
                new GradeValue(7, "5.13a", 24),
                new GradeValue(7, "5.13b", 25),
                new GradeValue(7, "5.13c", 26),
                new GradeValue(7, "5.13d", 27),
                new GradeValue(7, "5.14a", 28),
                new GradeValue(7, "5.14b", 29),
                new GradeValue(7, "5.14c", 30),
                new GradeValue(7, "5.14d", 31),
                new GradeValue(7, "5.15a", 32),
                new GradeValue(7, "5.15b", 33),
                new GradeValue(7, "5.15c", 34),
                new GradeValue(7, "5.15d", 35),
                new GradeValue(7, "5.16a", 36),
                new GradeValue(7, "5.16b", 37),
                new GradeValue(7, "5.16c", 38),
                new GradeValue(7, "5.16d", 39),
                new GradeValue(8, "3", 4),
                new GradeValue(8, "4", 5.25),
                new GradeValue(8, "4+", 6.5),
                new GradeValue(8, "5-", 8),
                new GradeValue(8, "5", 9),
                new GradeValue(8, "5+", 10.5),
                new GradeValue(8, "6-", 12),
                new GradeValue(8, "6", 13),
                new GradeValue(8, "6+", 14.5),
                new GradeValue(8, "7-", 16),
                new GradeValue(8, "7", 17.75),
                new GradeValue(8, "7+", 19.5),
                new GradeValue(8, "8-", 21),
                new GradeValue(8, "8", 22.5),
                new GradeValue(8, "8+", 24.5),
                new GradeValue(8, "9-", 26),
                new GradeValue(8, "9", 28),
                new GradeValue(8, "9+", 29.5),
                new GradeValue(8, "10-", 31),
                new GradeValue(8, "10", 32.5),
                new GradeValue(8, "10+", 34),
                new GradeValue(8, "11-", 35.5),
                new GradeValue(8, "11", 37),
                new GradeValue(8, "11+", 38.5),
                new GradeValue(9, "Very Easy", 1),
                new GradeValue(9, "Easy", 5.16666666666667),
                new GradeValue(9, "Easy/Medium", 9.33333333333333),
                new GradeValue(9, "Medium", 13.5),
                new GradeValue(9, "Medium/Difficult", 17.6666666666667),
                new GradeValue(9, "Difficult", 21.8333333333333),
                new GradeValue(9, "Very Difficult", 26),
                new GradeValue(9, "Extreme", 30.1666666666667),
                new GradeValue(9, "Very Extreme", 34.3333333333333),
                new GradeValue(9, "Impossible unless Adam Ondra", 38.5),
                new GradeValue(10, "3", 4),
                new GradeValue(11, "3", 4)
        };
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGradeTypeCode() {
        return gradeTypeCode;
    }

    public String getGradeName() {
        return gradeName;
    }

    public double getRelativeDifficulty() {
        return relativeDifficulty;
    }
}