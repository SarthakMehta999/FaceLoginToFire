package fiture.quiamco.com.homefiture.Maintain.WedUpperBodyWorkout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.Maintain.MondayCoreWorkout.stability;
import fiture.quiamco.com.homefiture.R;

public class StarWed extends AppCompatActivity {
    Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wed);

        finish = (Button)findViewById(R.id.startBtn13);
        finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), standing.class);
                startActivity(intent);

            }
        });
    }
}
