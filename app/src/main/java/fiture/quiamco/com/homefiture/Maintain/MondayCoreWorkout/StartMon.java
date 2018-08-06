package fiture.quiamco.com.homefiture.Maintain.MondayCoreWorkout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class StartMon extends AppCompatActivity {

    Button finish;

    Button equipments1;
    Button equipments2;
    Button equipments3;
    Button equipments4;
    Button equipments5;
    Button equipments6;
    Button equipments7;




    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_maintain);

            finish = (Button)findViewById(R.id.startBtn13);

        equipments1 = (Button) findViewById(R.id.equipmentsmondaymaintain1);
        equipments2 = (Button) findViewById(R.id.equipmentsmondaymaintain2);
        equipments3 = (Button) findViewById(R.id.equipmentsmondaymaintain3);
        equipments4 = (Button) findViewById(R.id.equipmentsmondaymaintain4);
        equipments5 = (Button) findViewById(R.id.equipmentsmondaymaintain5);
        equipments6 = (Button) findViewById(R.id.equipmentsmondaymaintain6);
        equipments7 = (Button) findViewById(R.id.equipmentsmondaymaintain7);


        equipments1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                //set title
                alertDialogBuilder.setTitle("Equipments:");
                //set dialog message
                alertDialogBuilder
                        .setMessage("1.) Push up Bar Stand " + "\n" +
                                "2.) Shape Push Up" + "\n" +
                                "3.) Tony Horton’s PowerStands" + "\n" +
                                "4.) Push Up Stand Machine ")
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

                equipments1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        //set title
                        alertDialogBuilder.setTitle("Equipments:");
                        //set dialog message
                        alertDialogBuilder
                                .setMessage("1.) Push up Bar Stand " + "\n" +
                                        "2.) Shape Push Up" + "\n" +
                                        "3.) Tony Horton’s PowerStands" + "\n" +
                                        "4.) Push Up Stand Machine ")
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


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();

            finish.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {

                    Intent intent = new Intent(getApplication(), stability.class);
                    startActivity(intent);

                }

            });

            }


        });
    }
}