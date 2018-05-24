package fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.LoseExcercise.Wednesday.Instructions.InsWalkingLunge;
import fiture.quiamco.com.homefiture.R;

public class ExercisesDay3Lose extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_day3_lose);





        start = (Button) findViewById(R.id.startBtn14);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesDay3Lose.this,InsWalkingLunge.class);
                startActivity(intent);
            }
        });
    }
}