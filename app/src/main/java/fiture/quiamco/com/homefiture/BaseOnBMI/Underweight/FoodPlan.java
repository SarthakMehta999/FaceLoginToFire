package fiture.quiamco.com.homefiture.BaseOnBMI.Underweight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.R;

public class FoodPlan extends AppCompatActivity {
    CardView bfast,lunches,dinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_food_plan);

        Toast.makeText(this, "You are underweight, your body weight is considered too low to be healthy", Toast.LENGTH_LONG).show();
        bfast = (CardView) findViewById(R.id.breakfast);
        bfast.setPreventCornerOverlap(false);
        bfast.setBackgroundResource(R.drawable.breakfast);
        lunches = (CardView) findViewById(R.id.lunch);
        lunches.setBackgroundResource(R.drawable.lunch);


        bfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(FoodPlan.this,Breakfast.class);
                startActivity(fast);

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
