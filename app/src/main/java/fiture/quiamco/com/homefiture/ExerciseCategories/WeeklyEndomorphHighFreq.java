package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day1ChestandTriceps.Exercisesday1;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day2BackandBiceps.Exercisesday2;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day3CardioMixedInterval.Exercisesday3;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day4ShouldersCalvesAbs.exercisesday4;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day5QuadsHamsGlutes.exercisesday5;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day6CardioMixedInterval.exerciseday6;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day7RestDay.RestDay;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class WeeklyEndomorphHighFreq extends AppCompatActivity {
    final User user = new User();
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
                    user.setStatus("done");
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, Exercisesday1.class);
                    startActivity(def);
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    user.setStatus("done");
                    Intent defs = new Intent(WeeklyEndomorphHighFreq.this, Exercisesday2.class);
                    startActivity(defs);

                } else if (position == 2) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, Exercisesday3.class);
                    startActivity(def);

                } else if (position == 3) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, exercisesday4.class);
                    startActivity(def);

                } else if (position == 4) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, exercisesday5.class);
                    startActivity(def);
                } else if (position == 5) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, exerciseday6.class);
                    startActivity(def);
                } else if (position == 6) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphHighFreq.this, RestDay.class);
                    startActivity(def);

                }
            }
        });
    }

}
