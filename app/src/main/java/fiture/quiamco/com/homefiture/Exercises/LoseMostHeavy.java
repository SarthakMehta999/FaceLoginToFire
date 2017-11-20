package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import fiture.quiamco.com.homefiture.R;

public class LoseMostHeavy extends AppCompatActivity {
    CardView card,card2,card3,card4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_most_heavy);
        card = (CardView)  findViewById(R.id.card1);
        card2 = (CardView)  findViewById(R.id.card2);
        card3 = (CardView)  findViewById(R.id.card3);
        card4 = (CardView)  findViewById(R.id.card4);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(LoseMostHeavy.this,exercise1mostheavy.class);
                startActivity(fast);

            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(LoseMostHeavy.this,exercise1mostheavyd2.class);
                startActivity(fast);

            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(LoseMostHeavy.this,exercise1mostheavyd3.class);
                startActivity(fast);
            }
        });



    }
}

