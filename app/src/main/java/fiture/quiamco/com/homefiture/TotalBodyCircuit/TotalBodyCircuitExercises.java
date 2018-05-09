package fiture.quiamco.com.homefiture.TotalBodyCircuit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Activities.Weekly;
import fiture.quiamco.com.homefiture.GainExercisesForFemale.JumpingJacks;
import fiture.quiamco.com.homefiture.R;

public class TotalBodyCircuitExercises extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_body_circuit_exercises);

        Toolbar toolbar = (Toolbar) findViewById(R.id.imToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(TotalBodyCircuitExercises.this,Weekly.class);
                startActivity(im);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        start = (Button) findViewById(R.id.startBtn13);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TotalBodyCircuitExercises.this,JumpingJacks.class);
                startActivity(intent);
            }
        });
    }
}
