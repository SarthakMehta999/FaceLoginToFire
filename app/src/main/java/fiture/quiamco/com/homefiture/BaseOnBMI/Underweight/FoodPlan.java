package fiture.quiamco.com.homefiture.BaseOnBMI.Underweight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class FoodPlan extends AppCompatActivity {
    private CardView bfast,lunches,dinners;
    private User user;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_food_plan);



        Toast.makeText(this, "You are underweight, your body weight is considered too low to be healthy", Toast.LENGTH_LONG).show();
        bfast = (CardView) findViewById(R.id.breakfast);
        dinners = (CardView) findViewById(R.id.dinner);
        lunches = (CardView) findViewById(R.id.lunch);
        bfast.setPreventCornerOverlap(false);
        lunches.setPreventCornerOverlap(false);
        dinners.setPreventCornerOverlap(false);
        bfast.setBackgroundResource(R.drawable.breakfast);
        dinners.setBackgroundResource(R.drawable.dinner);
        lunches.setBackgroundResource(R.drawable.lunch);
        back = (Button) findViewById(R.id.back);


        bfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(FoodPlan.this,Breakfast.class);
                startActivity(fast);

            }
        });

        lunches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent lunch = new Intent(FoodPlan.this,Lunch.class);
                startActivity(lunch);

            }
        });

        dinners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                Intent dine = new Intent(FoodPlan.this,Dinner.class);
                startActivity(dine);

            }
        });

//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent proc = new Intent(FoodPlan.this,NavDrawer.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("user", user);
//                proc.putExtras(bundle);
//                startActivity(proc);
//            }
//        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }

}
