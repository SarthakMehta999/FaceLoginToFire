package fiture.quiamco.com.homefiture.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.R;

public class WeeklyExercises extends AppCompatActivity {

    CircleButton one,two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_exercises);

        GridView gridview = (GridView) findViewById(R.id.Hellogridview);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Log.d("shots",selectedItem);
            }
        });


    }

}
