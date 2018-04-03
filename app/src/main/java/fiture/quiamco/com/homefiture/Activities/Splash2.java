package fiture.quiamco.com.homefiture.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class Splash2 extends AppCompatActivity {
    private User user;
    private static int SPLASH_TIME_OUT = 3000;
    private TextView consider,some;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash2);

        consider = (TextView) findViewById(R.id.consdr);
        consider.setTypeface(EasyFonts.robotoBold(this));
        some = (TextView) findViewById(R.id.someTxt);
        some.setTypeface(EasyFonts.robotoLight(this));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash2.this,BMI.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);

        SharedPreferences sharedPreferences = getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        String fname = sharedPreferences.getString("userFname","");
        String lname = sharedPreferences.getString("userLname","");
        String bday= sharedPreferences.getString("userBday","");
        String gender = sharedPreferences.getString("userGender","");
        String email = sharedPreferences.getString("userEmail","");
        String pic = sharedPreferences.getString("userPic","");
        int points = sharedPreferences.getInt("samplePoint",1);
        Log.d("atayakayawa",points+"shit");
        user = new User(fname,lname,bday,gender,email,pic,points);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}
