package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day7RestDay.RestDay;
import fiture.quiamco.com.homefiture.Endomorph.LowFrequency.Day1.Chest.exercisesday1low;
import fiture.quiamco.com.homefiture.Endomorph.LowFrequency.Day3BicepsTricepsShoulders.exercisesday3low;
import fiture.quiamco.com.homefiture.Endomorph.LowFrequency.Day5.Legs.exercisesday5low;
import fiture.quiamco.com.homefiture.Endomorph.LowFrequency.Day6.CardioMixedInterval.exercisesday6low;
import fiture.quiamco.com.homefiture.R;

public class WeeklyEndomorphLowFreq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_endomorph_low_freq);

        GridView gridview = (GridView) findViewById(R.id.gridview14);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(WeeklyEndomorphLowFreq.this, exercisesday1low.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphLowFreq.this, "try1", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(WeeklyEndomorphLowFreq.this,RestDay.class);
                    startActivity(defs);
                    Toast.makeText(WeeklyEndomorphLowFreq.this, "try2", Toast.LENGTH_SHORT).show();

                } else if (position == 2) {
                    Intent def = new Intent(WeeklyEndomorphLowFreq.this, exercisesday3low.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphLowFreq.this, "try3", Toast.LENGTH_SHORT).show();

                } else if (position == 3) {
                    Intent def = new Intent(WeeklyEndomorphLowFreq.this, RestDay.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphLowFreq.this, "try4", Toast.LENGTH_SHORT).show();

                } else if (position == 4) {
                    Intent def = new Intent(WeeklyEndomorphLowFreq.this, exercisesday5low.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphLowFreq.this, "", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Intent def = new Intent(WeeklyEndomorphLowFreq.this, exercisesday6low.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphLowFreq.this, "", Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Intent def = new Intent(WeeklyEndomorphLowFreq.this, RestDay.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEndomorphLowFreq.this, "", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
