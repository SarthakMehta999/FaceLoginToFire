package fiture.quiamco.com.homefiture;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import fiture.quiamco.com.homefiture.Adapter.ExercisesAdapter;
import fiture.quiamco.com.homefiture.models.Exercise;

/**
 * Created by ShawnErl on 30/08/2018.
 */

public class ExercisesActivity extends AppCompatActivity {

    private ListView exerciseLv;
    private DatabaseReference exerciseReference;
    private ArrayList<Exercise> exerciseList = new ArrayList<>();
    private ExercisesAdapter adapter;

    AlertDialog.Builder adBuilder;
    ArrayList<String> equipmentNames;
    DatabaseReference equipReference;
    DatabaseReference getExerciseReference;
    Button equipmentBtn;


    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercisesgainday1);


        exerciseLv = (ListView) findViewById(R.id.exerciseLV);


        exerciseReference = FirebaseDatabase.getInstance().getReference().child("Admin").child("Exercises");

        exerciseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.e("dataSnapshotttt", String.valueOf(dataSnapshot));

                Exercise exercises = dataSnapshot.getValue(Exercise.class);
                exerciseList.add(exercises);

                adapter = new ExercisesAdapter(ExercisesActivity.this, R.layout.exercises_list_card, exerciseList);
                exerciseLv.setAdapter(adapter);

                exerciseLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Exercise exerciseModel = adapter.getItem(position);

                        Toast.makeText(context, "Clicked:  " + " " + exerciseModel.getExerciseName(), Toast.LENGTH_SHORT).show();
                    }
                });


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
