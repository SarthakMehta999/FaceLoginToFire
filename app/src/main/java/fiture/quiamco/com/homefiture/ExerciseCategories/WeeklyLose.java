package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay1Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay2Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay3Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay4Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay5Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay6Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay7Lose;
import fiture.quiamco.com.homefiture.R;

public class WeeklyLose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_lose);

        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay1Lose.class);
                    startActivity(def);
                    Toast.makeText(WeeklyLose.this, "try1", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(WeeklyLose.this, ExercisesDay2Lose.class);
                    startActivity(defs);
                    Toast.makeText(WeeklyLose.this, "try2", Toast.LENGTH_SHORT).show();

                } else if (position == 2) {
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay3Lose.class);
                    startActivity(def);
                    Toast.makeText(WeeklyLose.this, "try3", Toast.LENGTH_SHORT).show();

                } else if (position == 3) {
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay4Lose.class);
                    startActivity(def);
                    Toast.makeText(WeeklyLose.this, "try4", Toast.LENGTH_SHORT).show();

                } else if (position == 4) {
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay5Lose.class);
                    startActivity(def);
                    Toast.makeText(WeeklyLose.this, "try5", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay6Lose.class);
                    startActivity(def);
                    Toast.makeText(WeeklyLose.this, "try6", Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay7Lose.class);
                    startActivity(def);
                    Toast.makeText(WeeklyLose.this, "try6", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
