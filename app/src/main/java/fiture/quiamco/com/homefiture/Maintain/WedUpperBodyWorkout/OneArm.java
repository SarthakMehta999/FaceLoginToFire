package fiture.quiamco.com.homefiture.Maintain.WedUpperBodyWorkout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.ExerciseCategories.MaintainWeekly;
import fiture.quiamco.com.homefiture.R;

public class OneArm extends AppCompatActivity {
    CircleButton finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_arm);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),MaintainWeekly.class);
                startActivity(intent);
            }
        });
    }
}
