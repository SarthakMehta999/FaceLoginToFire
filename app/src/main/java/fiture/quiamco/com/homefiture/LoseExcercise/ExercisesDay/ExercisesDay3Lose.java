package fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.LoseExcercise.WednesdayCardioLunges.Instructions.InsWalkingLunge;
import fiture.quiamco.com.homefiture.R;

public class ExercisesDay3Lose extends AppCompatActivity {

    Button start;

    Button equipments1;
    Button equipments2;

    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_day3_lose);



        start = (Button) findViewById(R.id.startBtn14);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesDay3Lose.this,InsWalkingLunge.class);
                startActivity(intent);

        equipments1 = (Button) findViewById(R.id.equipmentswednesdaylose1);
        equipments2 = (Button) findViewById(R.id.equipmentswednesdaylose2);

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




            }
        });
    }
}