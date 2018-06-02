package fiture.quiamco.com.homefiture.Mesomorph.Mesomorph.CardioDay3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class mesomorphday3 extends AppCompatActivity {
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesomorphday3);



        start = (Button) findViewById(R.id.startBtn12);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mesomorphday3.this,EllipticalInterval.class);
                startActivity(intent);
            }
        });
    }
}