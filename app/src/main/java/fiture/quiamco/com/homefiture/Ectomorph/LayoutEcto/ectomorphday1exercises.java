package fiture.quiamco.com.homefiture.Ectomorph.LayoutEcto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Ectomorph.Day1ChestandTriceps.DumbellBenchPress;
import fiture.quiamco.com.homefiture.R;

public class ectomorphday1exercises extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ectomorphday1exercises);


        start = (Button) findViewById(R.id.startBtn13);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ectomorphday1exercises.this,DumbellBenchPress.class);
                startActivity(intent);
            }
        });
    }
}