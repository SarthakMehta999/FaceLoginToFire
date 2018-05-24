package fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.LoseExcercise.Monday.Instructions.InsBodyWeightSquat;
import fiture.quiamco.com.homefiture.R;

public class ExercisesDay4Lose extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_day4_lose);




        start = (Button) findViewById(R.id.startBtn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesDay4Lose.this,InsBodyWeightSquat.class);
                startActivity(intent);
            }
        });
    }
}