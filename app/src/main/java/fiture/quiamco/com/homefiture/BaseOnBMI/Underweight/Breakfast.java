package fiture.quiamco.com.homefiture.BaseOnBMI.Underweight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Window;
import android.view.WindowManager;

import fiture.quiamco.com.homefiture.R;

public class Breakfast extends AppCompatActivity {
    CardView early;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_breakfast);

//        early = (CardView) findViewById(R.id.morningEat);
//        early.setBackgroundResource(R.drawable.morning);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }

}
