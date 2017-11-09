package fiture.quiamco.com.homefiture.Exercises;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rilixtech.materialfancybutton.MaterialFancyButton;

import fiture.quiamco.com.homefiture.R;

public class Step_2 extends AppCompatActivity {
    private MaterialFancyButton startButton;
    private MaterialFancyButton pauseButton;

    ProgressBar progressBar;
    MaterialFancyButton start_timer,stop_timer;
    CountDownTimer myCountDownTimer;

    private TextView timerValue;
    final Context context = this;
    private long startTime = 0L;

    private Handler customHandler = new Handler();

    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    MaterialFancyButton finish;
    MaterialFancyButton inst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_2);
        inst = (MaterialFancyButton) findViewById(R.id.insButton);
        timerValue = (TextView) findViewById(R.id.timerValue);
        startButton = (MaterialFancyButton) findViewById(R.id.startButton);
        finish = (MaterialFancyButton) findViewById(R.id.btnNext);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        start_timer = (MaterialFancyButton) findViewById(R.id.btnStart);
        stop_timer = (MaterialFancyButton) findViewById(R.id.btnPause);
//        finish.setVisibility(View.GONE );
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
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                //set title
                alertDialogBuilder.setTitle("Instructions:");
                //set dialog message
                alertDialogBuilder
                        .setMessage("1.)Lie back on a flat bench with a dumbbell in each hand. " + " \n " +
                                "2.) Hold the weights at shoulder level and then press the weights straight over your chest.")
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
                Intent step = new Intent(Step_2.this, Step_3.class);
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

//      startButton.setOnClickListener(new View.OnClickListener() {
//
//        public void onClick(View view) {
//            startTime = SystemClock.uptimeMillis();
//            customHandler.postDelayed(updateTimerThread, 0);
//
//        }
//    });
//    pauseButton = (MaterialFancyButton) findViewById(R.id.btnPause);
//
//        pauseButton.setOnClickListener(new View.OnClickListener() {
//
//        public void onClick(View view) {
//
//            timeSwapBuff += timeInMilliseconds;
//            customHandler.removeCallbacks(updateTimerThread);
//
//        }
//    });

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
