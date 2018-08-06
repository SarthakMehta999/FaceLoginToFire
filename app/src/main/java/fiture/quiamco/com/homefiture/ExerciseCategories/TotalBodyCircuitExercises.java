package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.GainExercisesForFemale.JumpingJacks;
import fiture.quiamco.com.homefiture.R;

public class TotalBodyCircuitExercises extends AppCompatActivity {

    Button start;

    Button equipments1;
    Button equipments2;
    Button equipments3;
    Button equipments4;
    Button equipments5;
    Button equipments6;
    Button equipments7;
    Button equipments8;
    Button equipments9;
    Button equipments10;
    Button equipments11;


    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_body_circuit_exercises);


        start = (Button) findViewById(R.id.startBtn13);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TotalBodyCircuitExercises.this,JumpingJacks.class);
                startActivity(intent);

                equipments1 = (Button) findViewById(R.id.equipmentstotalbodycircuit1);
                equipments2 = (Button) findViewById(R.id.equipmentstotalbodycircuit2);
                equipments3 = (Button) findViewById(R.id.equipmentstotalbodycircuit3);
                equipments4 = (Button) findViewById(R.id.equipmentstotalbodycircuit4);
                equipments5 = (Button) findViewById(R.id.equipmentstotalbodycircuit5);
                equipments6 = (Button) findViewById(R.id.equipmentstotalbodycircuit6);
                equipments7 = (Button) findViewById(R.id.equipmentstotalbodycircuit7);
                equipments8 = (Button) findViewById(R.id.equipmentstotalbodycircuit8);
                equipments9 = (Button) findViewById(R.id.equipmentstotalbodycircuit9);
                equipments10 = (Button) findViewById(R.id.equipmentstotalbodycircuit10);
                equipments11 = (Button) findViewById(R.id.equipmentstotalbodycircuit11);

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


                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        // show it
                        alertDialog.show();




                    }

                });

                equipments6.setOnClickListener(new View.OnClickListener() {
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


                equipments7.setOnClickListener(new View.OnClickListener() {
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


                equipments8.setOnClickListener(new View.OnClickListener() {
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



                equipments9.setOnClickListener(new View.OnClickListener() {
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



                equipments10.setOnClickListener(new View.OnClickListener() {
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

                equipments11.setOnClickListener(new View.OnClickListener() {
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

            }


        });
    }
}