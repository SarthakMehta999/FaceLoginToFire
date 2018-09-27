package fiture.quiamco.com.homefiture.models;

public class DailyChallengeModelForGain {

    private Integer dailyExerciseImage;
    private String exerciseName;
    private String status;
    private int imageIndex;

    public DailyChallengeModelForGain() {
    }

    public Integer getDailyExerciseImage() {
        return dailyExerciseImage;
    }

    public void setDailyExerciseImage(Integer dailyExerciseImage) {
        this.dailyExerciseImage = dailyExerciseImage;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
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

