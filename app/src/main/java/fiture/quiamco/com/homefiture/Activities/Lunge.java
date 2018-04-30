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

public class Lunge extends AppCompatActivity {

    CircleButton finish;
    Button inst;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunge);
        inst = (Button) findViewById(R.id.dialog);
        finish = (CircleButton)findViewById(R.id.btnFinish11);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lunge.this,ReadyLunge.class);
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