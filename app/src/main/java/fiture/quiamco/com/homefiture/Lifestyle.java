package fiture.quiamco.com.homefiture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rilixtech.materialfancybutton.MaterialFancyButton;
import com.vstechlab.easyfonts.EasyFonts;

import fiture.quiamco.com.homefiture.models.User;

import static fiture.quiamco.com.homefiture.R.id.rbtnLight;

public class Lifestyle extends AppCompatActivity {
    private MaterialFancyButton proceed;
    private RadioButton light,moderate,very,most,sometimes,never,gain,lose,maintain;
    private RadioGroup fitness,workout,goal;
    private User user;
//    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        String fname = sharedPreferences.getString("userFname","");
        String lname = sharedPreferences.getString("userLname","");
        String bday= sharedPreferences.getString("birthday","");
        String gender = sharedPreferences.getString("userGender","");
        String email = sharedPreferences.getString("userEmail","");
        String pic = sharedPreferences.getString("userPic","");
        int points = sharedPreferences.getInt("samplePoint",1);
        Log.d("atayakayawa",points+"shit");
        user = new User(fname,lname,bday,gender,email,pic,points);


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

        fitness =(RadioGroup)findViewById(R.id.rgFitness);
        workout =(RadioGroup)findViewById(R.id.rgWorkout);
        goal =(RadioGroup)findViewById(R.id.rgGoal);
        proceed = (MaterialFancyButton)findViewById(R.id.btnProceed);
        light = (RadioButton)findViewById(rbtnLight);
        moderate = (RadioButton)findViewById(R.id.rbtnModerate);
//        very = (RadioButton)findViewById(R.id.rbtnVery);
        most = (RadioButton)findViewById(R.id.rbtnMost);
        sometimes = (RadioButton)findViewById(R.id.rbtnSometimes);
        never = (RadioButton)findViewById(R.id.rbtnNever);
        gain = (RadioButton)findViewById(R.id.rbtnGain);
        lose = (RadioButton)findViewById(R.id.rbtnLose);
        maintain = (RadioButton)findViewById(R.id.rbtnMaintain);





        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String id = databaseReference.push().getKey();
//                String value1 = light.getText().toString();
//                String value2 = moderate.getText().toString();
////                mRootRef.push().setValue(value1);
                Intent proc = new Intent(Lifestyle.this,NavDrawer.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", user);
                proc.putExtras(bundle);
                startActivity(proc);
            }
        });

    RadioButton rbtnVery = (RadioButton) findViewById(R.id.rbtnVery);
        if(fitness.getCheckedRadioButtonId() <=0) {//Grp is your radio group object
            proceed.setEnabled(false);
        }
        else if(fitness.getCheckedRadioButtonId() >=0){
            proceed.setEnabled(true);

        }

//        light.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String value1 = light.getText().toString();
//                String value2 = moderate.getText().toString();
////                mRootRef.push().setValue(value1,value2);
//            }
//        });



//


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}
