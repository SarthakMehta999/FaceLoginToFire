package fiture.quiamco.com.homefiture.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.Exercise;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by ShawnErl on 30/08/2018.
 */


public class ExercisesAdapter extends ArrayAdapter<Exercise> {


    private Activity context;
    private int resource;
    private List<Exercise> exerciseList;
    AlertDialog.Builder adBuilder;
    ArrayList<String> equipmentNames;
    DatabaseReference equipReference;


    public ExercisesAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Exercise> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        exerciseList = objects;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final LayoutInflater inflater = context.getLayoutInflater();

        View v = inflater.inflate(resource, null);

        equipReference = FirebaseDatabase.getInstance().getReference().child("Admin").child("Exercises");

        GifImageView exerciseImg = (GifImageView) v.findViewById(R.id.exerciseImg);
        final TextView tvexerciseTitle = (TextView) v.findViewById(R.id.tvExerciseTitle);
        TextView tvexerciseDesc = (TextView) v.findViewById(R.id.tvExerciseDescription);
        Button equipmentBtn = (Button) v.findViewById(R.id.equipmentBtn);

       Glide.with(context).load(exerciseList.get(position).getExerciseImage()).into(exerciseImg);
        tvexerciseTitle.setText(exerciseList.get(position).getExerciseName());
        tvexerciseDesc.setText(exerciseList.get(position).getExerciseDesc());

        equipmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Exercise exerciseModelName = (Exercise) exerciseList.get(position);

//                Intent intent = new Intent(v.getContext(), ViewExerciseDataActivity.class);
//                intent.putExtra("exerciseName", exerciseModelName.getExerciseName());
//                Log.e("sercisename", exerciseModelName.getExerciseName());

//                v.getContext().startActivity(intent);
                Toast.makeText(context, "Equipment clicked", Toast.LENGTH_SHORT).show();


                equipReference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Exercise exerciseModel = dataSnapshot.getValue(Exercise.class);

                        if(tvexerciseTitle.getText().toString().equalsIgnoreCase(exerciseModel.getExerciseName())) {

                            String equipmentDB = dataSnapshot.child("equipmentVal").getValue().toString();

                            final Dialog dialog = new Dialog(getContext());
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.setCancelable(false);
                            dialog.setContentView(R.layout.exercise_view_equipment);

                            TextView textEquipment = (TextView) dialog.findViewById(R.id.equipment_text);
                            textEquipment.setText(equipmentDB);

                            Button dialogBtn_cancel = (Button) dialog.findViewById(R.id.okayBtn);
                            dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });


                            dialog.show();
                        }

                        for (DataSnapshot postSnapshot : dataSnapshot.child("Equipments").getChildren()) {
                            Log.e("postSnapshottt", String.valueOf(postSnapshot));

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

        });

        return v;
    }





}
