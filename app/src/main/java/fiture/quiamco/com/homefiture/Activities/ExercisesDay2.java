package fiture.quiamco.com.homefiture.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class ExercisesDay2 extends AppCompatActivity {
    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercisesday2);

        start = (Button) findViewById(R.id.startBtn2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesDay2.this,BodyweightSquat.class);
                startActivity(intent);
            }
        });
    }
}