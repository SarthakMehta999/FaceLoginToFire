package fiture.quiamco.com.homefiture.LoseExcercise.Friday;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import at.markushi.ui.CircleButton;
import fiture.quiamco.com.homefiture.R;

public class JumpingLunges extends AppCompatActivity {
    CircleButton finish;
    Button inst;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumping_lunges);
    }
}
