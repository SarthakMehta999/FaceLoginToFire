package fiture.quiamco.com.homefiture.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;

import fiture.quiamco.com.homefiture.Category.Maintain;
import fiture.quiamco.com.homefiture.R;

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
