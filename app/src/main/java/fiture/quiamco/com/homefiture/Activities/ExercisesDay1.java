package fiture.quiamco.com.homefiture.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class ExercisesDay1 extends AppCompatActivity {
     Button start;
    Button equipments1;
    Button equipments2;
    Button equipments3;
    Button equipments4;
    Button equipments5;

    Button equipmentsmondaygain1;
    Button equipmentsmondaygain2;
    Button equipmentsmondaygain3;
    Button equipmentsmondaygain4;
    Button equipmentsmondaygain5;


    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_day1);



        start = (Button) findViewById(R.id.startBtn13);

        equipments1 = (Button) findViewById(R.id.equipmentsmondaygain1);
        equipments2 = (Button) findViewById(R.id.equipmentsmondaygain2);
        equipments3 = (Button) findViewById(R.id.equipmentsmondaygain3);
        equipments4 = (Button) findViewById(R.id.equipmentsmondaygain4);
        equipments5 = (Button) findViewById(R.id.equipmentsmondaygain5);


        equipments1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                //set title
                alertDialogBuilder.setTitle("Equipments:");
                //set dialog message
                alertDialogBuilder
                        .setMessage("1.) Push up Bar Stand " +"\n" +
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
                        .setMessage("1.) Begin with a high plank position with your hands firmly placed on the ground," +
                                " right beneath your shoulders" +"\n" +
                                "2.) Now keeping a neutral spine, lower down your body until your chest is just above the floor. " + "\n" +
                                "3.) Push yourself back up to complete one rep." + "\n" +
                                "4.) For better activation of triceps, keep your arms tucked to the side while you lower down your body. ")
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
                        .setMessage("1.) Begin with a high plank position with your hands firmly placed on the ground," +
                                " right beneath your shoulders" +"\n" +
                                "2.) Now keeping a neutral spine, lower down your body until your chest is just above the floor. " + "\n" +
                                "3.) Push yourself back up to complete one rep." + "\n" +
                                "4.) For better activation of triceps, keep your arms tucked to the side while you lower down your body. ")
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
                        .setMessage("1.) Begin with a high plank position with your hands firmly placed on the ground," +
                                " right beneath your shoulders" +"\n" +
                                "2.) Now keeping a neutral spine, lower down your body until your chest is just above the floor. " + "\n" +
                                "3.) Push yourself back up to complete one rep." + "\n" +
                                "4.) For better activation of triceps, keep your arms tucked to the side while you lower down your body. ")
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
                        .setMessage("1.) Begin with a high plank position with your hands firmly placed on the ground," +
                                " right beneath your shoulders" +"\n" +
                                "2.) Now keeping a neutral spine, lower down your body until your chest is just above the floor. " + "\n" +
                                "3.) Push yourself back up to complete one rep." + "\n" +
                                "4.) For better activation of triceps, keep your arms tucked to the side while you lower down your body. ")
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
}

