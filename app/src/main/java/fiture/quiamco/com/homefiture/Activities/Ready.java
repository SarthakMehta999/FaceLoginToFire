package fiture.quiamco.com.homefiture.Activities;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rilixtech.materialfancybutton.MaterialFancyButton;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.R;

public class Ready extends AppCompatActivity {
    private Handler mHandler = new Handler();
    public static final int ONE_MINUTE = 60000;
    final Context context = this;
    private MaterialFancyButton startButton;
    private MaterialFancyButton pauseButton;
    private Handler customHandler = new Handler();
    ProgressBar progressBar;
    private MaterialFancyButton start_timer,stop_timer;
    private CountDownTimer myCountDownTimer;
    private TextView timerValue;
    private long startTime = 0L;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    CircleButton finish;
    MaterialFancyButton inst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready);
        startTime();
        finish = (CircleButton) findViewById(R.id.btnFinish);
        finish.setVisibility(View.GONE );
        timerValue = (TextView) findViewById(R.id.timerValue);

        startButton = (MaterialFancyButton) findViewById(R.id.startButton);
        finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


            }
        });

//        pauseButton = (MaterialFancyButton) findViewById(R.id.pauseButton);
//
//        pauseButton.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//
//                timeSwapBuff += timeInMilliseconds;
//                customHandler.removeCallbacks(updateTimerThread);
//
//            }
//        });
    }
    public void startTime(){
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);
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
                    + String.format("%02d", secs));
            customHandler.postDelayed(this, 0);
            if(mins == 0 && secs == 10){
                finish.setVisibility(View.VISIBLE);
                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);

            }
        }

    };

    }