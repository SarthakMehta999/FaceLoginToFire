package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class workout2day2mostheavy extends AppCompatActivity {

    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout2day2mostheavy);

        Next=(Button)findViewById (R.id.button51);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(workout2day2mostheavy.this, workout3daymostheavy.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button50);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(workout2day2mostheavy.this, day1mostheavy.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
