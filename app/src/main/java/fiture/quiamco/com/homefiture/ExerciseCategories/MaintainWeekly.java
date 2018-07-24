package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.Maintain.FriTotalBodyWrkout.StartFri;
import fiture.quiamco.com.homefiture.Maintain.MondayCoreWorkout.StartMon;
import fiture.quiamco.com.homefiture.Maintain.Rest.Rest;
import fiture.quiamco.com.homefiture.Maintain.TuesdayCardio.Exercisesday1;
import fiture.quiamco.com.homefiture.Maintain.WedUpperBodyWorkout.StarWed;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class MaintainWeekly extends AppCompatActivity {
    boolean itemsLocked;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference surveyResponseRef = database.getReference("weeklyExercise");
    final User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_weekly);
        SharedPreferences sharedPreferences = getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        sharedPreferences = getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {

//                if (itemsLocked) return;
                if (position == 0) {
//                    user.setStatus("done");
                    Intent def = new Intent(getApplication(), StartMon.class);
                    startActivity(def);

//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    if (surveyResponseRef.child("Exercise 7").equals("Exercise 7")) {
//                        user.setStatus("done");

                        Intent defs = new Intent(getApplicationContext(), Exercisesday1.class);
                startActivity(defs);
                        Log.d("it exists", "it does");


                    }
                    else{

//                        user.setStatus("pending");
                    }


                } else if (position == 2) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), StarWed.class);
                    startActivity(def);

                } else if (position == 3) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), fiture.quiamco.com.homefiture.Maintain.ThuCardio.Exercisesday1.class);
                    startActivity(def);

                } else if (position == 4) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), StartFri.class);
                    startActivity(def);
                } else if (position == 5) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), fiture.quiamco.com.homefiture.Maintain.SatCardio.Exercisesday1.class);
                    startActivity(def);
                } else if (position == 6) {
//                    user.setStatus("pending");
                    Intent def = new Intent(getApplication(), Rest.class);
                    startActivity(def);

                }
            }
        });

    }
}
