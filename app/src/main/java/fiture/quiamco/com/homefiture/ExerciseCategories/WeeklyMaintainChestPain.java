package fiture.quiamco.com.homefiture.ExerciseCategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.WeeklyMaintainChestPain.Day1.Day1MaintainChestPain;
import fiture.quiamco.com.homefiture.WeeklyMaintainChestPain.Day2.Day2MaintainChestPain;
import fiture.quiamco.com.homefiture.WeeklyMaintainChestPain.Day3.Day3MaintainChestPain;
import fiture.quiamco.com.homefiture.WeeklyMaintainChestPain.Day4.Day4MaintainChestPain;
import fiture.quiamco.com.homefiture.WeeklyMaintainChestPain.Day5.Day5MaintainChestPain;
import fiture.quiamco.com.homefiture.WeeklyMaintainChestPain.Day6.Day6MaintainChestPain;
import fiture.quiamco.com.homefiture.WeeklyMaintainChestPain.Day7.Day7MaintainChestPain;

public class WeeklyMaintainChestPain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_maintain_chest_pain);

        GridView gridview = (GridView) findViewById(R.id.gridview3);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    Intent def = new Intent(getApplication(), Day1MaintainChestPain.class);
                    startActivity(def);

                }

                else if (position == 1) {
                    Intent defs = new Intent(getApplication(), Day2MaintainChestPain.class);
                    startActivity(defs);


                } else if (position == 2) {
                    Intent def = new Intent(getApplication(), Day3MaintainChestPain.class);
                    startActivity(def);


                } else if (position == 3) {
                    Intent def = new Intent(getApplication(), Day4MaintainChestPain.class);
                    startActivity(def);


                } else if (position == 4) {
                    Intent def = new Intent(getApplication(), Day5MaintainChestPain.class);
                    startActivity(def);

                } else if (position == 5) {
                    Intent def = new Intent(getApplication(), Day6MaintainChestPain.class);
                    startActivity(def);

                } else if (position == 6) {
                    Intent def = new Intent(getApplication(), Day7MaintainChestPain.class);
                    startActivity(def);


                }
            }
        });
    }

}
