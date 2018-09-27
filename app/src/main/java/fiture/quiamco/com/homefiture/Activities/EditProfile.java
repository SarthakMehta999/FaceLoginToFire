package fiture.quiamco.com.homefiture.Activities;

import android.app.DatePickerDialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.fragments.DatePickerFragment;

public class EditProfile extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private TextView Birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        findViews();

    }

    private void findViews() {

        Birthday = (TextView) findViewById(R.id.editBirthday);
        Birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment fragment = new DatePickerFragment();
                fragment.show(getFragmentManager(), "datePickerFragment");

            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int i, int i1, int i2) {
        Calendar cal = new GregorianCalendar(i, i1, i2);
        setDate(cal);
    }

    private void setDate(final Calendar calendar) {
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        Birthday.setText(dateFormat.format(calendar.getTime()));
    }
}
