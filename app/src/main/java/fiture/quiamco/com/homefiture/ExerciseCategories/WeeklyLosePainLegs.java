package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.LosePainInLegs.Day1.LosePainInLegsDay1;
import fiture.quiamco.com.homefiture.LosePainInLegs.Day2.LosePainInLegsDay2;
import fiture.quiamco.com.homefiture.LosePainInLegs.Day3.LosePainInLegsDay3;
import fiture.quiamco.com.homefiture.LosePainInLegs.Day4.LosePainInLegsDay4;
import fiture.quiamco.com.homefiture.LosePainInLegs.Day5.LosePainInLegsDay5;
import fiture.quiamco.com.homefiture.LosePainInLegs.Day6.LosePainInLegsDay6;
import fiture.quiamco.com.homefiture.LosePainInLegs.Day7.LosePainInLegsDay7;
import fiture.quiamco.com.homefiture.R;

public class WeeklyLosePainLegs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_lose_pain_legs);

        GridView gridview = (GridView) findViewById(R.id.gridview2);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(getApplication(), LosePainInLegsDay1.class);
                    startActivity(def);

//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(getApplication(), LosePainInLegsDay2.class);
                    startActivity(defs);

                } else if (position == 2) {
                    Intent def = new Intent(getApplication(), LosePainInLegsDay3.class);
                    startActivity(def);


                } else if (position == 3) {
                    Intent def = new Intent(getApplication(), LosePainInLegsDay4.class);
                    startActivity(def);


                } else if (position == 4) {
                    Intent def = new Intent(getApplication(), LosePainInLegsDay5.class);
                    startActivity(def);

                } else if (position == 5) {
                    Intent def = new Intent(getApplication(), LosePainInLegsDay6.class);
                    startActivity(def);

                } else if (position == 6) {
                    Intent def = new Intent(getApplication(), LosePainInLegsDay7.class);
                    startActivity(def);


                }
            }
        });
    }

}

