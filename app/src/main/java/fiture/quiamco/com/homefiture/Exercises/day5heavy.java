package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class day5heavy extends AppCompatActivity {

    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5heavy);

        Next=(Button)findViewById (R.id.button11);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day5heavy.this, day6heavy.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button10);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day5heavy.this, day6heavy.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
