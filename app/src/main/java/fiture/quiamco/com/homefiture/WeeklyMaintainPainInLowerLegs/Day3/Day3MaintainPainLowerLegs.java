package fiture.quiamco.com.homefiture.WeeklyMaintainPainInLowerLegs.Day3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class Day3MaintainPainLowerLegs extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_maintain_pain_lower_legs);

        start = (Button) findViewById(R.id.startBtn15);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), InsStraightLegRaise.class);
                startActivity(intent);
            }
        });
    }
}