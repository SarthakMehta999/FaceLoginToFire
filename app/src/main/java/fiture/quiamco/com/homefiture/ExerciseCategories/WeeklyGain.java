package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Activities.ExercisesDay1;
import fiture.quiamco.com.homefiture.Activities.ExercisesDay2;
import fiture.quiamco.com.homefiture.Activities.ExercisesDay3;
import fiture.quiamco.com.homefiture.Activities.ExercisesDay4;
import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.DayOneandThreeWeeklyGainUpperBodyAbsExercises.ExercisesDay5;
import fiture.quiamco.com.homefiture.DayOneandThreeWeeklyGainUpperBodyAbsExercises.ExercisesDay6;
import fiture.quiamco.com.homefiture.DayOneandThreeWeeklyGainUpperBodyAbsExercises.ExercisesDay7;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class WeeklyGain extends AppCompatActivity {
    final User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    user.setStatus("done");
                 Intent def = new Intent(WeeklyGain.this, ExercisesDay1.class);
                    startActivity(def);

//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                 else if (position == 1) {
                    user.setStatus("done");
                    Intent defs = new Intent(WeeklyGain.this, ExercisesDay2.class);
                    startActivity(defs);

                } else if (position == 2) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyGain.this, ExercisesDay3.class);
                    startActivity(def);

                } else if (position == 3) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyGain.this, ExercisesDay4.class);
                    startActivity(def);

                } else if (position == 4) {
                    user.setStatus("pending");
                Intent def = new Intent(getApplication(), ExercisesDay5.class);
                startActivity(def);

                } else if (position == 5) {
                    user.setStatus("pending");
                Intent def = new Intent(getApplication(), ExercisesDay6.class);
                startActivity(def);

                } else if (position == 6) {
                    user.setStatus("pending");
                Intent def = new Intent(getApplication(), ExercisesDay7.class);
                startActivity(def);


        }
    }
});
        }

        }
