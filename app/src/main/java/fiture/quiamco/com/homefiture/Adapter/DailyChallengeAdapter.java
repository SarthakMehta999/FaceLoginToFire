package fiture.quiamco.com.homefiture.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fiture.quiamco.com.homefiture.Exercises.Underweight.day2heavy;
import fiture.quiamco.com.homefiture.Exercises.Workout6day2;
import fiture.quiamco.com.homefiture.Activities.day1heavy;
import fiture.quiamco.com.homefiture.Exercises.day3heavy;
import fiture.quiamco.com.homefiture.Exercises.day4heavy;
import fiture.quiamco.com.homefiture.Exercises.day5heavy;
import fiture.quiamco.com.homefiture.Exercises.exercise1mostheavy;
import fiture.quiamco.com.homefiture.Exercises.exercise2mostheavy;
import fiture.quiamco.com.homefiture.Exercises.exercise3mostheavy;
import fiture.quiamco.com.homefiture.Exercises.exercise4mostheavy;
import fiture.quiamco.com.homefiture.Exercises.exercise5mostheavy;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.DailyChallengeModel;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by ShawnErl on 14/11/2017.
 */

public class DailyChallengeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<DailyChallengeModel> dailyChallenge;
    private User user;

    public DailyChallengeAdapter(Context context, ArrayList<DailyChallengeModel> dailyChallenge, User user) {
        this.context = context;
        this.dailyChallenge = dailyChallenge;
        this.user = user;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_challenge_profile,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof RecyclerView.ViewHolder){
            ViewHolder viewHolder = (ViewHolder) holder;
            Glide.with(context).load(dailyChallenge.get(position).getDailyExerciseImage()).into(viewHolder.exerciseImg);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position==0){
                        Intent pt = new Intent(context, exercise1mostheavy.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position==1){
                        Intent pt = new Intent(context, exercise2mostheavy.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 2){
                        Intent pt = new Intent(context, exercise3mostheavy.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 3){
                        Intent pt = new Intent(context, exercise4mostheavy.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 4){
                        Intent pt = new Intent(context, exercise5mostheavy.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 5){
                        Intent pt = new Intent(context, Workout6day2.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 6){
                        if(dailyChallenge.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, day1heavy.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            pt.putExtras(bundle);
                            context.startActivity(pt);
                        }
                    }else if(position == 7){
                        if(dailyChallenge.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, day2heavy.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            pt.putExtras(bundle);
                            context.startActivity(pt);
                        }
                    }else if(position == 8){
                        if(dailyChallenge.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, day3heavy.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            pt.putExtras(bundle);
                            context.startActivity(pt);
                        }
                    }else if(position == 9){
                        if(dailyChallenge.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, day4heavy.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            pt.putExtras(bundle);
                            context.startActivity(pt);
                        }
                    }else if(position == 10){
                        if(dailyChallenge.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, day5heavy.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            pt.putExtras(bundle);
                            context.startActivity(pt);
                        }
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dailyChallenge.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView exerciseImg;
        TextView sportName;

        public ViewHolder(View itemView) {
            super(itemView);
            exerciseImg = (ImageView) itemView.findViewById(R.id.exerciseImage);
        }
    }
}



