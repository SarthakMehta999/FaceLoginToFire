package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class workout1day2 extends AppCompatActivity {

    private Button Next,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout1day2);

        Next=(Button)findViewById (R.id.button14);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(workout1day2.this, Workout2day2.class);
                startActivity(intent);
                finish();
            }
        });
        Back=(Button)findViewById(R.id.button13);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(workout1day2.this, LoseHeavy.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
