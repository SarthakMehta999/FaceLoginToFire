package fiture.quiamco.com.homefiture.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.R;

public class Day3GTricepsDip extends AppCompatActivity {

    CircleButton finish;
    Button inst;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_gtriceps_dip);
        inst = (Button) findViewById(R.id.dialog);
        finish = (CircleButton)findViewById(R.id.btnFinish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Day3GTricepsDip.this,Day3GReadyTricepsDip.class);
                startActivity(intent);
            }
        });
        inst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                //set title
                alertDialogBuilder.setTitle("Instructions:");
                //set dialog message
                alertDialogBuilder
                        .setMessage("1.) For this exercise, you will need a bench or something similar like a sofa or a sturdy chair." +
                                " similar like a sofa or a sturdy chair." +
                                " Place the chair behind your back. Grip the edge of the chair with hands " +
                                " fully extended and placed shoulder width apart." + "\n" +
                                "2.) Keep your legs straight and extended forward such that it is perpendicular to your chest." + "\n" +
                                "3.) Slowly lower down your body by bending through elbows until your upper arms and forearms are perpendicular to each other." + "\n" +
                                "4.) Lift yourself back to the starting position by using your triceps. You have complete one rep successfully. ")
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
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
