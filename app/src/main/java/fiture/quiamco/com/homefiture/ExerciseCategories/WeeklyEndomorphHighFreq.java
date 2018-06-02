package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day1ChestandTriceps.Exercisesday1;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day2BackandBiceps.Exercisesday2;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day3CardioMixedInterval.Exercisesday3;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day4ShouldersCalvesAbs.exercisesday4;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day5QuadsHamsGlutes.exercisesday5;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day6CardioMixedInterval.exerciseday6;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day7RestDay.RestDay;
import fiture.quiamco.com.homefiture.R;

public class WeeklyEndomorphHighFreq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_endormorph);

        GridView gridview = (GridView) findViewById(R.id.gridview13);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, Exercisesday1.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphHighFreq.this, "try1", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(WeeklyEndomorphHighFreq.this, Exercisesday2.class);
                    startActivity(defs);
                    Toast.makeText(WeeklyEndomorphHighFreq.this, "try2", Toast.LENGTH_SHORT).show();

                } else if (position == 2) {
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, Exercisesday3.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphHighFreq.this, "try3", Toast.LENGTH_SHORT).show();

                } else if (position == 3) {
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, exercisesday4.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphHighFreq.this, "try4", Toast.LENGTH_SHORT).show();

                } else if (position == 4) {
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, exercisesday5.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphHighFreq.this, "", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, exerciseday6.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphHighFreq.this, "", Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, RestDay.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphHighFreq.this, "", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
