package fiture.quiamco.com.homefiture.Exercises.Underweight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Exercises.LoseHeavy;
import fiture.quiamco.com.homefiture.Exercises.day1moreheavy2;
import fiture.quiamco.com.homefiture.R;

public class day1moreheavy extends AppCompatActivity {
    private Button next,back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1moreheavy);
        next=(Button)findViewById (R.id.button12);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day1moreheavy.this, day1moreheavy2.class);
                startActivity(intent);

            }
        });
        back=(Button)findViewById(R.id.button9);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day1moreheavy.this, LoseHeavy.class);
                startActivity(intent);

            }
        });
    }
}
