package fiture.quiamco.com.homefiture.Exercises.Underweight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Exercises.day1heavy;
import fiture.quiamco.com.homefiture.Exercises.day3heavy;
import fiture.quiamco.com.homefiture.R;

public class day2heavy extends AppCompatActivity {
    private Button Next,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2heavy);

        Next=(Button)findViewById (R.id.button3);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day2heavy.this, day3heavy.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button2);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day2heavy.this, day1heavy.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
