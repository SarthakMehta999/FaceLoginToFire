package fiture.quiamco.com.homefiture.Exercises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fiture.quiamco.com.homefiture.R;

public class Step_1 extends Activity {
    ImageView img;
//    String url ="http://agile-gorge-65786.herokuapp.com/gallery/images/59d85efb89fe4day2.jpg  ";

    private Button startButton;
    private Button pauseButton;

    private TextView timerValue;

    private long startTime = 0L;

    private Handler customHandler = new Handler();

    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_1);
        img = (ImageView) findViewById(R.id.img);

//        loadImage();

        finish = (Button) findViewById(R.id.btnFinish);

        timerValue = (TextView) findViewById(R.id.timerValue);

        startButton = (Button) findViewById(R.id.startButton);
        finish.setVisibility(View.GONE );

        finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                    Intent step = new Intent(Step_1.this, Step_2.class);
                    startActivity(step);


            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread, 0);

            }
        });
        pauseButton = (Button) findViewById(R.id.pauseButton);

        pauseButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);

            }
        });
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
//    public void loadImage() {
//        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>(){
//            @Override
//            public void onResponse(Bitmap b) {
//                img.setImageBitmap(b);
//            }
//        }, 0, 0, null,
//                new Response.ErrorListener(){
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        Toast.makeText(Step_1.this, "Some error occurred!!", Toast.LENGTH_LONG).show();
//                    }
//                });
//        RequestQueue rQueue = Volley.newRequestQueue(Step_1.this);
//        rQueue.add(request);
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}