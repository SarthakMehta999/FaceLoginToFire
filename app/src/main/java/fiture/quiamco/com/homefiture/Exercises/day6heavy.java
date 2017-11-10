package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class day6heavy extends AppCompatActivity {
    private Button Back,Next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6heavy);

        Next=(Button)findViewById (R.id.button8);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day6heavy.this, LoseHeavy.class);
                startActivity(intent);
                finish();
            }
        });

        Back=(Button)findViewById(R.id.button8);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(day6heavy.this, LoseHeavy.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
