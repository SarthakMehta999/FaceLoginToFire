package fiture.quiamco.com.homefiture.WeeklyMaintainChestPain.Day7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fiture.quiamco.com.homefiture.ExerciseCategories.WeeklyMaintainChestPain;
import fiture.quiamco.com.homefiture.R;

public class Day7MaintainChestPain extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day7_maintain_chest_pain);

        start = (Button) findViewById(R.id.startBtn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),WeeklyMaintainChestPain.class);
                startActivity(intent);
            }
        });
    }
}
