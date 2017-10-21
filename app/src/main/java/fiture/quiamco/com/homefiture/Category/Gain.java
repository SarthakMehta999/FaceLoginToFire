package fiture.quiamco.com.homefiture.Category;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import fiture.quiamco.com.homefiture.Exercises.GainDay_2.GStep_1;
import fiture.quiamco.com.homefiture.Exercises.Step_1;
import fiture.quiamco.com.homefiture.NavDrawer;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class Gain extends AppCompatActivity {

    FloatingActionButton home;
    CardView jump,active;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain);

//
//        Bundle bundle = getIntent().getExtras();
//        user = (User) bundle.getSerializable("user");

        jump = (CardView) findViewById(R.id.jumpCard);
        active = (CardView) findViewById(R.id.stretchCard);
       home = (FloatingActionButton) findViewById(R.id.fab);
        jump.setBackgroundResource(R.drawable.jumping_jack);
        active.setBackgroundResource(R.drawable.day2);

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(Gain.this,Step_1.class);

                startActivity(inte);

            }
        });
        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inte = new Intent(Gain.this,GStep_1.class);

                startActivity(inte);
            }
        });
//        user = (User) getIntent().getExtras().getSerializable("user");
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pt = new Intent(Gain.this, NavDrawer.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("user", user);
////                Log.d("asdasda", user.getfName());
//                pt.putExtras(bundle);
                startActivity(pt);

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
