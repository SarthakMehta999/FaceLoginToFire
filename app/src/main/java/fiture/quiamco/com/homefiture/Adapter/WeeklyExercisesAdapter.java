package fiture.quiamco.com.homefiture.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import fiture.quiamco.com.homefiture.R;

/**
 * Created by User on 09/04/2018.
 */

public class WeeklyExercisesAdapter extends BaseAdapter {
    private Context mContext;

    public WeeklyExercisesAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(130, 130));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;

    }
    private Integer[] mThumbIds = {
            R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five, R.drawable.six,R.drawable.seven

           // R.drawable.eight,
           // R.drawable.nine, R.drawable.ten,R.drawable.eleven,R.drawable.twelve,
           // R.drawable.thirteen, R.drawable.fourteen,R.drawable.fifteen,R.drawable.sixteen,
           // R.drawable.seventeen, R.drawable.eighteen,R.drawable.nineteen,R.drawable.twenty,
           // R.drawable.twentyone, R.drawable.twentytwo,R.drawable.twentythree,R.drawable.twentyfour,
           // R.drawable.twentyfive, R.drawable.twentysix,R.drawable.twentyseven,R.drawable.twentyeight,
           // R.drawable.twentynine, R.drawable.thirty,R.drawable.thirtyone

    };

}
