package fiture.quiamco.com.homefiture.models;

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


    public User(String fName, String lName, String birthDate, String gender, String email, String imageUrl) {
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.imageUrl = imageUrl;
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
}
