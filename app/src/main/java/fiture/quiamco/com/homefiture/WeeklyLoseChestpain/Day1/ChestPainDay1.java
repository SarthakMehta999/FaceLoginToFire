package fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.EquipmentModel;

public class ChestPainDay1 extends AppCompatActivity {
    Button start;

    Button equipmentschestpain1;
    Button equipmentschestpain2;
    Button equipmentschestpain3;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_pain_day1);

        start = (Button) findViewById(R.id.startBtn13);

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Admin").child("Exercises");


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), fiture.quiamco.com.homefiture.WeeklyLoseChestpain.Day1.InsBodyWeightSquat.class);
                startActivity(intent);



                equipmentschestpain1 = (Button) findViewById(R.id.dialog1);
                equipmentschestpain2 = (Button) findViewById(R.id.equipmentsmonlosechestpain2);
                equipmentschestpain3 = (Button) findViewById(R.id.equipmentsmonlosechestpain3);



                equipmentschestpain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    EquipmentModel img = snapshot.getValue(EquipmentModel.class);
                                    Log.e("img", String.valueOf(img));

                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        //set title
                        alertDialogBuilder.setTitle("Instructions:");
                        //set dialog message
                        alertDialogBuilder
                                .setMessage("Quick tip: Get low, keep your chest up, and don't let your " +
                                        "knees go over your toes during this lower-body move. ")
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

//                inst.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View view) {
//                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
//                        //set title
//                        alertDialogBuilder.setTitle("Instructions:");
//                        //set dialog message
//                        alertDialogBuilder
//                                .setMessage("Quick tip: Get low, keep your chest up, and don't let your " +
//                                        "knees go over your toes during this lower-body move. ")
//                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int id) {
//                                        // if this button is clicked, close
//                                        // current activity
//
//                                    }
//                                });
//
//
//                        // create alert dialog
//                        AlertDialog alertDialog = alertDialogBuilder.create();
//                        // show it
//                        alertDialog.show();
//                    }
//
//                });

                equipmentschestpain2.setOnClickListener(new View.OnClickListener() {
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

                equipmentschestpain3.setOnClickListener(new View.OnClickListener() {
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


            }
        });
    }
}
