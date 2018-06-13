package fiture.quiamco.com.homefiture.WeeklyLoseShortnessOfBreath.Day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class Day1LoseShortnessOfBreath extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1_lose_shortness_of_breath);

        start = (Button) findViewById(R.id.startBtn15);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), InsBike.class);
                startActivity(intent);
            }
        });
    }
}