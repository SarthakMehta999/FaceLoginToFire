package fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day5.Quads.LegPress;
import fiture.quiamco.com.homefiture.R;

public class exercisesday5 extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisesday5);



        start = (Button) findViewById(R.id.startBtn11);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercisesday5.this,LegPress.class);
                startActivity(intent);
            }
        });
    }
}
