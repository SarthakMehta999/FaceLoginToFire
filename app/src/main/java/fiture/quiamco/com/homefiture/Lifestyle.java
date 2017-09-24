package fiture.quiamco.com.homefiture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Lifestyle extends AppCompatActivity {
    private Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestyle);

        findViews();
    }

    private void findViews() {
        proceed = (Button)findViewById(R.id.btnProceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceed();
            }
        });
    }

    public void Proceed() {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // to do
        finish();
    }
}
