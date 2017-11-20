package fiture.quiamco.com.homefiture.Exercises;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rilixtech.materialfancybutton.MaterialFancyButton;

import fiture.quiamco.com.homefiture.R;
import pl.droidsonroids.gif.GifTextView;

public class day2moreheavy3 extends AppCompatActivity {
    GifTextView img;
    final Context context = this;
    private MaterialFancyButton startButton;
    private MaterialFancyButton pauseButton;

    ProgressBar progressBar;
    MaterialFancyButton start_timer, stop_timer;
    CountDownTimer myCountDownTimer;

    private TextView timerValue;

    private long startTime = 0L;

    private Handler customHandler = new Handler();
    private int points = 10;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    MaterialFancyButton finish;
    MaterialFancyButton inst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2moreheavy3);

        img = (GifTextView) findViewById(R.id.gifTextView);

        inst = (MaterialFancyButton) findViewById(R.id.btnInstruction);
//        loadImage();

        finish = (MaterialFancyButton) findViewById(R.id.btnFinish);

        timerValue = (TextView) findViewById(R.id.timerValue);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        start_timer = (MaterialFancyButton) findViewById(R.id.btnStart);
        stop_timer = (MaterialFancyButton) findViewById(R.id.btnStop);
        start_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myCountDownTimer = new day2moreheavy3.MyCountDownTimer(10000, 1000);

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
                        .setMessage("1.) Assume a side plank position with your forearm on the floor, but place your feet on a bench, box, or step." +
                                "Brace your core by contracting your abs forefully, as if you were about to be punched in the gut." +
                                "Your body should form a straight line from your ankles to your head. Breathe deeply for the duration of the exercise .")

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
                Intent step = new Intent(day2moreheavy3.this, LoseHeavy.class);
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



    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
            if(mins == 0 && secs == 10){
                finish.setVisibility(View.VISIBLE);
                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);

            }
        }

    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }

}


