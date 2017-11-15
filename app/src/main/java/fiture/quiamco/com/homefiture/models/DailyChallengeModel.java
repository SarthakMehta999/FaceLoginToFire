package fiture.quiamco.com.homefiture.models;

/**
 * Created by ShawnErl on 14/11/2017.
 */

public class DailyChallengeModel {
    private Integer dailyExerciseImage;
    private String exerciseName;

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
}
