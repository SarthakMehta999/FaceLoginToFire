package fiture.quiamco.com.homefiture.Endomorph.MediumFrequency.Day3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Activities.WeeklyEndomorphMedFreq;
import fiture.quiamco.com.homefiture.R;

public class exerciseday3med extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerciseday3med);

        Toolbar toolbar = (Toolbar) findViewById(R.id.imToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(exerciseday3med.this,WeeklyEndomorphMedFreq.class);
                startActivity(im);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        start = (Button) findViewById(R.id.startBtn11);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exerciseday3med.this, Cardio.class);
                startActivity(intent);
            }
        });
    }
}