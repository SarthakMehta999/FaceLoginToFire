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

public class InsStraightLegRaise extends AppCompatActivity {

    CircleButton finish;
    Button inst;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins_straight_leg_raise);

        Toolbar toolbar = (Toolbar) findViewById(R.id.imToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(InsStraightLegRaise.this,RestCalfStretch.class);
                startActivity(im);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        inst = (Button) findViewById(R.id.dialog);
        finish = (CircleButton)findViewById(R.id.btnFinish20);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsStraightLegRaise.this,StraightLegRaises.class);
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
                        .setMessage("Quick tip: 1.Lie down with 1 leg bent at a 90-degree angle and your foot flat on the " +
                                "floor. Extend your other leg fully. " +
                                "2. Tighten your quadriceps (thigh muscles) within your straightened " +
                                "leg and raise it to a 45-degree angle. " +
                                "3. Hold your leg in this elevated position for about 1 or 2 seconds before slowly lowering it back to the ground. " +
                                "4. Do 3 sets of 8 to 12 repetitions. ")
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