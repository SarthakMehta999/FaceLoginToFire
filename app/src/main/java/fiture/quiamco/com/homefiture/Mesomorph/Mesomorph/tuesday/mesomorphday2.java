package fiture.quiamco.com.homefiture.Mesomorph.Mesomorph.tuesday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Activities.WeeklyMesomorph;
import fiture.quiamco.com.homefiture.R;

public class mesomorphday2 extends AppCompatActivity {

    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesomorphday2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.imToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(mesomorphday2.this,WeeklyMesomorph.class);
                startActivity(im);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        start = (Button) findViewById(R.id.startBtn12);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mesomorphday2.this,MixedIntervalWrkout.class);
                startActivity(intent);
            }
        });
    }
}