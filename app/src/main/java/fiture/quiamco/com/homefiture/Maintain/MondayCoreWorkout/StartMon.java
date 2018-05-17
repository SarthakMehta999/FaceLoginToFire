package fiture.quiamco.com.homefiture.Maintain.MondayCoreWorkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.R;

public class StartMon extends AppCompatActivity {

    Button finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_maintain);

            finish = (Button)findViewById(R.id.startBtn13);
            finish.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    Intent intent = new Intent(getApplication(), stability.class);
                    startActivity(intent);

                }
            });



        }


}
