package fiture.quiamco.com.homefiture.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.Adapter.WeeklyExercisesAdapter;
import fiture.quiamco.com.homefiture.R;

public class Weekly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new WeeklyExercisesAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
//                    Intent def = new Intent(Weekly.this, PulsaIndosat.class);
//                    startActivity(def);
                    Toast.makeText(Weekly.this, "suwayan ra jud atay", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Weekly.this, "" + position,
//                            Toast.LENGTH_SHORT).show();
                }

                 else if (position == 1) {
                    Toast.makeText(Weekly.this, "suwayan ra jud atay", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(Weekly.this, "suwayan ra jud atay", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Toast.makeText(Weekly.this, "suwayan ra jud atay", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Toast.makeText(Weekly.this, "suwayan ra jud atay", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Toast.makeText(Weekly.this, "suwayan ra jud atay", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
