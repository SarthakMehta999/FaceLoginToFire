package fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class ChestPainDay4 extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_pain_day4);

        start = (Button) findViewById(R.id.startBtn13);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), fiture.quiamco.com.homefiture.LoseExcercise.MonThursSatButtWorkouts.Instructions.InsBodyWeightSquat.class);
                startActivity(intent);
            }
        });
    }
}

