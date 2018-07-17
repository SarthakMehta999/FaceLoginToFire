package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.WeeklyLoseShortnessOfBreath.Day1.Day1LoseShortnessOfBreath;
import fiture.quiamco.com.homefiture.WeeklyLoseShortnessOfBreath.Day2.Day2LoseShortnessOfBreath;
import fiture.quiamco.com.homefiture.WeeklyLoseShortnessOfBreath.Day3.Day3LoseShortnessOfBreath;
import fiture.quiamco.com.homefiture.WeeklyLoseShortnessOfBreath.Day4.Day4LoseShortnessOfBreath;
import fiture.quiamco.com.homefiture.WeeklyLoseShortnessOfBreath.Day5.Day5LoseShortnessOfBreath;
import fiture.quiamco.com.homefiture.WeeklyLoseShortnessOfBreath.Day6.Day6LoseShortnessOfBreath;
import fiture.quiamco.com.homefiture.WeeklyLoseShortnessOfBreath.Day7.Day7LoseShortnessOfBreath;
import fiture.quiamco.com.homefiture.models.User;

public class WeeklyLoseShortnessOfBreath extends AppCompatActivity {
    final User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_lose_shortness_of_breath);

        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
//                    user.setStatus("done");
                    Intent def = new Intent(getApplication(), Day1LoseShortnessOfBreath.class);
                    startActivity(def);

//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
//                    user.setStatus("done");
                    Intent defs = new Intent(getApplication(), Day2LoseShortnessOfBreath.class);
                    startActivity(defs);

                } else if (position == 2) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), Day3LoseShortnessOfBreath.class);
                    startActivity(def);


                } else if (position == 3) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), Day4LoseShortnessOfBreath.class);
                    startActivity(def);


                } else if (position == 4) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), Day5LoseShortnessOfBreath.class);
                    startActivity(def);

                } else if (position == 5) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), Day6LoseShortnessOfBreath.class);
                    startActivity(def);

                } else if (position == 6) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), Day7LoseShortnessOfBreath.class);
                    startActivity(def);


                }
            }
        });
    }

}
