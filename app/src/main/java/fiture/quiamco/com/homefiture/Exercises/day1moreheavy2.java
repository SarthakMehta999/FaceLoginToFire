package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Exercises.Underweight.day1moreheavy;
import fiture.quiamco.com.homefiture.R;

public class day1moreheavy2 extends AppCompatActivity {
    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1moreheavy2);

        Next=(Button)findViewById (R.id.button60);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day1moreheavy2.this, day1moreheavy3.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button23);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day1moreheavy2.this, day1moreheavy.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
