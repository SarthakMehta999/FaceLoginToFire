package fiture.quiamco.com.homefiture;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by User on 06/10/2017.
 */

public class FireApp extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
