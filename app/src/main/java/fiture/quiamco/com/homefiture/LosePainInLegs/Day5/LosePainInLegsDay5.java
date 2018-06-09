package fiture.quiamco.com.homefiture.LosePainInLegs.Day5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class LosePainInLegsDay5 extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_pain_in_legs_day5);

        start = (Button) findViewById(R.id.startBtn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),LosePainInLegsDay5.class);
                startActivity(intent);
            }
        });
    }
}