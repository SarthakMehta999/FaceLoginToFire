package fiture.quiamco.com.homefiture.ShortnessGain.Day3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.R;

public class SideLift extends AppCompatActivity {

    CircleButton finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_lift);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Ocrunch.class);
                startActivity(intent);

            }
        });



    }
}
