package fiture.quiamco.com.homefiture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fiture.quiamco.com.homefiture.Adapter.Points;
import fiture.quiamco.com.homefiture.Adapter.PointsAdapter;

public class Leaderboard extends AppCompatActivity {
    private List<Points> pointsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PointsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        mAdapter = new PointsAdapter(pointsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

    }

    private void prepareMovieData() {
        Points points = new Points("Deceree Clyde Quiamco", "Points: 1234 pts","Lose");
        pointsList.add(points);

        points = new Points("Shawn Erl Sala", "Points: 2424 pts","Lose");
        pointsList.add(points);


        mAdapter.notifyDataSetChanged();
    }

}