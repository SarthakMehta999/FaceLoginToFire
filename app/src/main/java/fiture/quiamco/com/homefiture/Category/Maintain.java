package fiture.quiamco.com.homefiture.Category;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import fiture.quiamco.com.homefiture.Exercises.GainDay_2.GStep_1;
import fiture.quiamco.com.homefiture.Exercises.Step_1;
import fiture.quiamco.com.homefiture.R;

public class Maintain extends AppCompatActivity {
    CardView jump,active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain);
        jump = (CardView) findViewById(R.id.jumpCard);
        active = (CardView) findViewById(R.id.stretchCard);
//        home = (FloatingActionButton) findViewById(R.id.fab);
        jump.setBackgroundResource(R.drawable.jumping_jack);
        active.setBackgroundResource(R.drawable.day2);

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(Maintain.this,Step_1.class);

                startActivity(inte);

            }
        });
        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inte = new Intent(Maintain.this,GStep_1.class);

                startActivity(inte);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}
