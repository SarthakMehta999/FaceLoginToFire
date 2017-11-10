package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class day2moreheavy1 extends AppCompatActivity {
    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2moreheavy1);

        Next=(Button)findViewById (R.id.button66);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day2moreheavy1.this, day2moreheavy2.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button64);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day2moreheavy1.this, day2moreheavy.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
