package fiture.quiamco.com.homefiture.WeeklyMaintainPainInLowerLegs.Day6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.ExerciseCategories.WeeklyMaintainPainInLowerLegs;
import fiture.quiamco.com.homefiture.R;

public class Day6MaintainLowerLegs extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6_maintain_lower_legs);

        start = (Button) findViewById(R.id.startBtn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),WeeklyMaintainPainInLowerLegs.class);
                startActivity(intent);
            }
        });
    }
}