package fiture.quiamco.com.homefiture.models;

/**
 * Created by ShawnErl on 14/11/2017.
 */

public class DailyChallengeModel {
    private String dailyExerciseImage;
    private String exerciseName;

    public DailyChallengeModel() {
    }

    public String getDailyExerciseImage() {
        return dailyExerciseImage;
    }

    public void setDailyExerciseImage(String dailyExerciseImage) {
        this.dailyExerciseImage = dailyExerciseImage;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
