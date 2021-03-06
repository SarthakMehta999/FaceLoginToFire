package fiture.quiamco.com.homefiture.models;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by User on 21/09/2017.
 */

public class User implements Serializable, Comparable<User> {

//    name = inBundle.getString("name");
//    surname = inBundle.getString("surname");
//    day = inBundle.getString("birthday");
//    genderOfUser = inBundle.getString("gender");
//    emailOfUser = inBundle.getString("email");
//    imageUrl = inBundle.getString("imageUrl");
//    userId = inBundle.getString("userID");
    private String fName;
    private String lName;
    private String birthDate;
    private String gender;
    private String email;
    private String imageUrl;
    private int userPoints;
    private String height;
    private String weight;
    private String BMI;
    private String bmiLabel;
    private String fitnessResponse;
    private String goal;
    private String ilnesses;
    private String status;
    public User() {
    }

    public User(String fName, String lName, String birthDate, String gender, String email, String imageUrl, int userPoints) {
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.imageUrl = imageUrl;
        this.userPoints = userPoints;
    }

    public User(String fName, String lName, String birthDate, String gender, String email, String imageUrl, int userPoints, String height,
                String weight, String BMI, String bmiLabel) {
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.imageUrl = imageUrl;
        this.userPoints = userPoints;
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        this.bmiLabel = bmiLabel;

    }

    public User(String fName, String lName, String birthDate, String gender, String email, String imageUrl, int userPoints, String height,
                String weight, String BMI, String bmiLabel, String fitnessResponse, String goal, String ilnesses) {
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.imageUrl = imageUrl;
        this.userPoints = userPoints;
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        this.bmiLabel = bmiLabel;
        this.fitnessResponse = fitnessResponse;
        this.goal = goal;
        this.ilnesses = ilnesses;
    }

    public User(String fName, String lName, String birthDate, String gender, String email, String imageUrl, int userPoints,
                String height, String weight, String BMI, String bmiLabel, String fitnessResponse, String goal, String ilnesses, String status) {
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.imageUrl = imageUrl;
        this.userPoints = userPoints;
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        this.bmiLabel = bmiLabel;
        this.fitnessResponse = fitnessResponse;
        this.goal = goal;
        this.ilnesses = ilnesses;
        this.status = status;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;

    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public String getBmiLabel() {
        return bmiLabel;
    }

    public String getFitnessResponse() {
        return fitnessResponse;
    }

    public void setFitnessResponse(String fitnessResponse) {
        this.fitnessResponse = fitnessResponse;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getIlnesses() {
        return ilnesses;
    }

    public void setIlnesses(String ilnesses) {
        this.ilnesses = ilnesses;
    }

    public void setBmiLabel(String bmiLabel) {
        this.bmiLabel = bmiLabel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /*@Override
    public int compare(User o1, User o2) {
        int resulta_1 = o1.getUserPoints();
        int resulta_2 = o2.getUserPoints();
        if(resulta_1 > resulta_2){
            return 1;
        }else if (resulta_1 < resulta_2){
            return -1;
        }else{
            return 0;
        }
    }*/

    @Override
    public int compareTo(@NonNull User o) {
        if(userPoints < o.getUserPoints()){
            return 1;
        }else if(userPoints > o.getUserPoints()){
            return -1;
        }else{
            return 0;
        }
    }


//
//    public EditText getWeight() {
//        return weight;
//    }
//
//    public void setWeight(EditText weight) {
//        this.weight = weight;
//    }

//    public TextView getResult() {
//        return result;
//    }
//
//    public void setResult(TextView result) {
//        this.result = result;
//    }
}
