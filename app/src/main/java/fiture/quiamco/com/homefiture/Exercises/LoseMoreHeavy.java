package fiture.quiamco.com.homefiture.Exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import fiture.quiamco.com.homefiture.Exercises.Underweight.day1moreheavy;
import fiture.quiamco.com.homefiture.R;

public class LoseMoreHeavy extends AppCompatActivity {
    private CardView card,card2,card3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_more_heavy);
        card = (CardView)  findViewById(R.id.card1);
        card2 = (CardView)  findViewById(R.id.card2);
        card3 = (CardView)  findViewById(R.id.card3);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(LoseMoreHeavy.this,day1moreheavy.class);
                startActivity(fast);

            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(LoseMoreHeavy.this,day2moreheavy.class);
                startActivity(fast);

            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fast = new Intent(LoseMoreHeavy.this,day1heavy.class);
                startActivity(fast);

            }
        });
    }

    @Override
    public void onBackPressed(){
        finish();
    }

}
