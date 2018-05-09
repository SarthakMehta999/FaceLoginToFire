package fiture.quiamco.com.homefiture.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day1.Chest.exercisesday1med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day2.exercisesday2med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day3.exerciseday3med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day4.RestDayMed;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day5.Biceps.Triceps.exercisesday5med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day6.exercisesday6med;
import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day7.RestDayMedSun;
import fiture.quiamco.com.homefiture.R;

public class WeeklyEndomorphMedFreq extends AppCompatActivity {

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
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, exercisesday1med.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphMedFreq.this, "try1", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(WeeklyEndomorphMedFreq.this, exercisesday2med.class);
                    startActivity(defs);
                    Toast.makeText(WeeklyEndomorphMedFreq.this, "try2", Toast.LENGTH_SHORT).show();

                } else if (position == 2) {
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, exerciseday3med.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphMedFreq.this, "try3", Toast.LENGTH_SHORT).show();

                } else if (position == 3) {
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, RestDayMed.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphMedFreq.this, "try4", Toast.LENGTH_SHORT).show();

                } else if (position == 4) {
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, exercisesday5med.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphMedFreq.this, "", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, exercisesday6med.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphMedFreq.this, "", Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Intent def = new Intent(WeeklyEndomorphMedFreq.this, RestDayMedSun.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphMedFreq.this, "", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
