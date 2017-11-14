package fiture.quiamco.com.homefiture.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.DailyChallengeModel;

/**
 * Created by ShawnErl on 14/11/2017.
 */

public class DailyChallengeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<DailyChallengeModel> dailyChallenge;

    public DailyChallengeAdapter(Context context, ArrayList<DailyChallengeModel> dailyChallenge) {
        this.context = context;
        this.dailyChallenge = dailyChallenge;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_challenge_profile,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof RecyclerView.ViewHolder){
            ViewHolder viewHolder = (ViewHolder) holder;
            Glide.with(context).load(dailyChallenge.get(position).getDailyExerciseImage()).into(viewHolder.exerciseImg);
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
