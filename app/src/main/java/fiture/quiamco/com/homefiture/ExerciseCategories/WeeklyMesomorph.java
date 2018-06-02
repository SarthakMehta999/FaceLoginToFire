package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.Mesomorph.Mesomorph.LegsDay1.mesomorphday1;
import fiture.quiamco.com.homefiture.Mesomorph.Mesomorph.CardioDay3.mesomorphday3;
import fiture.quiamco.com.homefiture.Mesomorph.Mesomorph.CardioDay2.mesomorphday2;
import fiture.quiamco.com.homefiture.R;

public class WeeklyMesomorph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_mesomorph);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(WeeklyMesomorph.this, mesomorphday1.class);
                    startActivity(def);
                    Toast.makeText(WeeklyMesomorph.this, "try1", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(WeeklyMesomorph.this, mesomorphday2.class);
                    startActivity(defs);
                    Toast.makeText(WeeklyMesomorph.this, "try2", Toast.LENGTH_SHORT).show();

                } else if (position == 2) {
                    Intent def = new Intent(WeeklyMesomorph.this, mesomorphday3.class);
                    startActivity(def);
                    Toast.makeText(WeeklyMesomorph.this, "try3", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}