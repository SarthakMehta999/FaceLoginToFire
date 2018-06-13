package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.WeeklyMaintainPainInLowerLegs.Day1.Day1MaintainPainLowerLegs;
import fiture.quiamco.com.homefiture.WeeklyMaintainPainInLowerLegs.Day2.Day2MaintainPainLowerLegs;
import fiture.quiamco.com.homefiture.WeeklyMaintainPainInLowerLegs.Day3.Day3MaintainPainLowerLegs;
import fiture.quiamco.com.homefiture.WeeklyMaintainPainInLowerLegs.Day4.Day4MaintainPainLowerLegs;
import fiture.quiamco.com.homefiture.WeeklyMaintainPainInLowerLegs.Day5.Day5MaintainPainLowerLegs;
import fiture.quiamco.com.homefiture.WeeklyMaintainPainInLowerLegs.Day6.Day6MaintainLowerLegs;
import fiture.quiamco.com.homefiture.WeeklyMaintainPainInLowerLegs.Day7.Day7MaintainPainLowerLegs;

public class WeeklyMaintainPainInLowerLegs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_maintain_pain_in_lower_legs);


        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(getApplication(), Day1MaintainPainLowerLegs.class);
                    startActivity(def);

//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(getApplication(), Day2MaintainPainLowerLegs.class);
                    startActivity(defs);

                } else if (position == 2) {
                    Intent def = new Intent(getApplication(), Day3MaintainPainLowerLegs.class);
                    startActivity(def);


                } else if (position == 3) {
                    Intent def = new Intent(getApplication(), Day4MaintainPainLowerLegs.class);
                    startActivity(def);


                } else if (position == 4) {
                    Intent def = new Intent(getApplication(), Day5MaintainPainLowerLegs.class);
                    startActivity(def);

                } else if (position == 5) {
                    Intent def = new Intent(getApplication(), Day6MaintainLowerLegs.class);
                    startActivity(def);

                } else if (position == 6) {
                    Intent def = new Intent(getApplication(), Day7MaintainPainLowerLegs.class);
                    startActivity(def);


                }
            }
        });
    }

}
