package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class day3moreheavy1 extends AppCompatActivity {
    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3moreheavy1);

        Next=(Button)findViewById (R.id.button72);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day3moreheavy1.this, day3moreheavy2.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button71);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day3moreheavy1.this, day3moreheavy1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
