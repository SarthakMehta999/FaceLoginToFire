package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class workout4day1mostheavy extends AppCompatActivity {
    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout4day1mostheavy);
        Next=(Button)findViewById (R.id.button54);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(workout4day1mostheavy.this, workout5day1mostheavy.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button55);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(workout4day1mostheavy.this, workout3daymostheavy.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
