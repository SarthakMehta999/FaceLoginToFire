package fiture.quiamco.com.homefiture.Exercises;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import fiture.quiamco.com.homefiture.Activities.NavDrawer;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;
import pl.droidsonroids.gif.GifTextView;

public class day3heavy extends AppCompatActivity {


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
    private SharedPreferences sharedPreferences;
    private String id;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private DatabaseReference userRef;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3heavy);

        img = (GifTextView) findViewById(R.id.gifTextView);
        sharedPreferences = getApplicationContext().getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        id = sharedPreferences.getString("userKey", "");
        Log.d("idOy",id);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("dailyChallenge");
        userRef = database.getReference("UserFiture");
        Bundle inBundle = getIntent().getExtras();
        user = (User) inBundle.getSerializable("user");
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

                myCountDownTimer = new day3heavy.MyCountDownTimer(10000, 1000);

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
                        .setMessage("1.) Attach a straight or angled bar to a high pulley and grab" +
                                " with an overhand grip palms facing down at shoulder width. " +
                                "2.) Standing upright with the torso straight and a very small inclination forward, " +
                                "bring the upper arms close to your body and perpendicular to the floor. " +
                                "The forearms should be pointing up towards the pulley as they hold the bar. This is your starting position." +
                                "  " +
                                "3.) Using the triceps, bring the bar down until it touches the front of your thighs and the arms are fully extended perpendicular to the floor." +
                                " The upper arms should always remain stationary next to your torso and only the forearms should move. " +
                                "Exhale as you perform this movement.  " )
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
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(id)){
                            Log.d("idOy","naaID");
                            final DatabaseReference matchesRefTemp = dataSnapshot.getRef().child(id);
                            matchesRefTemp.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.hasChild("6")){
                                        Log.d("idOy","naaJOD");
                                        final DatabaseReference ref0 = dataSnapshot.getRef().child("8");
                                        final DatabaseReference ref1 = dataSnapshot.getRef().child("9");

                                        ref0.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                String status = dataSnapshot.child("status").getValue().toString();
                                                if(status.equalsIgnoreCase("unlock2")){
                                                    ref0.child("status").setValue("done");
                                                    userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                                            if(dataSnapshot.hasChild(id)){
                                                                final DatabaseReference refUserID = dataSnapshot.getRef().child(id);
                                                                refUserID.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                                        ref1.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                            @Override
                                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                String status = dataSnapshot.child("status").getValue().toString();
                                                                                if(status.equalsIgnoreCase("lock")){
                                                                                    Toast.makeText(day3heavy.this, "You have unlocked a new exercise!", Toast.LENGTH_SHORT).show();
                                                                                    ref1.child("status").setValue("unlock3");
                                                                                }
                                                                            }

                                                                            @Override
                                                                            public void onCancelled(DatabaseError databaseError) {

                                                                            }
                                                                        });
                                                                        int userPoints = Integer.parseInt(dataSnapshot.child("userPoints").getValue().toString());
                                                                        userPoints+=30;
                                                                        Toast.makeText(day3heavy.this, "Congratulations, you received 30 points!", Toast.LENGTH_LONG).show();
                                                                        refUserID.child("userPoints").setValue(userPoints);
                                                                        user.setUserPoints(userPoints);
                                                                        Intent proc = new Intent(day3heavy.this, NavDrawer.class);
                                                                        Bundle bundle = new Bundle();
                                                                        bundle.putSerializable("user", user);
                                                                        proc.putExtras(bundle);
                                                                        startActivity(proc);
                                                                        finish();
                                                                    }

                                                                    @Override
                                                                    public void onCancelled(DatabaseError databaseError) {

                                                                    }
                                                                });
                                                            }
                                                        }

                                                        @Override
                                                        public void onCancelled(DatabaseError databaseError) {

                                                        }
                                                    });
                                                }
                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {

                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
//                Intent step = new Intent(exercise1mostheavy.this, exercise2mostheavy.class);
//                startActivity(step);

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
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChild(id)){
                        Log.d("idOy","naaID");
                        final DatabaseReference matchesRefTemp = dataSnapshot.getRef().child(id);
                        matchesRefTemp.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild("6")){
                                    Log.d("idOy","naaJOD");
                                    final DatabaseReference ref0 = dataSnapshot.getRef().child("8");
                                    final DatabaseReference ref1 = dataSnapshot.getRef().child("9");

                                    ref0.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            String status = dataSnapshot.child("status").getValue().toString();
                                            if(status.equalsIgnoreCase("unlock2")){
                                                ref0.child("status").setValue("done");
                                                userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                        if(dataSnapshot.hasChild(id)){
                                                            final DatabaseReference refUserID = dataSnapshot.getRef().child(id);
                                                            refUserID.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                @Override
                                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                                    ref1.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                        @Override
                                                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                                                            String status = dataSnapshot.child("status").getValue().toString();
                                                                            if(status.equalsIgnoreCase("lock")){
                                                                                Toast.makeText(day3heavy.this, "You have unlocked a new exercise!", Toast.LENGTH_SHORT).show();
                                                                                ref1.child("status").setValue("unlock3");
                                                                            }
                                                                        }

                                                                        @Override
                                                                        public void onCancelled(DatabaseError databaseError) {

                                                                        }
                                                                    });
                                                                    int userPoints = Integer.parseInt(dataSnapshot.child("userPoints").getValue().toString());
                                                                    userPoints+=30;
                                                                    Toast.makeText(day3heavy.this, "Congratulations, you received 30 points!", Toast.LENGTH_LONG).show();
                                                                    refUserID.child("userPoints").setValue(userPoints);
                                                                    user.setUserPoints(userPoints);
                                                                    Intent proc = new Intent(day3heavy.this, NavDrawer.class);
                                                                    Bundle bundle = new Bundle();
                                                                    bundle.putSerializable("user", user);
                                                                    proc.putExtras(bundle);
                                                                    startActivity(proc);
                                                                    finish();
                                                                }

                                                                @Override
                                                                public void onCancelled(DatabaseError databaseError) {

                                                                }
                                                            });
                                                        }
                                                    }

                                                    @Override
                                                    public void onCancelled(DatabaseError databaseError) {

                                                    }
                                                });
                                            }
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {

                                        }
                                    });
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
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




