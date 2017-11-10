package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class workoutMostHeavy extends AppCompatActivity {
    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_most_heavy);
        Next=(Button)findViewById (R.id.button46);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(workoutMostHeavy.this, LoseMoreHeavy.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button45);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(workoutMostHeavy.this, day2mostheavy.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
