package fiture.quiamco.com.homefiture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import fiture.quiamco.com.homefiture.Exercises.LoseHeavy;
import fiture.quiamco.com.homefiture.Exercises.LoseMoreHeavy;
import fiture.quiamco.com.homefiture.Exercises.LoseMostHeavy;

public class StartHeavyWorkouts extends AppCompatActivity {

    private CardView heavy,moreheavy,mostheavy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_heavy_workouts);
        heavy = (CardView) findViewById(R.id.heavy);
        moreheavy = (CardView) findViewById(R.id.moreheavy);
        mostheavy = (CardView) findViewById(R.id.mostheavy);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.heavy:
                heavy();
                break;

            case R.id.moreheavy:
                moreheavy();
                break;


            case R.id.mostheavy:
                mostheavy();
                break;
        }
    }

    private void heavy() {
        Intent proc = new Intent(StartHeavyWorkouts.this, LoseHeavy.class);

        startActivity(proc);
    }

    private void moreheavy() {
        Intent work = new Intent(StartHeavyWorkouts.this, LoseMoreHeavy.class);
        startActivity(work);
    }
    private void mostheavy() {
        Intent work = new Intent(StartHeavyWorkouts.this, LoseMostHeavy.class);
        startActivity(work);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}
