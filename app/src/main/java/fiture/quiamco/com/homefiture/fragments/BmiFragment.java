package fiture.quiamco.com.homefiture.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import fiture.quiamco.com.homefiture.Activities.Lifestyle;
import fiture.quiamco.com.homefiture.Activities.NavDrawer;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.Infos;
import fiture.quiamco.com.homefiture.models.User;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class BmiFragment extends Fragment {

    private TextView result;
    private MaterialFancyButton proceed, calc;
    private User user;
    private Firebase mRootRef;
    private Infos infos;
    private String id;
    String heightStr;
    String weightStr;
    String bmiLabel = "";
    String bmiStat;
    private View rootView;
    FirebaseDatabase database;
    //    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("BMI");
    private DatabaseReference userBmi;
    private TextInputEditText age, height, weight;
    MaterialFancyButton editT;
//    DatabaseReference databaseReference;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        user = (User) getArguments().getSerializable("user");
        rootView = inflater.inflate(R.layout.fragment_bmi, container, false);

        database = FirebaseDatabase.getInstance();
//        databaseReference = FirebaseDatabase.getInstance().getReference("BMI");
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        String fname = sharedPreferences.getString("userFname", "");
        String lname = sharedPreferences.getString("userLname", "");
        String bday = sharedPreferences.getString("userBday", "");
        String gender = sharedPreferences.getString("userGender", "");
        String email = sharedPreferences.getString("userEmail", "");
        String pic = sharedPreferences.getString("userPic", "");
        String ageStr = sharedPreferences.getString("userAge", "");
        String Height = sharedPreferences.getString("userHeight", "");
        String Weight = sharedPreferences.getString("userWeight", "");
        int points = sharedPreferences.getInt("samplePoint", 1);
        Log.d("atayakayawa", points + "shit");
        user = new User(fname, lname, bday, gender, email, pic, points);
        userBmi = database.getReference("User_BMI");

        id = sharedPreferences.getString("userKey", "");

//        mRootRef = new Firebase("https://fiture-dfae4.firebaseio.com/");
        height = (TextInputEditText) rootView.findViewById(R.id.height);
        weight = (TextInputEditText) rootView.findViewById(R.id.weight);
        editT = (MaterialFancyButton) rootView.findViewById(R.id.edit);
        editT.setOnClickListener(mButtonClickListener);
        age = (TextInputEditText) rootView.findViewById(R.id.age);
//        result = (TextView) findViewById(R.id.result);
//        result.setVisibility(View.VISIBLE);c
//        calc = (MaterialFancyButton) rootView.findViewById(R.id.calc);
        proceed = (MaterialFancyButton) rootView.findViewById(R.id.btnProc);
        proceed.setVisibility(View.GONE);
        age.setText(ageStr);
        height.setText(Height);
        weight.setText(Weight);
        age.setEnabled(false);
        height.setEnabled(false);
        weight.setEnabled(false);
//        editT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculateBMI();
//            }
//        });

        return rootView;

    }


    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            calculateBMI(v);
        }
    };

        private void calculateBMI(View v) {
            age.setEnabled(true);
            height.setEnabled(true);
            weight.setEnabled(true);
            try {
//            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

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
//                calc.setVisibility(View.GONE);
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
            } catch (Exception ignored) {

            }
        }

        private void displayBMI(float bmi) {


            //Very Severely Underweight
            if (Float.compare(bmi, 15f) <= 0) /*(Float.compare(ageValue,19f))*/ {
                bmiLabel = getString(R.string.very_severely_underweight);
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                            height.setError("Please Input Value");
                            weight.setError("Please Input Value");
                        } else {
                            Intent proc = new Intent(getContext(), NavDrawer.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user", user);
                            proc.putExtras(bundle);
                            startActivity(proc);
                        }
                    }
                });

                //Severely Underweight

            } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
                bmiLabel = getString(R.string.severely_underweight);
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                            height.setError("Please Input Value");
                            weight.setError("Please Input Value");
                        } else {

                            Intent proc = new Intent(getContext(), NavDrawer.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user", user);
                            proc.putExtras(bundle);
                            startActivity(proc);
                        }
                    }
                });
                //Underweight
            } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                        height.setError("Please Input Value");
                        weight.setError("Please Input Value");
                    } else {
                        Intent proc = new Intent(getContext(), NavDrawer.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        proc.putExtras(bundle);
                        startActivity(proc);
                    }
                }
            });
            }
            //Normal
            else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
                bmiLabel = getString(R.string.normal);
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                            height.setError("Please Input Value");
                            weight.setError("Please Input Value");
                        } else {

                            Intent proc = new Intent(getContext(), NavDrawer.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user", user);
                            proc.putExtras(bundle);
                            startActivity(proc);
                        }
                    }
                });
                //Overweight
            } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
                bmiLabel = getString(R.string.overweight);
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                            height.setError("Please Input Value");
                            weight.setError("Please Input Value");
                        } else {

                            Intent proc = new Intent(getContext(), NavDrawer.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user", user);
                            proc.putExtras(bundle);
                            startActivity(proc);
                        }
                    }
                });

                //Class 1
            } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
//            bmiLabel = getString(R.string.obese_class_i);
                Toast.makeText(getContext(), "Class 1 (low-risk) obesity, if BMI is 30.0 to 34.9", Toast.LENGTH_LONG).show();
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                            height.setError("Please Input Value");
                            weight.setError("Please Input Value");
                        } else {

                            Intent proc = new Intent(getContext(), NavDrawer.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user", user);
                            proc.putExtras(bundle);
                            startActivity(proc);
                        }
                    }
                });

                //Class 2
            } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
                bmiLabel = getString(R.string.obese_class_ii);
                Toast.makeText(getContext(), "Class 2 (moderate-risk) obesity, if BMI is 35.0 to 39.9", Toast.LENGTH_LONG).show();
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                            height.setError("Please Input Value");
                            weight.setError("Please Input Value");
                        } else {
                            Intent proc = new Intent(getContext(), NavDrawer.class);
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
                Toast.makeText(getContext(), "Class 3 (high-risk) obesity, if BMI is equal to or greater than 40.0", Toast.LENGTH_LONG).show();

                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
                            height.setError("Please Input Value");
                            weight.setError("Please Input Value");
                        } else {

                            Intent proc = new Intent(getContext(), NavDrawer.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user", user);
                            proc.putExtras(bundle);
                            startActivity(proc);
                        }
                    }
                });

            }

            bmiStat = "BMI:" + "\n" + bmi + " \n\n" + bmiLabel;
//        result.setText(bmiStat);
//        proceed.setVisibility(View.VISIBLE);
//        proceed.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("")) {
//                        height.setError("Please Input Value");
//                        weight.setError("Please Input Value");
//                    } else {
//
//                        Intent proc = new Intent(getApplication(),Lifestyle.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putSerializable("user", user);
//                        proc.putExtras(bundle);
//                        startActivity(proc);
//                    }
//                }
//            });


            final Infos infos = new Infos();
            infos.setHeight(heightStr + "" + "cm");
            infos.setWeight(weightStr + "" + "kg");
            user.setBmiLabel(bmiLabel);

            SharedPreferences sharedPreferences = getContext().getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = sharedPreferences.edit();

            Log.d("testing", "weight: " + weightStr + " " + "kg");
            Log.d("testing", "height: " + heightStr);
            Log.d("testing", "bmi: " + String.valueOf(bmi));
            Log.d("testing", "bmi label:" + bmiLabel);

            editor.putString("userWeight", weightStr + " " + "kg");
            editor.putString("userHeight", heightStr + " " + "cm");
            editor.putString("userBMI", String.valueOf(bmi));
            editor.putString("userBMILabel", bmiLabel);
            editor.apply();


        }


        public BmiFragment newInstance(User user) {
            Bundle args = new Bundle();
            args.putSerializable("user", user);
            BmiFragment fragment = new BmiFragment();
            fragment.setArguments(args);
            return fragment;
        }


}
