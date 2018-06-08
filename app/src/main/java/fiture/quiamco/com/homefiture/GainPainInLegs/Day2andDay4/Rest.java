package fiture.quiamco.com.homefiture.GainPainInLegs.Day2andDay4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.ExerciseCategories.WeeklyGainPainLegs;
import fiture.quiamco.com.homefiture.R;

public class Rest extends AppCompatActivity {
    Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest11);

        finish = (Button)findViewById(R.id.btnFinish);
        finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), WeeklyGainPainLegs.class);
                startActivity(intent);

            }
        });
    }
}
