package fiture.quiamco.com.homefiture.LosePainInLegs.Day2;

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

public class InsKneeRolls extends AppCompatActivity {

    CircleButton finish;
    Button inst;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins_knee_rolls);

        Toolbar toolbar = (Toolbar) findViewById(R.id.imToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(InsKneeRolls.this, RestHamstringCurls.class);
                startActivity(im);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        inst = (Button) findViewById(R.id.dialog);
        finish = (CircleButton) findViewById(R.id.btnFinish20);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsKneeRolls.this, KneeRolls.class);
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
                        .setMessage("Quick tip: 1.Lie on your back, bending your knees so your feet are flat on the floor. " +
                                "2. Keep your arms at your side and your eyes on the ceiling. " +
                                "3. Simultaneously, look towards the left and slowly lower both knees to the right" +
                                " (trying to keep your knees together) until you feel a gentle stretch in your thighs and lower back. " +
                                "4. Hold this stretch for 5 seconds and then slowly lift your knees back to center. Repeat 10 times on each side, with short rests in between.")
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