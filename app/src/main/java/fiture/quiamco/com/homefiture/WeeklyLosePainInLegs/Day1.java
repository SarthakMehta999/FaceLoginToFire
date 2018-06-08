package fiture.quiamco.com.homefiture.WeeklyLosePainInLegs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.WeeklyLosePainInLegs.Day1Instructions.InsCalfStretch;

public class Day1 extends AppCompatActivity {
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1);


        start = (Button) findViewById(R.id.startBtn13);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),InsCalfStretch.class);
                startActivity(intent);
            }
        });
    }
}
