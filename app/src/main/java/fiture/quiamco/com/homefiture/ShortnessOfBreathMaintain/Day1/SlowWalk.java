package fiture.quiamco.com.homefiture.ShortnessOfBreathMaintain.Day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.R;

public class SlowWalk extends AppCompatActivity {
    CircleButton finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slow_walk);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),QuadricepsStretch.class);
                startActivity(intent);
            }
        });
    }
}