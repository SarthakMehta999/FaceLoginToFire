package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import fiture.quiamco.com.homefiture.R;

public class LoseHeavy extends AppCompatActivity {
    CardView card,card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_heavy);

        card = (CardView)  findViewById(R.id.card1);
        card2 = (CardView)  findViewById(R.id.card2);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(LoseHeavy.this,day1heavy.class);
                startActivity(fast);

            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(LoseHeavy.this,workout1day2.class);
                startActivity(fast);

            }
        });
                }
}
