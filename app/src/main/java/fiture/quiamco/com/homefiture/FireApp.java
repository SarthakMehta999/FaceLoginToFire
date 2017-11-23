package fiture.quiamco.com.homefiture;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by User on 16/11/2017.
 */

public class FireApp extends Application {

    public void onCreate(){
        super.onCreate();

        Firebase.setAndroidContext(this);
    }

}
