package fiture.quiamco.com.homefiture.models;

/**
 * Created by ShawnErl on 14/11/2017.
 */

public class DailyChallengeModel {
    private Integer dailyExerciseImage;
    private String exerciseName;
    private String status;

    public DailyChallengeModel() {
    }

    public Integer getDailyExerciseImage() {
        return dailyExerciseImage;
    }

    public void setDailyExerciseImage(Integer dailyExerciseImage) {
        this.dailyExerciseImage = dailyExerciseImage;
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
