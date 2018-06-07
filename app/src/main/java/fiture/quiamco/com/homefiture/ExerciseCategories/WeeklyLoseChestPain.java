package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day1.ChestPainDay1;
import fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day3.ChestPainDay3;
import fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day4.ChestPainDay4;
import fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day5.ChestPainDay5;
import fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day6.ChestPainDay6;
import fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day7.ChestPainDay7;

public class WeeklyLoseChestPain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_lose_chest_pain);


        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(getApplication(), ChestPainDay1.class);
                    startActivity(def);

//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(getApplication(), fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day2.ChestPainDay2.class);
                    startActivity(defs);

                } else if (position == 2) {
                    Intent def = new Intent(getApplication(), ChestPainDay3.class);
                    startActivity(def);


                } else if (position == 3) {
                    Intent def = new Intent(getApplication(), ChestPainDay4.class);
                    startActivity(def);


                } else if (position == 4) {
                    Intent def = new Intent(getApplication(), ChestPainDay5.class);
                    startActivity(def);

                } else if (position == 5) {
                    Intent def = new Intent(getApplication(), ChestPainDay6.class);
                    startActivity(def);

                } else if (position == 6) {
                    Intent def = new Intent(getApplication(), ChestPainDay7.class);
                    startActivity(def);


                }
            }
        });
    }

}
