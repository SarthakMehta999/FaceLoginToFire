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

public class PikePushUps extends AppCompatActivity {

    CircleButton finish;
    Button inst;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pike_push_ups);

        inst = (Button) findViewById(R.id.dialog);
        finish = (CircleButton)findViewById(R.id.btnFinish1);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PikePushUps.this,ReadyPikePushups.class);
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
                        .setMessage("1.) Begin with your butt in the air, legs wider than shoulder and hands placed ," +
                                " in front of your on the floor. " +"\n" +
                                "2.) Keeping your head down, swoop your body towards the floor so that your hips move towards " +
                                " the floor and your torso towards the ceiling. "+"\n" +
                                " Now get back to starting position by keeping your arms straight and hips in the air." + "\n" +
                                "4.) Once you are in the starting position, perform another rep directly without staying in the locked position for too long. ")
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

