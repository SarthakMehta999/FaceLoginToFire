package fiture.quiamco.com.homefiture.Endomorph.HighFrequency.Day4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Activities.WeeklyEndomorphHighFreq;
import fiture.quiamco.com.homefiture.R;

public class exercisesday4 extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisesday4);

        Toolbar toolbar = (Toolbar) findViewById(R.id.imToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(exercisesday4.this,WeeklyEndomorphHighFreq.class);
                startActivity(im);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        start = (Button) findViewById(R.id.startBtn11);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercisesday4.this,DumbbellOverheadPress.class);
                startActivity(intent);
            }
        });
    }
}
