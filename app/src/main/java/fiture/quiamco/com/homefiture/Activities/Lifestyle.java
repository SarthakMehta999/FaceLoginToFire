package fiture.quiamco.com.homefiture.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rilixtech.materialfancybutton.MaterialFancyButton;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.Infos;
import fiture.quiamco.com.homefiture.models.User;

import static fiture.quiamco.com.homefiture.R.id.rbtnLight;

public class Lifestyle extends AppCompatActivity {
    private MaterialFancyButton proceed;
    private RadioButton light, moderate, very, gain, lose, maintain;
    private RadioButton not;
    private CheckBox rapid, chest, heart, pain, none, dizziness, shortness;
    private RadioGroup fitness, workout, goal;
    private User user;
    String value;
    private Infos infos;
    //    DatabaseReference databaseReference;
    private DatabaseReference userAns;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lifestyle);
//
//        databaseReference = FirebaseDatabase.getInstance().getReference("answers");

        Bundle bundle = getIntent().getExtras();
//        user = (User) bundle.getSerializable("user");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
//        myRef.setValue("Hello, World!");
//        user = (User) getIntent().getExtras().getSerializable("user");
        SharedPreferences sharedPreferences = getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        userId = sharedPreferences.getString("userKey","");
        String fname = sharedPreferences.getString("userFname", "");
        String lname = sharedPreferences.getString("userLname", "");
        String bday = sharedPreferences.getString("userBday", "");
        String gender = sharedPreferences.getString("userGender", "");
        String email = sharedPreferences.getString("userEmail", "");
        String pic = sharedPreferences.getString("userPic", "");
        int points = sharedPreferences.getInt("samplePoint", 1);

        String height = sharedPreferences.getString("userHeight", "");
        String weight = sharedPreferences.getString("userWeight", "");
        String BMI = sharedPreferences.getString("userBMI", "");
        String bmiLabel = sharedPreferences.getString("userBMILabel", "");
        Log.d("atayakayawa", points + "shit");

        Log.d("testingzz", "weight: " + weight);
        Log.d("testingzz", "height: " + height);
        Log.d("testingzz", "bmi: " + BMI);

        user = new User(fname, lname, bday, gender, email, pic, points, height, weight, BMI,bmiLabel);
        userAns = database.getReference("User_Info");

//        Log.d("asdasda",user.getfName());
//        mRootRef = new Firebase("https://fiture-dfae4.firebaseio.com/");

        TextView tv_hello = (TextView) findViewById(R.id.lifestlyeText);
        tv_hello.setTypeface(EasyFonts.robotoThin(this));

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setTypeface(EasyFonts.robotoThin(this));
        TextView textView1 = (TextView) findViewById(R.id.textView6);
        textView1.setTypeface(EasyFonts.robotoThin(this));
        TextView textView2 = (TextView) findViewById(R.id.textView7);
        textView2.setTypeface(EasyFonts.robotoThin(this));
        findViews();


    }

    private void findViews() {
        //Activity
        fitness = (RadioGroup) findViewById(R.id.rgFitness);
        not = (RadioButton) findViewById(R.id.rbtnNot);
        light = (RadioButton) findViewById(rbtnLight);
        moderate = (RadioButton) findViewById(R.id.rbtnModerate);
        very = (RadioButton) findViewById(R.id.rbtnVery);
        //Fitness Goal
        goal = (RadioGroup) findViewById(R.id.rgGoal);
        gain = (RadioButton) findViewById(R.id.rbtnGain);
        lose = (RadioButton) findViewById(R.id.rbtnLose);
        maintain = (RadioButton) findViewById(R.id.rbtnMaintain);
        //Physical Conditions

        rapid = (CheckBox) findViewById(R.id.rbtnRapid);
        chest = (CheckBox) findViewById(R.id.rbtnChest);
        heart = (CheckBox) findViewById(R.id.rbtnHeart);
        pain = (CheckBox) findViewById(R.id.rbtnPain);
        dizziness = (CheckBox) findViewById(R.id.rbtnDizziness);
        shortness = (CheckBox) findViewById(R.id.rbtnShortness);
        none = (CheckBox) findViewById(R.id.rbtnNone);

        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(none.isChecked()){
                    rapid.setChecked(false);
                    chest.setChecked(false);
                    heart.setChecked(false);
                    pain.setChecked(false);
                    dizziness.setChecked(false);
                    shortness.setChecked(false);

                    rapid.setClickable(false);
                    chest.setClickable(false);
                    heart.setClickable(false);
                    pain.setClickable(false);
                    dizziness.setClickable(false);
                    shortness.setClickable(false);
                }else{
                    rapid.setClickable(true);
                    chest.setClickable(true);
                    heart.setClickable(true);
                    pain.setClickable(true);
                    dizziness.setClickable(true);
                    shortness.setClickable(true);
                }
            }
        });

//        value = light.getText().toString();
//
//        infos.setFitness(radiovalue);
        proceed = (MaterialFancyButton) findViewById(R.id.btnProceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String id = databaseReference.push().getKey();
//                String value1 = light.getText().toString();
//                String value2 = moderate.getText().toString();
////                mRootRef.push().setValue(value1);
                getSurveyResponses();
                Intent proc = new Intent(Lifestyle.this, NavDrawer.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", user);
                proc.putExtras(bundle);
                startActivity(proc);
            }
        });


//        light.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String value1 = light.getText().toString();
//                String value2 = moderate.getText().toString();
////                mRootRef.push().setValue(value1,value2);
//            }
//        });'
        String pra = "yawa gawas na";
        final Infos infos = new Infos();
        infos.setFitness(pra);
        if (fitness.getCheckedRadioButtonId() != -1) {
            int id = fitness.getCheckedRadioButtonId();
            View radioButton = fitness.findViewById(id);
            int radioId = fitness.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) fitness.getChildAt(radioId);
            String selection = (String) btn.getText();


        }
        userAns.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

//                    alterUserData.child("Image").setValue(user.getImageUrl());
                userAns.child(infos.getFitness()).setValue("Fitness: " + infos.getFitness());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Radio conditions testing pa
        if (light.isChecked() && lose.isChecked() && none.isChecked()) {
            Toast.makeText(this, "lightly active checked", Toast.LENGTH_SHORT).show();
        } else if (moderate.isChecked()) {
            Toast.makeText(this, "moderately active checked", Toast.LENGTH_SHORT).show();
        } else if (very.isChecked()) {
            Toast.makeText(this, "very active checked", Toast.LENGTH_SHORT).show();
        }


    }

    private String fitnessResponse, goalResponse;
    private ArrayList<String> ilnesses;

    public void getSurveyResponses() {
        switch (fitness.getCheckedRadioButtonId()) {
            case R.id.rbtnNot:
                fitnessResponse = "not active";
                break;
            case R.id.rbtnLight:
                fitnessResponse = "lightly active";
                break;
            case R.id.rbtnModerate:
                fitnessResponse = "moderately active";
                break;
            case R.id.rbtnVery:
                fitnessResponse = "very active";
                break;
        }

        switch (goal.getCheckedRadioButtonId()) {
            case R.id.rbtnGain:
                goalResponse = "gain more";
                break;
            case R.id.rbtnLose:
                goalResponse = "lose weight";
                break;
            case R.id.rbtnMaintain:
                goalResponse = "maintain weight";
                break;
        }

        ilnesses = new ArrayList<>();

        if (chest.isChecked()) {
            ilnesses.add("chest pain");
        }
        if (shortness.isChecked()) {
            ilnesses.add("shortness of breath");
        }
        if (dizziness.isChecked()) {
            ilnesses.add("dizziness");
        }
        if (rapid.isChecked()) {
            ilnesses.add("rapid heartbeat");
        }
        if (heart.isChecked()) {
            ilnesses.add("heart murmur");
        }
        if (pain.isChecked()) {
            ilnesses.add("pain in the lower legs");
        }
        if (none.isChecked()) {
            ilnesses.add("none");
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference surveyResponseRef = database.getReference("UserSurveyResponses");
        if(surveyResponseRef.child(userId).equals(userId)){
            Log.d("it exists",user.getfName());
        }
        else {
            surveyResponseRef.child(userId).child("fitnessLevel").setValue(fitnessResponse);
            surveyResponseRef.child(userId).child("goal").setValue(goalResponse);
            for (int i = 0; i < ilnesses.size(); i++) {
                surveyResponseRef.child(userId).child("illnesses").child(String.valueOf(i + 1)).setValue(ilnesses.get(i));
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}
