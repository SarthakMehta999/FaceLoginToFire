package fiture.quiamco.com.homefiture.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fiture.quiamco.com.homefiture.R;

public class Lose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}
