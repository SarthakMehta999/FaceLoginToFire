package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.GainPainInLegs.Day2andDay4.Rest;
import fiture.quiamco.com.homefiture.GainPainInLegs.ExercisesPainInLegsDay1;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class WeeklyGainPainLegs extends AppCompatActivity {
    final User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_gain_pain_legs);

        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
//                    user.setStatus("done");
                    Intent def = new Intent(getApplication(), ExercisesPainInLegsDay1.class);
                    startActivity(def);

//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
//                    user.setStatus("done");
                    Intent defs = new Intent(getApplication(), Rest.class);
                    startActivity(defs);

                } else if (position == 2) {
//                    user.setStatus("done");
                    Intent def = new Intent(getApplication(), ExercisesPainInLegsDay1.class);
                    startActivity(def);


                } else if (position == 3) {
//                    user.setStatus("done");
                    Intent def = new Intent(getApplication(), Rest.class);
                    startActivity(def);

                }

            }
        });
    }

}
