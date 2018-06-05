package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Activities.ExercisesDay1;
import fiture.quiamco.com.homefiture.Activities.ExercisesDay2;
import fiture.quiamco.com.homefiture.Activities.ExercisesDay3;
import fiture.quiamco.com.homefiture.Activities.ExercisesDay4;
import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.R;

public class WeeklyGain extends AppCompatActivity {

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
                 Intent def = new Intent(WeeklyGain.this, ExercisesDay1.class);
                    startActivity(def);
                    Toast.makeText(WeeklyGain.this, "try1", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                 else if (position == 1) {
                    Intent defs = new Intent(WeeklyGain.this, ExercisesDay2.class);
                    startActivity(defs);
                    Toast.makeText(WeeklyGain.this, "try2", Toast.LENGTH_SHORT).show();

                } else if (position == 2) {
                    Intent def = new Intent(WeeklyGain.this, ExercisesDay3.class);
                    startActivity(def);
                    Toast.makeText(WeeklyGain.this, "try3", Toast.LENGTH_SHORT).show();

                } else if (position == 3) {
                    Intent def = new Intent(WeeklyGain.this, ExercisesDay4.class);
                    startActivity(def);
                    Toast.makeText(WeeklyGain.this, "try4", Toast.LENGTH_SHORT).show();

                } else if (position == 4) {
                    Toast.makeText(WeeklyGain.this, "try", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Toast.makeText(WeeklyGain.this, "try", Toast.LENGTH_SHORT).show();
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
