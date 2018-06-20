package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.GainChestpain.ExercisesChestDay1;
import fiture.quiamco.com.homefiture.Maintain.Rest.Rest;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class WeeklyGainChestpain extends AppCompatActivity {
    final User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_gain_chestpain);

        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    user.setStatus("done");
                    Intent def = new Intent(WeeklyGainChestpain.this, ExercisesChestDay1.class);
                    startActivity(def);

                }

                else if (position == 1) {
                    user.setStatus("done");
                    Intent defs = new Intent(WeeklyGainChestpain.this, Rest.class);
                    startActivity(defs);

                } else if (position == 2) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyGainChestpain.this, ExercisesChestDay1.class);
                    startActivity(def);


                } else if (position == 3) {
                    user.setStatus("pending");
                    Intent def = new Intent(WeeklyGainChestpain.this,Rest.class);
                    startActivity(def);


                }
            }
        });
    }


}