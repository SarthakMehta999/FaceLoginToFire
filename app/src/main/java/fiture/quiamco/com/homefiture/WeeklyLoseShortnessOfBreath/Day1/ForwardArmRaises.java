package fiture.quiamco.com.homefiture.WeeklyLoseShortnessOfBreath.Day1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rilixtech.materialfancybutton.MaterialFancyButton;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.CircleCountDownView;

public class ForwardArmRaises extends AppCompatActivity {

    private Handler mHandler = new Handler();
    public static final int ONE_MINUTE = 60000;
    final Context context = this;
    private MaterialFancyButton startButton;
    private MaterialFancyButton pauseButton;
    private Handler customHandler = new Handler();
    ProgressBar progressBar;
    private MaterialFancyButton start_timer, stop_timer;
    private CountDownTimer myCountDownTimer;
    private TextView timerValue;
    private long startTime = 0L;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    protected CircleCountDownView countDownView;
    protected Button startTimerBt, cancelTimerBt;

    private TextView mTvMinutes;
    private TextView mTvSeconds;

    CircleButton finish;
    MaterialFancyButton inst;

    int progress;
    int endTime;
    CountDownTimer countDownTimer;

    int count = 0;
    int seconds =59;
    int minutes;
    int hours=0;
    int time;

    Thread t;
    boolean stop = false;
    private volatile boolean isRunning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward_arm_raises);

        Toolbar toolbar = (Toolbar) findViewById(R.id.imToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(getApplication(),InsForwardArmRaises.class);
                startActivity(im);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        finish = (CircleButton) findViewById(R.id.btnFinish);
        finish.setVisibility(View.VISIBLE);
        timerValue = (TextView) findViewById(R.id.timerValue);

        startButton = (MaterialFancyButton) findViewById(R.id.startButton);
        finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), RestForwardArmRaises.class);
                startActivity(intent);

            }
        });

        countDownView = (CircleCountDownView) findViewById(R.id.circle_count_down_view);
        countDownView.setVisibility(View.VISIBLE);
        mTvMinutes = (TextView) findViewById(R.id.tvMinutes);
        mTvSeconds = (TextView) findViewById(R.id.tvSec);
        countDownView.setVisibility(View.VISIBLE);
        startCountDown();

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

    protected void startCountDown() {


        //view.setVisibility(View.GONE); // hide button
        // show progress view
//        startTimerBt.setVisibility(View.GONE);
//        cancelTimerBt.setVisibility(View.VISIBLE); // show cancel button

        progress = 1;
        endTime = 5; // up to finish time
        minutes = endTime-1;
        time= endTime*60;

        countDownTimer = new CountDownTimer(time * 1000 /*finishTime**/, 1000 /*interval**/) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDownView.setProgress(progress, time );
                progress = progress + 1;

                if(seconds >= 0)
                {

                    mTvMinutes.setText(minutes+"");
                    if(seconds <10){
                        mTvSeconds.setText("0"+seconds);
                        seconds--;
                        count++;
                    }else{
                        mTvSeconds.setText(seconds+"");
                        seconds--;
                        count++;
                    }

                }

                if(count == 60 && minutes != 0)
                {
                    minutes--;
                    count = 0;
                    mTvMinutes.setText(minutes+"");
                    seconds = 59;
                }

            }

            @Override
            public void onFinish() {
                countDownView.setProgress(progress, time);
                //view.setVisibility(View.VISIBLE);
                cancelTimerBt.setVisibility(View.GONE);
                minutes=0;
                seconds=59;
            }
        };
        countDownTimer.start(); // start timer

        // hide softkeyboard
        View currentFocus = this.getCurrentFocus();
        if (currentFocus != null) {
            InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
//    public void startTime(){
//        startTime = SystemClock.uptimeMillis();
//        customHandler.postDelayed(updateTimerThread, 0);
//    }
//    private Runnable updateTimerThread = new Runnable() {
//
//        public void run() {
//
//            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
//
//            updatedTime = timeSwapBuff + timeInMilliseconds;
//
//            int secs = (int) (updatedTime / 1000);
//            int mins = secs / 60;
//            secs = secs % 60;
//            int milliseconds = (int) (updatedTime % 1000);
//            timerValue.setText("" + mins + ":"
//                    + String.format("%02d", secs));
//            customHandler.postDelayed(this, 0);
//            if(mins == 0 && secs == 10){
//                finish.setVisibility(View.VISIBLE);
//                timeSwapBuff += timeInMilliseconds;
//                customHandler.removeCallbacks(updateTimerThread);
//
//            }
//        }
//
//    };

}