package fiture.quiamco.com.homefiture.LosePainInLegs.Day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class LosePainInLegsDay1 extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_pain_in_legs_day1);

        start = (Button) findViewById(R.id.startBtn15);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LosePainInLegsDay1.this,InsUpandDownsLosePainLegs.class);
                startActivity(intent);
            }
        });
    }
}