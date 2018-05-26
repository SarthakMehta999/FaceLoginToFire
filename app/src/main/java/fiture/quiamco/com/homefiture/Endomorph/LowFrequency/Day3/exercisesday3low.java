package fiture.quiamco.com.homefiture.Endomorph.LowFrequency.Day3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Endomorph.LowFrequency.Day3.Biceps.BarbellCurl;
import fiture.quiamco.com.homefiture.R;

public class exercisesday3low extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisesday3low);


        start = (Button) findViewById(R.id.startBtn11);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercisesday3low.this, BarbellCurl.class);
                startActivity(intent);
            }
        });
    }
}