package fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.LoseExcercise.Friday.Instructions.InsSquatJacks;
import fiture.quiamco.com.homefiture.R;

public class ExercisesDay5Lose extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_day5_lose);





        start = (Button) findViewById(R.id.startBtn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesDay5Lose.this,InsSquatJacks.class);
                startActivity(intent);
            }
        });
    }
}