package fiture.quiamco.com.homefiture.DayTwoandFourWeeklyGainLowerBodyCardio;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.R;

public class Burpee extends AppCompatActivity {
    CircleButton finish;
    Button inst;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burpee);

        Toolbar toolbar = (Toolbar) findViewById(R.id.imToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(Burpee.this,ReadyStandingCalfRaise.class);
                startActivity(im);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        inst = (Button) findViewById(R.id.dialog);
        finish = (CircleButton)findViewById(R.id.btnFinish13);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Burpee.this,ReadyBurpee.class);
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
                        .setMessage("1.) Start off with a standing position with hands on the side.\n" +
                                "Drop down to a squat position but with your palms on the ground.," +"\n" +
                                "2.) Kick your legs back while keeping your arms extended.\n" +
                                "You will be now in a high plank position. " + "\n" +
                                "3.) From high plank position, immediately return to squat position." + "\n" +
                                "4.) Jump from this position to finish the stability rep. ")
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
