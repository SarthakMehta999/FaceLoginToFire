package fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day1.SlowWalk;

public class ShortnessDay2 extends AppCompatActivity {
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shortness_day2);
        start = (Button) findViewById(R.id.startBtn13);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),SlowWalk2.class);
                startActivity(intent);
            }
        });
    }
}
