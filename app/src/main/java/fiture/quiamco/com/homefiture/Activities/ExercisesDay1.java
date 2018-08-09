package fiture.quiamco.com.homefiture.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import fiture.quiamco.com.homefiture.DayOneandThreeWeeklyGainUpperBodyAbsExercises.PushUp;
import fiture.quiamco.com.homefiture.R;

public class ExercisesDay1 extends AppCompatActivity {

    Button start;
    Button equipments1;
    Button equipments2;
    Button equipments3;
    Button equipments4;
    Button equipments5;
    AlertDialog.Builder adBuilder;
    ArrayList<String> equipmentNames;
    DatabaseReference equipReference;



    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_day1);

        equipmentNames = new ArrayList<String>();
        equipmentNames.add("Barbell");
        equipmentNames.add("Ball");
        equipmentNames.add("Pullbars");

        equipReference = FirebaseDatabase.getInstance().getReference().child("Admin").child("Exercises");


        start = (Button) findViewById(R.id.startBtn31);
        equipments1 = (Button) findViewById(R.id.equipmentsmondaygainday1);
        equipments2 = (Button) findViewById(R.id.equipmentsmondaygainday2);
        equipments3 = (Button) findViewById(R.id.equipmentsmondaygainday3);
        equipments4 = (Button) findViewById(R.id.equipmentsmondaygainday4);
        equipments5 = (Button) findViewById(R.id.equipmentsmondaygainday5);

        equipments1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Equipment clicked", Toast.LENGTH_SHORT).show();
                Log.e("dataSnapshot", String.valueOf(equipReference));

                equipReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.e("dataSnapshot", String.valueOf(dataSnapshot));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
//
//        equipments1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("databaseReference", String.valueOf(databaseReference));
//                Toast.makeText(context, "Equipment clicked", Toast.LENGTH_SHORT).show();
//
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        Log.e("dataSnapshot", String.valueOf(dataSnapshot));
//
//
//                        String equipment_id = "";
//                        String equipment_name = "";
//
//                        List<String> equipment_ID = new ArrayList<String>();
//                        List<String> equipment_Name = new ArrayList<String>();
//
//                        for (DataSnapshot postSnapshot : dataSnapshot.child("equipment").getChildren()){
//                            Log.e("postSnapshot", String.valueOf(postSnapshot));
//                            String eqName = postSnapshot.child("equipmentname").getValue(String.class);
//                            int eqID = postSnapshot.child("equipmentid").getValue(int.class);
//                            Log.e("eqName",eqName);
//                            Log.e("eqID", String.valueOf(eqID));
//
//                            equipment_name += eqName;
//                            equipment_Name.add(equipment_name);
//                            equipment_id += eqID;
//                            equipment_ID.add(equipment_id);
//
//                        }
//                        Log.e("equipment_id", equipment_id);
//                        Log.e("equipment_name", equipment_name);
//
//                        EquipmentModel img = dataSnapshot.getValue(EquipmentModel.class);
//                        Log.e("img", String.valueOf(img));
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
////
////                Dialog dialog = new Dialog(ExercisesDay1.this);
////                dialog.setContentView(R.layout.custom_dialog_equipment);
////                Button mClose = (Button) dialog.findViewById(R.id.customDialogClose);
//
//
//
////                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
////                //set title
////                alertDialogBuilder.setTitle("Equipments:");
////                //set dialog message
////                alertDialogBuilder
////                        .setMessage("1.) Push up Bar Stand " + "\n" +
////                                "2.) Shape Push Up" + "\n" +
////                                "3.) Tony Horton’s PowerStands" + "\n" +
////                                "4.) Push Up Stand Machine ")
////                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialog, int id) {
////                                // if this button is clicked, close
////                                // current activity
////
////                            }
////                        });
////
////
////                // create alert dialog
////                AlertDialog alertDialog = alertDialogBuilder.create();
////                // show it
////                alertDialog.show();
//
//
//
//            }
//
//        });

        equipments2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                //set title
                alertDialogBuilder.setTitle("Equipments:");
                //set dialog message
                alertDialogBuilder
                        .setMessage("1.) Elevated Pike Push Up" + "\n" +
                                "2.) Chair " + "\n" +
                                "3.) Bench" + "\n" +
                                "4.) Ball Pike Push Up ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity

                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }

        });

        equipments3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                //set title
                alertDialogBuilder.setTitle("Equipments:");
                //set dialog message
                alertDialogBuilder
                        .setMessage("1.) Dip Machine" + "\n" +
                                "2.) Assisted Triceps Dip Machine " + "\n" +
                                "3.) Chair" + "\n" +
                                "4.) Dip Stand Parallel Bar ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity

                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }

        });

        equipments4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                //set title
                alertDialogBuilder.setTitle("Equipments:");
                //set dialog message
                alertDialogBuilder
                        .setMessage("1.)Assisted Pull Up Machine " + "\n" +
                                "2.) Pull Up Bar " + "\n" +
                                "3.) Extending Door Frame Pull Up Bar " + "\n" +
                                "4.) Iron Gym Total Upper Body Workout Bar ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity

                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }

        });

        equipments5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                //set title
                alertDialogBuilder.setTitle("Equipments:");
                //set dialog message
                alertDialogBuilder
                        .setMessage("1.)Dumbbell " + "\n" +
                                "2.) Fitness Mat . ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity

                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();




            }

        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesDay1.this, PushUp.class);
                startActivity(intent);




            }


        });
    }
}