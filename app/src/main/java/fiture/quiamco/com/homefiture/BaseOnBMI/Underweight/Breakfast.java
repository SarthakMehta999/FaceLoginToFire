package fiture.quiamco.com.homefiture.BaseOnBMI.Underweight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.R;

public class Breakfast extends AppCompatActivity {
    CardView early;
   private TextView one,two,three,four,five,go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_breakfast);

//        early = (CardView) findViewById(R.id.morningEat);
//        early.setBackgroundResource(R.drawable.morning);
        one = (TextView) findViewById(R.id.fruit);
        two = (TextView) findViewById(R.id.cereal);
        three = (TextView) findViewById(R.id.eggs);
        four = (TextView)findViewById(R.id.whole);
        five = (TextView) findViewById(R.id.drink);
        go = (TextView)findViewById(R.id.go);
        
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Breakfast.this, "(1 orange or 1 glass of orange juice)", Toast.LENGTH_SHORT).show();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Breakfast.this, "(1/2 cup of breakfast cereal or porridge, with ½ cup of full-cream milk and 2 t of sugar or honey, or 1 tablespoon of raisins)", Toast.LENGTH_SHORT).show();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Breakfast.this, "(1-2 slices of toast or rolls with 30g polyunsaturated margarine and 1-2 tablespoons of jam, honey or marmalade)", Toast.LENGTH_SHORT).show();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Breakfast.this, "(1 cup of coffee or tea with full-cream milk and 2 t of sugar)", Toast.LENGTH_SHORT).show();
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
