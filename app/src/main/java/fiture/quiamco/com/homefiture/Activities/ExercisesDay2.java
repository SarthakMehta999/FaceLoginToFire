package fiture.quiamco.com.homefiture.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import fiture.quiamco.com.homefiture.DayTwoandFourWeeklyGainLowerBodyCardio.BodyWeightsSquats;
import fiture.quiamco.com.homefiture.R;

public class ExercisesDay2 extends AppCompatActivity {
    Button start;

    Button equipments1;
    Button equipments2;
    Button equipments3;
    Button equipments4;
    Button equipments5;
    ImageButton about;
    ImageButton about1;




    final Context context = this;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercisesday2);

        about = (ImageButton) findViewById(R.id.question1);
        about1 = (ImageButton) findViewById(R.id.question2);

        start = (Button) findViewById(R.id.startBtn14);


                equipments1 = (Button) findViewById(R.id.equipmentstuesdaygain1);
                equipments2 = (Button) findViewById(R.id.equipmentstuesdaygain2);
                equipments3 = (Button) findViewById(R.id.equipmentstuesdaygain3);
                equipments4 = (Button) findViewById(R.id.equipmentstuesdaygain4);
                equipments5 = (Button) findViewById(R.id.equipmentstuesdaygain5);


                equipments1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        //set title
                        alertDialogBuilder.setTitle("Instructions:");
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

        about.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        //set title
                        alertDialogBuilder.setTitle("Instructions:");
                        //set dialog message
                        alertDialogBuilder
                                .setMessage("1.) Begin with a high plank position with your hands firmly placed on the ground," +
                                        " right beneath your shoulders" + "\n" +
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

        about1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        //set title
                        alertDialogBuilder.setTitle("Equipments:");
                        //set dialog message
                        alertDialogBuilder
                                .setMessage("1.) Begin with a high plank position with your hands firmly placed on the ground," +
                                        " right beneath your shoulders" + "\n" +
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
                                        " right beneath your shoulders" + "\n" +
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
                                        " right beneath your shoulders" + "\n" +
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

                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ExercisesDay2.this, BodyWeightsSquats.class);
                        startActivity(intent);

                    }


                });
            }
        }
