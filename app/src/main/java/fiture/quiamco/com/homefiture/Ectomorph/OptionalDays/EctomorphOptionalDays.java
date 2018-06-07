package fiture.quiamco.com.homefiture.Ectomorph.OptionalDays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class EctomorphOptionalDays extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ectomorph_optional_days);



        start = (Button) findViewById(R.id.startBtn14);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EctomorphOptionalDays.this,BenchPress.class);
                startActivity(intent);
            }
        });
    }
}