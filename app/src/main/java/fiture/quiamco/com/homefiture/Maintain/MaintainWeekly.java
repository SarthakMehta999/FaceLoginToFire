package fiture.quiamco.com.homefiture.Maintain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.Maintain.FriTotalBodyWrkout.StartFri;
import fiture.quiamco.com.homefiture.Maintain.MondayCoreWorkout.StartMon;
import fiture.quiamco.com.homefiture.Maintain.Rest.Rest;
import fiture.quiamco.com.homefiture.Maintain.TuesdayCardio.Exercisesday1;
import fiture.quiamco.com.homefiture.Maintain.WedUpperBodyWorkout.StarWed;
import fiture.quiamco.com.homefiture.R;

public class MaintainWeekly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_weekly);

        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(getApplication(), StartMon.class);
                    startActivity(def);

//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Intent defs = new Intent(getApplication(), Exercisesday1.class);
                    startActivity(defs);
                    Toast.makeText(getApplication(), "try2", Toast.LENGTH_SHORT).show();

                } else if (position == 2) {
                    Intent def = new Intent(getApplication(), StarWed.class);
                    startActivity(def);
                    Toast.makeText(getApplication(), "try3", Toast.LENGTH_SHORT).show();

                } else if (position == 3) {
                    Intent def = new Intent(getApplication(), fiture.quiamco.com.homefiture.Maintain.ThuCardio.Exercisesday1.class);
                    startActivity(def);
                    Toast.makeText(getApplication(), "try4", Toast.LENGTH_SHORT).show();

                } else if (position == 4) {
                    Intent def = new Intent(getApplication(), StartFri.class);
                    startActivity(def);
                    Toast.makeText(getApplication(), "try5", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Intent def = new Intent(getApplication(), fiture.quiamco.com.homefiture.Maintain.SatCardio.Exercisesday1.class);
                    startActivity(def);
                    Toast.makeText(getApplication(), "try6", Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Intent def = new Intent(getApplication(), Rest.class);
                    startActivity(def);
                    Toast.makeText(getApplication(), "try6", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
