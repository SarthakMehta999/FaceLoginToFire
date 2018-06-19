package fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.ExerciseCategories.WeeklyShortnessForMaintain;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class StationaryCycling extends AppCompatActivity {
    CircleButton finish;

    private String userId;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stationary_cycling);
        SharedPreferences sharedPreferences = getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        userId = sharedPreferences.getString("userKey","");
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),WeeklyShortnessForMaintain.class);
                startActivity(intent);
            }
        });
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference surveyResponseRef = database.getReference("UserDoneExercises");
//        if(surveyResponseRef.child(userId).equals(userId)){
//            Log.d("it exists",user.getfName());
//        }
//        else {
//            surveyResponseRef.child(userId).child("exercise1").setValue(fitnessResponse);
//            surveyResponseRef.child(userId).child("goal").setValue(goalResponse);
//            for (int i = 0; i < illnesses.size(); i++) {
//                surveyResponseRef.child(userId).child("illnesses").child(String.valueOf(i + 1)).setValue(illnesses.get(i));
//            }
//        }
    }
}
