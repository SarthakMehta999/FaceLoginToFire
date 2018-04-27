package fiture.quiamco.com.homefiture.Ectomorph.Day2BackBiceps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class EctomorphDay2 extends AppCompatActivity {

    Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ectomorph_day2);

        finish = (Button)findViewById(R.id.btnFinish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplication(),WideGridPullUp.class);
                startActivity(b);
            }
        });
    }
}
