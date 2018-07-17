package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day1.Chest.exercisesday1med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day2BackShoulders.exercisesday2med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day3CardioMixedInterval.exerciseday3med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day4RestDay.RestDayMed;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day5.Biceps.Triceps.exercisesday5med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day6Legs.exercisesday6med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day7RestDay.RestDayMedSun;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class WeeklyEndomorphMedFreq extends AppCompatActivity {
    final User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_endomorph_med_freq);

        GridView gridview = (GridView) findViewById(R.id.gridview15);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
//                    user.setStatus("done");
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, exercisesday1med.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphMedFreq.this, "try1", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
//                    user.setStatus("done");
                    Intent defs = new Intent(WeeklyEndomorphMedFreq.this, exercisesday2med.class);
                    startActivity(defs);

                } else if (position == 2) {
//                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, exerciseday3med.class);
                    startActivity(def);

                } else if (position == 3) {
//                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, RestDayMed.class);
                    startActivity(def);

                } else if (position == 4) {
//                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, exercisesday5med.class);
                    startActivity(def);
                } else if (position == 5) {
//                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, exercisesday6med.class);
                    startActivity(def);
                } else if (position == 6) {
//                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, RestDayMedSun.class);
                    startActivity(def);

                }
            }
        });
    }

}
