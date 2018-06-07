package fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.LoseExcercise.MonThursSatButtWorkouts.Instructions.InsBodyWeightSquat;
import fiture.quiamco.com.homefiture.R;

public class ChestPainDay1 extends AppCompatActivity {
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_pain_day1);

        start = (Button) findViewById(R.id.startBtn13);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),InsBodyWeightSquat.class);
                startActivity(intent);
            }
        });
    }
}
