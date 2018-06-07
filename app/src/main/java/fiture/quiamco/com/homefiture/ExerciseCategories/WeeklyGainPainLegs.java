package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.GainPainInLegs.Day2andDay4.Rest;
import fiture.quiamco.com.homefiture.GainPainInLegs.ExercisesPainInLegsDay1;
import fiture.quiamco.com.homefiture.R;

public class WeeklyGainPainLegs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_gain_pain_legs);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(getApplication(), ExercisesPainInLegsDay1.class);
                    startActivity(def);

//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(getApplication(), Rest.class);
                    startActivity(defs);

                } else if (position == 2) {
                    Intent def = new Intent(getApplication(), ExercisesPainInLegsDay1.class);
                    startActivity(def);


                } else if (position == 3) {
                    Intent def = new Intent(getApplication(), Rest.class);
                    startActivity(def);

                }

            }
        });
    }
    @Override
    public void onBackPressed(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            fm.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }

}
