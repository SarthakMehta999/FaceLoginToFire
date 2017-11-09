package fiture.quiamco.com.homefiture.BaseOnBMI.Underweight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import fiture.quiamco.com.homefiture.R;

public class Lunch extends AppCompatActivity {

   private TextView l1,l2,l3,l4,l5,l6,l7,go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lunch);

        l1 = (TextView) findViewById(R.id.soup);
        l2 = (TextView) findViewById(R.id.meat);
        l3 = (TextView) findViewById(R.id.potato);
        l4 = (TextView) findViewById(R.id.veggie);
        l5 = (TextView) findViewById(R.id.pudding);
        l6 = (TextView) findViewById(R.id.roll);
        l7 = (TextView) findViewById(R.id.drink2);
        go = (TextView) findViewById(R.id.go);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lunch.this, "(1/2 cup)", Toast.LENGTH_SHORT).show();
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lunch.this, "(120 g portion)", Toast.LENGTH_SHORT).show();
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lunch.this, "(1 large potato or sweet potato, or rice or pasta)", Toast.LENGTH_SHORT).show();
            }
        });

        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lunch.this, "(1/2 cup of cooked vegetables or ½ cup of salad with 1 T of salad dressing or mayonnaise)", Toast.LENGTH_SHORT).show();
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lunch.this, "(1/2 cup of boiled, sweetened or canned fruit with 1 scoop of ice cream or ½ cup of custard)", Toast.LENGTH_SHORT).show();
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lunch.this, "(1 whole-wheat roll or 2-3 whole-wheat biscuits with 2 t polyunsaturated margarine and 30g of cheese)", Toast.LENGTH_SHORT).show();
            }
        });
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lunch.this, "(1 cup of coffee or tea with full-cream milk and 2 t of sugar)", Toast.LENGTH_SHORT).show();
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
