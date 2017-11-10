package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Exercises.Underweight.day2heavy;
import fiture.quiamco.com.homefiture.R;

public class day1heavy extends AppCompatActivity {
private Button Next,Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1heavy);
        Next=(Button)findViewById (R.id.btnNext);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day1heavy.this, day2heavy.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.btnBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day1heavy.this, LoseHeavy.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
