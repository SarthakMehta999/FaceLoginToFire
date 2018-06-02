package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.Ectomorph.Day2BackandBiceps.EctomorphDay2;
import fiture.quiamco.com.homefiture.Ectomorph.Day3LegandShoulders.Ectomorphday3exercises;
import fiture.quiamco.com.homefiture.Ectomorph.HighRepAbDays.HighRepAbDays;
import fiture.quiamco.com.homefiture.Ectomorph.LayoutEcto.ectomorphday1exercises;
import fiture.quiamco.com.homefiture.Ectomorph.LowRepAbDay.ectomorphlowrepday;
import fiture.quiamco.com.homefiture.Ectomorph.OptionalDays.EctomorphOptionalDays;
import fiture.quiamco.com.homefiture.R;

public class WeeklyEctomorph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_ectomorph);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(WeeklyEctomorph.this, ectomorphday1exercises.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEctomorph.this, "try1", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(WeeklyEctomorph.this, EctomorphDay2.class);
                    startActivity(defs);
                    Toast.makeText(WeeklyEctomorph.this, "try2", Toast.LENGTH_SHORT).show();

                } else if (position == 2) {
                    Intent def = new Intent(WeeklyEctomorph.this, Ectomorphday3exercises.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEctomorph.this, "try3", Toast.LENGTH_SHORT).show();

                } else if (position == 3) {
                    Intent def = new Intent(WeeklyEctomorph.this, HighRepAbDays.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEctomorph.this, "try4", Toast.LENGTH_SHORT).show();

                } else if (position == 4) {
                    Intent def = new Intent(WeeklyEctomorph.this, ectomorphlowrepday.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEctomorph.this, "try", Toast.LENGTH_SHORT).show();

                } else if (position == 5) {
                    Intent def = new Intent(WeeklyEctomorph.this, EctomorphOptionalDays.class);
                    startActivity(def);
                    Toast.makeText(WeeklyEctomorph.this, "try", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

