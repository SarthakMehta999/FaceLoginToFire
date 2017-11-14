package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class day1moreheavy3 extends AppCompatActivity {
    private Button Next,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1moreheavy3);

        Next=(Button)findViewById (R.id.btnStart);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(day1moreheavy3.this, day1moreheavy4.class);
               startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.btnNext);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day1moreheavy3.this, day1moreheavy2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
