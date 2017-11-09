package fiture.quiamco.com.homefiture.Exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rilixtech.materialfancybutton.MaterialFancyButton;

import fiture.quiamco.com.homefiture.R;
import pl.droidsonroids.gif.GifTextView;

import fiture.quiamco.com.homefiture.R;

public class day2Step2_2 extends AppCompatActivity {
    GifTextView img;
    //    String url ="http://agile-gorge-65786.herokuapp.com/gallery/images/59d85efb89fe4day2.jpg  ";
    final Context context = this;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    private TextView timerValue;
    ProgressBar progressBar;
    MaterialFancyButton start_timer, stop_timer;
    CountDownTimer myCountDownTimer;
    MaterialFancyButton finish;
    MaterialFancyButton inst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2_step2_2);
        img = (GifTextView) findViewById(R.id.gifTextView);

        inst = (MaterialFancyButton) findViewById(R.id.insButton);
//        loadImage();

        finish = (MaterialFancyButton) findViewById(R.id.btnNext);

//        timerValue = (TextView) findViewById(R.id.timerValue);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        start_timer = (MaterialFancyButton) findViewById(R.id.btnStart);
        stop_timer = (MaterialFancyButton) findViewById(R.id.btnPause);
        start_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myCountDownTimer = new MyCountDownTimer(10000, 1000);

                myCountDownTimer.start();


            }
        });
        stop_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myCountDownTimer.cancel();

            }
        });
        inst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                //set title
                alertDialogBuilder.setTitle("Instructions:");
                //set dialog message
                alertDialogBuilder
                        .setMessage("1.) Attach ankle weights. Grab the handles of a dip station and lift yourself until your arms" +
                                " are locked out and your body is straight up and down. Slightly bend your knees." +
                                "2.) Bend your elbows and lower your body until your upper arms are parallel to the floor. " + "\n"+
                                "3.) Use your chest, shoulders, and arms to power out of the bottom position and come to the starting position.")
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
//                                Step_1.this.finish();
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }




        });

        finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent step = new Intent(day2Step2_2.this, Step_1.class);
                startActivity(step);

            }
        });
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            int progress = (int) (millisUntilFinished / 1000);

            progressBar.setProgress(progressBar.getMax() - progress);
        }

        @Override
        public void onFinish() {
            finish();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}
