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
        recyclerView.getLayoutManager().setMeasurementCacheEnabled(false);
        recyclerView.setAdapter(mAdapter);

        prepareScoreData();

    }

    private void prepareScoreData() {
        Points points = new Points("Fruit or fruit juice", "(1 orange or 1 glass of orange juice)","Lose");
        pointsList.add(points);

        points = new Points("Cereal with milk and sugar", "(1/2 cup of breakfast cereal or porridge,\n" +
                "with ½ cup of full-cream milk and 2 t of\n" +
                "sugar or honey, or 1 tablespoon of raisins)","Lose");
        pointsList.add(points);

        points = new Points("Wholewheat toast or roll with butter and jam"," (1-2 slices of toast or rolls with 30g\n" +
                "  polyunsaturated margarine and 1-2 tablespoons of\n" +
                "  jam, honey or marmalade)","");
        pointsList.add(points);

        points = new Points("Boiled egg or bacon or sausage","(fry bacon or sausage in non-stick pan)","");
        pointsList.add(points);

        points = new Points("Boiled egg or bacon or sausage","(fry bacon or sausage in non-stick pan)","");
        pointsList.add(points);

        points = new Points("Boiled egg or bacon or sausage","(fry bacon or sausage in non-stick pan)","");
        pointsList.add(points);


        mAdapter.notifyDataSetChanged();
    }

}