package fiture.quiamco.com.homefiture.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by User on 14/10/2017.
 */

public class PointsAdapter extends RecyclerView.Adapter <PointsAdapter.MyViewHolder> {

        private List<User> pointsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, points,category;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            points = (TextView) view.findViewById(R.id.points);
            category = (TextView) view.findViewById(R.id.category);

        }
    }

        public PointsAdapter(List<User> pointsList) {
            this.pointsList = pointsList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.leaderboard_row, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            User points = pointsList.get(position);
            holder.name.setText(points.getImageUrl());
            holder.points.setText(points.getfName()+" "+points.getlName());
            holder.category.setText(points.getGender());

        }

        @Override
        public int getItemCount() {
            return pointsList.size();
        }
    }

