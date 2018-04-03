package fiture.quiamco.com.homefiture.models;

import java.io.Serializable;

/**
 * Created by User on 02/04/2018.
 */

public class Infos implements Serializable {
  private String fitness,workout,goal,height,weight;

    public Infos(){

    }

    public Infos(String fitness, String workout, String goal,String height,String weight) {
        this.fitness = fitness;
        this.workout = workout;
        this.goal = goal;
        this.height = height;
        this.weight = weight;
    }

    public String getFitness() {
        return fitness;
    }

    public void setFitness(String fitness) {
        this.fitness = fitness;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
