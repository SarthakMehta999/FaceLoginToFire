package fiture.quiamco.com.homefiture.LoseExcercise.Friday.Instructions;

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
import fiture.quiamco.com.homefiture.LoseExcercise.ExercisesDay.ExercisesDay5Lose;
import fiture.quiamco.com.homefiture.LoseExcercise.Friday.SquatJacks;
import fiture.quiamco.com.homefiture.R;

public class InsSquatJacks extends AppCompatActivity {

    CircleButton finish;
    Button inst;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins_squat_jacks);

        Toolbar toolbar = (Toolbar) findViewById(R.id.imToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(InsSquatJacks.this,ExercisesDay5Lose.class);
                startActivity(im);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        inst = (Button) findViewById(R.id.dialog);
        finish = (CircleButton)findViewById(R.id.btnFinish22);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsSquatJacks.this,SquatJacks.class);
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
                        .setMessage("1: Begin by standing up, putting your feet together and your fingers " +
                                "down alongside your facets. Pull your shoulders back and push your chest out." +
                                " You’re now in the starting state of the exercise.\n" +
                                "2: Jump up, while you are inside the air and unfold your toes till they may be " +
                                "about shoulder width aside. The moment your feet contact the ground, push your hips returned." +
                                " Afterwards, bend your knees lowering your body until the crease of your hip is in line or under your knees.\n" +
                                "3: Explosively push via your heels and jump up returning your body to the beginning position. " +
                                "With this, you have now completed one repetition successfully. " +
                                "Repeat for the favored variety of reps to complete one set. ")
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
