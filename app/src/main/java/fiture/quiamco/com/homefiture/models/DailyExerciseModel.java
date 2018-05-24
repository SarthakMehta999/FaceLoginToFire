package fiture.quiamco.com.homefiture.models;

/**
 * Created by ShawnErl on 27/04/2018.
 */

public class DailyExerciseModel {
    private String exerciseName;
    private String status;

    public DailyExerciseModel(String s, String done) {
        this.exerciseName = s;
        this.status = done;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
