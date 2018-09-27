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

import fiture.quiamco.com.homefiture.GainExercisesForFemale.Burpees;
import fiture.quiamco.com.homefiture.GainExercisesForFemale.CoolDown;
import fiture.quiamco.com.homefiture.GainExercisesForFemale.JumpingJacks;
import fiture.quiamco.com.homefiture.GainExercisesForFemale.JumpingJacks2;
import fiture.quiamco.com.homefiture.GainExercisesForFemale.PushUps;
import fiture.quiamco.com.homefiture.GainExercisesForFemale.Rest2;
import fiture.quiamco.com.homefiture.GainExercisesForFemale.TricepsDips;
import fiture.quiamco.com.homefiture.GainExercisesForFemale.WalkingLunges;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.DailyChallengeModelForGain;
import fiture.quiamco.com.homefiture.models.User;

public class DailyChallengeForGain extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<DailyChallengeModelForGain> dailyChallengegain;
    private User user;

    public DailyChallengeForGain(Context context, ArrayList<DailyChallengeModelForGain> dailyChallenge, User user) {
        this.context = context;
        this.dailyChallengegain = dailyChallengegain;
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
            DailyChallengeForGain.ViewHolder viewHolder = (DailyChallengeForGain.ViewHolder) holder;


            Glide.with(context).load(dailyChallengegain.get(position).getDailyExerciseImage()).into(viewHolder.exerciseImg);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position==0){
                        Intent pt = new Intent(context, JumpingJacks.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position==1){
                        Intent pt = new Intent(context, PushUps.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 2){
                        Intent pt = new Intent(context, TricepsDips.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 3){
                        Intent pt = new Intent(context, PushUps.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 4){
                        Intent pt = new Intent(context, WalkingLunges.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 5){
                        Intent pt = new Intent(context, PushUps.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user",user);
                        pt.putExtras(bundle);
                        context.startActivity(pt);
                    }else if(position == 6){
                        if(dailyChallengegain.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, Burpees.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            pt.putExtras(bundle);
                            context.startActivity(pt);
                        }
                    }else if(position == 7){
                        if(dailyChallengegain.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, CoolDown.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            pt.putExtras(bundle);
                            context.startActivity(pt);
                        }
                    }else if(position == 8){
                        if(dailyChallengegain.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, JumpingJacks.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            pt.putExtras(bundle);
                            context.startActivity(pt);
                        }
                    }else if(position == 9){
                        if(dailyChallengegain.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, JumpingJacks2.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            pt.putExtras(bundle);
                            context.startActivity(pt);
                        }
                    }else if(position == 10){
                        if(dailyChallengegain.get(position).getStatus().equalsIgnoreCase("lock")){
                            Toast.makeText(context, "Please perform the previous exercise, to unlock this!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent pt = new Intent(context, Rest2.class);
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
        return dailyChallengegain.size();
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
