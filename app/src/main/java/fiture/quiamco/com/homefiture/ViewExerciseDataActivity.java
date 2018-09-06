package fiture.quiamco.com.homefiture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fiture.quiamco.com.homefiture.models.Exercise;

/**
 * Created by ShawnErl on 06/09/2018.
 */

public class ViewExerciseDataActivity extends AppCompatActivity {


    private TextView tvEquipments;
    private Button okayBtn;
    private DatabaseReference equipmentsReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_view_equipment);

        tvEquipments = (TextView) findViewById(R.id.equipment_text);
        okayBtn = (Button) findViewById(R.id.okayBtn);

        equipmentsReference = FirebaseDatabase.getInstance().getReference().child("Admin").child("Exercises");

        final String equipmentName = getIntent().getStringExtra("exerciseName");

        equipmentsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Exercise exerciseModel = dataSnapshot.getValue(Exercise.class);

                if(equipmentName.equalsIgnoreCase(exerciseModel.getExerciseName())){

                    String equipmentDB = dataSnapshot.child("equipmentVal").getValue().toString();
                    tvEquipments.setText(equipmentDB);

                    okayBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent okIntent = new Intent(ViewExerciseDataActivity.this, ExercisesActivity.class);
                            startActivity(okIntent);
                        }
                    });

                }
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
