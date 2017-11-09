package fiture.quiamco.com.homefiture.models;

import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by User on 21/09/2017.
 */

public class User implements Serializable {
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
    private EditText height;
    private EditText weight;
    private TextView result;


    public User() {
    }

    public User(String fName, String lName, String birthDate, String gender, String email, String imageUrl) {
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.imageUrl = imageUrl;

    }
    public User(TextView result) {
        this.height = height;
        this.weight = weight;
        this.result = result;
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

    public EditText getHeight() {
        return height;
    }

    public void setHeight(EditText height) {
        this.height = height;
    }

    public EditText getWeight() {
        return weight;
    }

    public void setWeight(EditText weight) {
        this.weight = weight;
    }

    public TextView getResult() {
        return result;
    }

    public void setResult(TextView result) {
        this.result = result;
    }
}
