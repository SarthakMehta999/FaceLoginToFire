package fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day2BackShoulders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day2BackShoulders.Back.Deadlift;
import fiture.quiamco.com.homefiture.R;

public class exercisesday2med extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisesday2med);



        start = (Button) findViewById(R.id.startBtn11);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercisesday2med.this, Deadlift.class);
                startActivity(intent);
            }
        });
    }
}
