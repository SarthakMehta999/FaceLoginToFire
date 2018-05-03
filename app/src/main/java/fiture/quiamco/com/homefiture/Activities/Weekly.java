package fiture.quiamco.com.homefiture.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.R;

public class Weekly extends AppCompatActivity {

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
                 Intent def = new Intent(Weekly.this, ExercisesDay1.class);
                    startActivity(def);
                    Toast.makeText(Weekly.this, "try1", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                 else if (position == 1) {
                    Intent defs = new Intent(Weekly.this, ExercisesDay2.class);
                    startActivity(defs);
                    Toast.makeText(Weekly.this, "try2", Toast.LENGTH_SHORT).show();

                } else if (position == 2) {
                    Intent def = new Intent(Weekly.this, ExercisesDay3.class);
                    startActivity(def);
                    Toast.makeText(Weekly.this, "try3", Toast.LENGTH_SHORT).show();

                } else if (position == 3) {
                    Intent def = new Intent(Weekly.this, ExercisesDay4.class);
                    startActivity(def);
                    Toast.makeText(Weekly.this, "try4", Toast.LENGTH_SHORT).show();

                } else if (position == 4) {
                    Toast.makeText(Weekly.this, "try", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Toast.makeText(Weekly.this, "try", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
