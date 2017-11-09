package fiture.quiamco.com.homefiture.BaseOnBMI.Underweight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.R;

public class Dinner extends AppCompatActivity {

   private TextView s1,s2,s3,s4,s5,s6,go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dinner);

        s1 = (TextView) findViewById(R.id.fj);
        s2 = (TextView) findViewById(R.id.meat);
        s3 = (TextView) findViewById(R.id.veg);
        s4 = (TextView) findViewById(R.id.starch);
        s5 = (TextView) findViewById(R.id.pudding);
        s6 = (TextView) findViewById(R.id.drink2);
        go = (TextView) findViewById(R.id.go);

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dinner.this, "(1 glass)", Toast.LENGTH_SHORT).show();
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dinner.this, "(90 g portion or 1-2 eggs)", Toast.LENGTH_SHORT).show();
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dinner.this, "(1/2 cup of cooked vegetables or ½ cup of salad with 1 T of salad dressing or mayonnaise)", Toast.LENGTH_SHORT).show();
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dinner.this, "(1/2 cup of cooked rice or pasta or potato)", Toast.LENGTH_SHORT).show();
            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dinner.this, "(1/2 cup of rice or tapioca pudding or ready-to eat puddings or 2 scoops of ice cream)", Toast.LENGTH_SHORT).show();
            }
        });
        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dinner.this, "(1 cup of coffee or tea with full-cream milk and 2 t of sugar)", Toast.LENGTH_SHORT).show();
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }

}
