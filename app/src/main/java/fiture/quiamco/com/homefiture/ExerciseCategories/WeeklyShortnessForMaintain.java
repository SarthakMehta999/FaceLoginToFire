package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day1.ShortnessDay1;
import fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day2.ShortnessDay2;
import fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day3.ShortnessDay3;
import fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day7.RestShortness;
import fiture.quiamco.com.homefiture.models.User;

public class WeeklyShortnessForMaintain extends AppCompatActivity {
    final User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_shortness_for_maintain);

        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    user.setStatus("done");
                    Intent def = new Intent(getApplication(), ShortnessDay1.class);
                    startActivity(def);

                }

                else if (position == 1) {
                    user.setStatus("done");
                    Intent defs = new Intent(getApplication(), ShortnessDay2.class);
                    startActivity(defs);


                } else if (position == 2) {
                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), ShortnessDay3.class);
                    startActivity(def);


                } else if (position == 3) {
                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), ShortnessDay2.class);
                    startActivity(def);


                } else if (position == 4) {
                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), ShortnessDay1.class);
                    startActivity(def);

                } else if (position == 5) {
                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(),ShortnessDay2.class);
                    startActivity(def);

                } else if (position == 6) {
                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), RestShortness.class);
                    startActivity(def);


                }
            }
        });
    }

}
