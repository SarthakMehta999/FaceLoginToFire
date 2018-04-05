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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.Infos;
import fiture.quiamco.com.homefiture.models.User;

public class BMI extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private TextView result;
    private MaterialFancyButton proceed;
    private User user;
    private Firebase mRootRef;
    private Infos infos;
    private String id;
    String heightStr;
    String weightStr;
    String bmiLabel = "";
    String bmiStat;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("BMI");
    private DatabaseReference userBmi;

//    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bmi);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        databaseReference = FirebaseDatabase.getInstance().getReference("BMI");
        SharedPreferences sharedPreferences = getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        String fname = sharedPreferences.getString("userFname","");
        String lname = sharedPreferences.getString("userLname","");
        String bday= sharedPreferences.getString("userBday","");
        String gender = sharedPreferences.getString("userGender","");
        String email = sharedPreferences.getString("userEmail","");
        String pic = sharedPreferences.getString("userPic","");
        int points = sharedPreferences.getInt("samplePoint",1);
        Log.d("atayakayawa",points+"shit");
        user = new User(fname,lname,bday,gender,email,pic,points);
        userBmi = database.getReference("User_BMI");

        id = sharedPreferences.getString("userKey", "");

//        mRootRef = new Firebase("https://fiture-dfae4.firebaseio.com/");
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        proceed = (MaterialFancyButton) findViewById(R.id.btnProc);
        proceed.setVisibility(View.GONE);




    }


    public void calculateBMI(View v) {
        heightStr = height.getText().toString();
        weightStr = weight.getText().toString();



//        String value1 = height.getText().toString();
//        String value2 = weight.getText().toString();
//        String id = databaseReference.push().getKey();
//         user = new User(
//               result
//        );
//        databaseReference.child(id).setValue(user);
        if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("") ){
            height.setError("Please Input Value");
            weight.setError("Please Input Value");

        }

        else {
            proceed.setVisibility(View.VISIBLE);
        }


        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
//            String id = myRef.push().getKey();
//            myRef.child(id).setValue("height:"+heightStr+"cm"+" "+"weight:"+weightStr+"Kg");
        }
    }


    private void displayBMI(float bmi) {

        //Very Severely Underweight
        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                        height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {
                        Intent pt = new Intent(BMI.this, Lifestyle.class);
                        startActivity(pt);
                    }
                }
            });

            //Severely Underweight

        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                            height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {

                        Intent pt = new Intent(BMI.this, Lifestyle.class);
                        startActivity(pt);
                    }
                }
            });
            //Underweight
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                        height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {
                        Intent pt = new Intent(BMI.this, Lifestyle.class);
                        startActivity(pt);
                    }
                }
            });
        }
        //Normal
        else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                        height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {

                        Intent pt = new Intent(BMI.this, Lifestyle.class);
                        startActivity(pt);
                    }
                }
            });
            //Overweight
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                        height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {

                        Intent pt = new Intent(BMI.this, Lifestyle.class);
                        startActivity(pt);
                    }
                }
            });

            //Class 1
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
            Toast.makeText(this, "Class 1 (low-risk) obesity, if BMI is 30.0 to 34.9", Toast.LENGTH_LONG).show();
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                        height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {

                        Intent pt = new Intent(BMI.this, Lifestyle.class);
                        startActivity(pt);
                    }
                }
            });

            //Class 2
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
            Toast.makeText(this, "Class 2 (moderate-risk) obesity, if BMI is 35.0 to 39.9", Toast.LENGTH_LONG).show();
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                        height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {

                        Intent pt = new Intent(BMI.this, Lifestyle.class);
                        startActivity(pt);
                    }
                }
            });
        } else {
            //Class 3
            bmiLabel = getString(R.string.obese_class_iii);
            Toast.makeText(this, "Class 3 (high-risk) obesity, if BMI is equal to or greater than 40.0", Toast.LENGTH_LONG).show();
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                        height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {

                        Intent pt = new Intent(BMI.this, Lifestyle.class);
                        startActivity(pt);
                    }
                }
            });

        }

        bmiStat = "BMI:" +"\n" + bmi + " \n\n"  + bmiLabel;
        result.setText(bmiStat);

        final Infos infos = new Infos();
        infos.setHeight(heightStr +""+ "cm");
        infos.setWeight(weightStr +""+ "kg");

        SharedPreferences sharedPreferences = getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        Log.d("testingzz","weight: " + weightStr +" "+"kg");
        Log.d("testingzz","height: " + heightStr);
        Log.d("testingzz","bmi: " + String.valueOf(bmi));
        Log.d("testingzz","bmi label:" + bmiLabel);

        editor.putString("userWeight" ,weightStr + " "+"kg");
        editor.putString("userHeight",heightStr +" "+"cm");
        editor.putString("userBMI",String.valueOf(bmi));
        editor.putString("userBMILabel",bmiLabel);
        editor.apply();
        userBmi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(id).exists()) {
                    Log.d("Child exists", user.getlName());
                } else {
//                    alterUserData.child("Image").setValue(user.getImageUrl());
                    userBmi.child(id+"Height: " + infos.getHeight()+ " " +
                            "Weight: "+ infos.getWeight());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
       finish();
    }


}
