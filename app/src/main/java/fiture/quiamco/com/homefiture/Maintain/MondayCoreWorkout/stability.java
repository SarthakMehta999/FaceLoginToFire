package fiture.quiamco.com.homefiture.Maintain.MondayCoreWorkout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.R;

public class stability extends AppCompatActivity {

    CircleButton finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        finish = (CircleButton)findViewById(R.id.btnFinish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),seated.class);
                startActivity(intent);
            }
        });
    }
}
