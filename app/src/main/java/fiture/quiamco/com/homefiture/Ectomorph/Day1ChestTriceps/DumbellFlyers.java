    package fiture.quiamco.com.homefiture.Ectomorph.Day1ChestTriceps;

    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;
    import android.os.CountDownTimer;
    import android.os.Handler;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.view.inputmethod.InputMethodManager;
    import android.widget.Button;
    import android.widget.TextView;

    import com.rilixtech.materialfancybutton.MaterialFancyButton;

    import at.markushi.ui.CircleButton;
    import fiture.quiamco.com.homefiture.R;
    import fiture.quiamco.com.homefiture.models.CircleCountDownView;

    public class DumbellFlyers extends AppCompatActivity {

        private Handler mHandler = new Handler();
        public static final int ONE_MINUTE = 60000;
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
        setContentView(R.layout.activity_dumbell_flyers);

        finish = (CircleButton)findViewById(R.id.btnFinish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(DumbellFlyers.this,Dips.class);
                startActivity(b);
            }
        });

        countDownView = (CircleCountDownView) findViewById(R.id.circle_count_down_view);
        countDownView.setVisibility(View.VISIBLE);
        mTvMinutes = (TextView) findViewById(R.id.tvMinutes);
        mTvSeconds = (TextView) findViewById(R.id.tvSec);
        countDownView.setVisibility(View.VISIBLE);
        startCountDown();
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
}
