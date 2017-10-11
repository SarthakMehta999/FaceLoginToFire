package fiture.quiamco.com.homefiture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import fiture.quiamco.com.homefiture.models.User;

public class BMI extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private TextView result;
    private MaterialFancyButton proceed;
//    private User user;
    private Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bmi);

//        mRootRef = new Firebase("https://fiture-dfae4.firebaseio.com/");
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        proceed = (MaterialFancyButton) findViewById(R.id.btnProc);
        proceed.setVisibility(View.GONE);


        user = (User) getIntent().getExtras().getSerializable("user");


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (height.getText().toString().trim().equals("") || weight.getText().toString().trim().equals("") ){
                    height.setError("Please Input Value");
                    weight.setError("Please Input Value");
                }
                else {

                    Intent pt = new Intent(BMI.this, NavDrawer.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    Log.d("asdasda", String.valueOf(user.getResult()));
                    pt.putExtras(bundle);
                    startActivity(pt);
                }
            }
        });

    }
    User user = new User(
            result
    );


    public void calculateBMI(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
//        String value1 = height.getText().toString();
//        String value2 = weight.getText().toString();
//        mRootRef.push().setValue(value1,value2);
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
        }
    }


    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }

        bmiLabel = "BMI:" +"\n" + bmi + " \n\n"  + bmiLabel;
        result.setText(bmiLabel);
    }



//        public void proceedTo(View v) {
//        Intent pt = new Intent(BMI.this,NavDrawer.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("user", user);
//        pt.putExtras(bundle);
//        startActivity(pt);
//
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
       finish();
    }


}
