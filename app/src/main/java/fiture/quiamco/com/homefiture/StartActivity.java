package fiture.quiamco.com.homefiture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import fiture.quiamco.com.homefiture.Category.Gain;
import fiture.quiamco.com.homefiture.Category.Lose;
import fiture.quiamco.com.homefiture.Category.Maintain;

public class StartActivity extends AppCompatActivity {

    private CardView gain,lose,maintain;
//    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Bundle bundle = getIntent().getExtras();
//        user = (User) bundle.getSerializable("user");
        setContentView(R.layout.activity_start);
        gain = (CardView) findViewById(R.id.gainCard);
        lose = (CardView) findViewById(R.id.loseCard);
        maintain = (CardView) findViewById(R.id.maintainCard);


    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gainCard:
                gains();
                break;

            case R.id.loseCard:
                loses();
                break;


            case R.id.maintainCard:
                maintains();
                break;
        }
    }

    private void gains() {
        Intent proc = new Intent(StartActivity.this,Gain.class);

        startActivity(proc);
    }

    private void loses() {
        Intent work = new Intent(StartActivity.this, Lose.class);
        startActivity(work);
    }
    private void maintains() {
        Intent work = new Intent(StartActivity.this, Maintain.class);
        startActivity(work);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }


}
