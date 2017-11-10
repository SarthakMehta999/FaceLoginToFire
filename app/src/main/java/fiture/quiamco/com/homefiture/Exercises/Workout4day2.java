package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class Workout4day2 extends AppCompatActivity {
    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout4day2);

        Next=(Button)findViewById (R.id.button20);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Workout4day2.this, Workout5day2.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button19);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Workout4day2.this, Workout3day2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
