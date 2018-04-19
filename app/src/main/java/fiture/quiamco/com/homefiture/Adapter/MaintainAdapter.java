package fiture.quiamco.com.homefiture.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.MaintainModel;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by ShawnErl on 03/04/2018.
 */

public class MaintainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<MaintainModel> maintainModels;
    private User user;

    public MaintainAdapter(Context context, ArrayList<MaintainModel> maintainModels, User user) {
        this.context = context;
        this.maintainModels = maintainModels;
        this.user = user;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.maintain_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return maintainModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
