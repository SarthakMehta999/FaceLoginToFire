package fiture.quiamco.com.homefiture.GainPainInLegs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class ExercisesPainInLegsDay1 extends AppCompatActivity {
     Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_day1);



        start = (Button) findViewById(R.id.startBtn13);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesPainInLegsDay1.this, fiture.quiamco.com.homefiture.GainChestpain.PushUp.class);
                startActivity(intent);
            }
        });
    }
}
