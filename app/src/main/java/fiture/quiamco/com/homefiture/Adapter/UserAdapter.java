package fiture.quiamco.com.homefiture.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by User on 20/11/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{


    private Context context;
    private ArrayList<User> users;


    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;

        Log.d("dugaazxc", String.valueOf(users.size()));
        Log.d("animal",users.get(0).getImageUrl());
    }



    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_adapter,parent,false);
        Log.e("useradapter","viewhiolderuseradapter");
        UserAdapter.ViewHolder view = new UserAdapter.ViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        Log.e("line53",users.get(position).getfName());
        Glide.with(context).load(users.get(position).getImageUrl()).into(holder.image);
        holder.name.setText(users.get(position).getfName()+" " + users.get(position).getlName());
        holder.points.setText("Points: "+users.get(position).getUserPoints()+"");


    }

    @Override
    public int getItemCount() {
        Log.e("piste",users.size()+"");
        return users.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, points;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name);
            points = (TextView)itemView.findViewById(R.id.points);
            image = (ImageView)itemView.findViewById(R.id.userPic);

        }
    }
}
