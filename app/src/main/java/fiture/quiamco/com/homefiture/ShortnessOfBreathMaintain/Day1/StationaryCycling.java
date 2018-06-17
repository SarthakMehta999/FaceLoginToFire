package fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.ExerciseCategories.WeeklyShortnessForMaintain;
import fiture.quiamco.com.homefiture.R;

public class StationaryCycling extends AppCompatActivity {
    CircleButton finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stationary_cycling);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),WeeklyShortnessForMaintain.class);
                startActivity(intent);
            }
        });
    }
}
