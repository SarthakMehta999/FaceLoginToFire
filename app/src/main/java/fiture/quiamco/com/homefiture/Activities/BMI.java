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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.Infos;
import fiture.quiamco.com.homefiture.models.User;

public class BMI extends AppCompatActivity {
    private EditText height;
    private EditText weight,age;
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
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            heightStr = height.getText().toString();
            weightStr = weight.getText().toString();


//        String value1 = height.getText().toString();
//        String value2 = weight.getText().toString();
//        String id = databaseReference.push().getKey();
//         user = new User(
//               result
//        );
//        databaseReference.child(id).setValue(user);
            if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                height.setError("Please Input Value");
                weight.setError("Please Input Value");

            } else {
                proceed.setVisibility(View.VISIBLE);
            }



            if (heightStr != null && !"".equals(heightStr)
                    && weightStr != null && !"".equals(weightStr)
                 ) {
                float heightValue = Float.parseFloat(heightStr) / 100;
                float weightValue = Float.parseFloat(weightStr);

                float bmi = weightValue / (heightValue * heightValue);

//                if (ageValue <19){
//                    Toast.makeText(this, "user age is lesser than 19", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Log.d("iya age", String.valueOf(ageValue)   );
//                }
                displayBMI(bmi);
//            String id = myRef.push().getKey();
//            myRef.child(id).setValue("height:"+heightStr+"cm"+" "+"weight:"+weightStr+"Kg");
            }
        }catch (Exception ignored) {

        }
    }


    private void displayBMI(float bmi) {



        //Very Severely Underweight
        if  (Float.compare(bmi, 15f) <= 0) /*(Float.compare(ageValue,19f))*/ {
            bmiLabel = getString(R.string.very_severely_underweight);
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                        height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {
                        Intent proc = new Intent(getApplication(), Lifestyle.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        proc.putExtras(bundle);
                        startActivity(proc);
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

                        Intent proc = new Intent(getApplication(), Lifestyle.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        proc.putExtras(bundle);
                        startActivity(proc);
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
                        Intent proc = new Intent(getApplication(), Lifestyle.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        proc.putExtras(bundle);
                        startActivity(proc);
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

                        Intent proc = new Intent(getApplication(), Lifestyle.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        proc.putExtras(bundle);
                        startActivity(proc);
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

                        Intent proc = new Intent(getApplication(), Lifestyle.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        proc.putExtras(bundle);
                        startActivity(proc);
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

                        Intent proc = new Intent(getApplication(), Lifestyle.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        proc.putExtras(bundle);
                        startActivity(proc);
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

                        Intent proc = new Intent(getApplication(), Lifestyle.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        proc.putExtras(bundle);
                        startActivity(proc);
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

                        Intent proc = new Intent(getApplication(),Lifestyle.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        proc.putExtras(bundle);
                        startActivity(proc);
                    }
                }
            });

        }

        bmiStat = "BMI:" +"\n" + bmi + " \n\n"  + bmiLabel;
        result.setText(bmiStat);

        final Infos infos = new Infos();
        infos.setHeight(heightStr +""+ "cm");
        infos.setWeight(weightStr +""+ "kg");
        user.setBmiLabel(bmiLabel);

        SharedPreferences sharedPreferences = getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        Log.d("testing","weight: " + weightStr +" "+"kg");
        Log.d("testing","height: " + heightStr);
        Log.d("testing","bmi: " + String.valueOf(bmi));
        Log.d("testing","bmi label:" + bmiLabel);

        editor.putString("userWeight" ,weightStr + " "+"kg");
        editor.putString("userHeight",heightStr +" "+"cm");
        editor.putString("userBMI",String.valueOf(bmi));
        editor.putString("userBMILabel",bmiLabel);
        editor.apply();



    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
       finish();
    }


}
