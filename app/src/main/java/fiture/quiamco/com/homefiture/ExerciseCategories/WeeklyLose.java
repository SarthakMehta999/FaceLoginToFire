package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay1Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay2Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay3Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay4Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay5Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay6Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay7Lose;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class WeeklyLose extends AppCompatActivity {
    final User user = new User();
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
//                    user.setStatus("done");
                   
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay1Lose.class);
                    startActivity(def);

                }

                else if (position == 1) {
//                    user.setStatus("done");
                    Intent defs = new Intent(WeeklyLose.this, ExercisesDay2Lose.class);
                    startActivity(defs);


                } else if (position == 2) {
//                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay3Lose.class);
                    startActivity(def);


                } else if (position == 3) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay4Lose.class);
                    startActivity(def);


                } else if (position == 4) {
//                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay5Lose.class);
                    startActivity(def);

                } else if (position == 5) {
//                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay6Lose.class);
                    startActivity(def);

                } else if (position == 6) {
//                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyLose.this, ExercisesDay7Lose.class);
                    startActivity(def);


                }
            }
        });
    }

}
