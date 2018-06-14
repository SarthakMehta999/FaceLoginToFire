package fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.ExerciseCategories.WeeklyShortnessForMaintain;

public class Hopping extends AppCompatActivity {
    CircleButton finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hopping);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),WeeklyShortnessForMaintain.class);
                startActivity(intent);
            }
        });
    }
}
