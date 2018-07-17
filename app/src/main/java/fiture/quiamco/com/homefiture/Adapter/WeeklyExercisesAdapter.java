package fiture.quiamco.com.homefiture.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import fiture.quiamco.com.homefiture.Maintain.MondayCoreWorkout.StartMon;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by User on 09/04/2018.
 */

public class    WeeklyExercisesAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> dailyArrayList;
    private ArrayList<User> dailyExercise;

    ImageView imageView;
    final User user = new User();
    public WeeklyExercisesAdapter(Context c) {
        mContext = c;
        dailyArrayList = new ArrayList<>();
        dailyArrayList.add("open");
        dailyArrayList.add("locked");
        dailyArrayList.add("locked");
        dailyArrayList.add("locked");
        dailyArrayList.add("locked");
        dailyArrayList.add("locked");
        dailyArrayList.add("locked");

//        user = new User(context,"");


    }

    public WeeklyExercisesAdapter(Context mContext, ArrayList<String> dailyArrayList, ArrayList<User> dailyExercise, ImageView imageView, Integer[] mThumbIds) {
        this.mContext = mContext;
        this.dailyArrayList = dailyArrayList;
        this.dailyExercise = dailyExercise;
        this.imageView = imageView;
        this.mThumbIds = mThumbIds;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        // Return true for clickable, false for not

        if (position == 0) {
            Intent def = new Intent(mContext, StartMon.class);
            mContext.startActivity(def);
            return true;
        }else if (position == 1) {

            if (user.getStatus().equals("done")) {
//                Intent defs = new Intent(mContext, Exercisesday1.class);
//                mContext.startActivity(defs);
                return true;

            }else {

                Toast.makeText(mContext, "Please perform the previous exercise to unlock this!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        else if (position == 2) {


                Toast.makeText(mContext, "Please perform the previous exercise to unlock this!", Toast.LENGTH_SHORT).show();
                return false;

        }else if(position == 3){

            Toast.makeText(mContext, "Please perform the previous exercise to unlock this!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(position==4){

            Toast.makeText(mContext, "Please perform the previous exercise to unlock this!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(position==5){

            Toast.makeText(mContext, "Please perform the previous exercise to unlock this!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(position==6){

            Toast.makeText(mContext, "Please perform the previous exercise to unlock this!", Toast.LENGTH_SHORT).show();
            return false;
        }



        return false;
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

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(130, 130));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

//
//        if (this.isLocked(position)) {
//            imageView.setImageResource(R.drawable.locknum);
//
//        } else {
//            imageView.setImageResource(mThumbIds[position]);
//        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;

    }



//    private boolean isLocked(int position) {
//
//        if (this.dailyArrayList.get(position) == "locked") {
////            if (dailyExercise.get(position).getStatus().equalsIgnoreCase("lock")) {
//
//                return true;
//
//            } else {
//                Intent defs = new Intent(mContext, Exercisesday1.class);
//                mContext.startActivity(defs);
//                return false;
//            }
//
//    }

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
