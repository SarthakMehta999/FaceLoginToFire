package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay2Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay3Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay4Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay5Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay6Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay7Lose;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.WeeklyLosePainInLegs.Day1;

public class WeeklyLosePainInLegs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_lose_pain_in_legs);


        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(getApplication(), Day1.class);
                    startActivity(def);

                }

                else if (position == 1) {
                    Intent defs = new Intent(getApplication(), ExercisesDay2Lose.class);
                    startActivity(defs);


                } else if (position == 2) {
                    Intent def = new Intent(getApplication(), ExercisesDay3Lose.class);
                    startActivity(def);


                } else if (position == 3) {
                    Intent def = new Intent(getApplication(), ExercisesDay4Lose.class);
                    startActivity(def);


                } else if (position == 4) {
                    Intent def = new Intent(getApplication(), ExercisesDay5Lose.class);
                    startActivity(def);

                } else if (position == 5) {
                    Intent def = new Intent(getApplication(), ExercisesDay6Lose.class);
                    startActivity(def);

                } else if (position == 6) {
                    Intent def = new Intent(getApplication(), ExercisesDay7Lose.class);
                    startActivity(def);


                }
            }
        });
    }

}
