package fiture.quiamco.com.homefiture.models;

/**
 * Created by User on 17/05/2018.
 */

public class Exercise  {
    private String exerciseName;
    private String exerciseDesc;
    private String exerciseImage;
    private String exerciseVideo;

    public Exercise() {
    }

    public Exercise(String exerciseName, String exerciseDesc, String exerciseImage, String exerciseVideo, String ex) {
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseImage = exerciseImage;
        this.exerciseVideo = exerciseVideo;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseDesc() {
        return exerciseDesc;
    }

    public void setExerciseDesc(String exerciseDesc) {
        this.exerciseDesc = exerciseDesc;
    }

    public String getExerciseImage() {
        return exerciseImage;
    }

    public void setExerciseImage(String exerciseImage) {
        this.exerciseImage = exerciseImage;
    }

    public String getExerciseVideo() {
        return exerciseVideo;
    }

    public void setExerciseVideo(String exerciseVideo) {
        this.exerciseVideo = exerciseVideo;
    }


}

