package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class Workout3day3 extends AppCompatActivity {
    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout3day3);
        Next=(Button)findViewById (R.id.button30);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Workout3day3.this, Workout4day3.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button29);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Workout3day3.this, Workout3day2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
