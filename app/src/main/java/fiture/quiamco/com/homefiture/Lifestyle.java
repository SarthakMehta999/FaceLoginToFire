package fiture.quiamco.com.homefiture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import fiture.quiamco.com.homefiture.models.User;

import static fiture.quiamco.com.homefiture.R.id.rbtnLight;

public class Lifestyle extends AppCompatActivity {
    private MaterialFancyButton proceed;
    private RadioButton light,moderate,very,most,sometimes,never,gain,lose,maintain;
    private RadioGroup fitness,workout,goal;
    private User user;
    Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lifestyle);

        Bundle bundle = getIntent().getExtras();
        user = (User) bundle.getSerializable("user");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");


        Log.d("asdasda",user.getfName());
        mRootRef = new Firebase("https://fiture-dfae4.firebaseio.com/");
        findViews();
        myRef.addValueEventListener(new ValueEventListener() {
            public static final String TAG ="";

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
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
                String value1 = light.getText().toString();
                String value2 = moderate.getText().toString();
                mRootRef.push().setValue(value1);
                Intent proc = new Intent(Lifestyle.this,BMI.class);
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

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value1 = light.getText().toString();
                String value2 = moderate.getText().toString();
                mRootRef.push().setValue(value1,value2);
            }
        });



//


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}
