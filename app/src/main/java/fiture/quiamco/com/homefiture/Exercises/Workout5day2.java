package fiture.quiamco.com.homefiture.Exercises;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import fiture.quiamco.com.homefiture.NavDrawer;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

public class Workout5day2 extends AppCompatActivity {
    private Button Next,Back;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private User user;
    private SharedPreferences sharedPreferences;
    private String id;
    private DatabaseReference userRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout5day2);
        sharedPreferences = getApplicationContext().getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        id = sharedPreferences.getString("userKey", "");
        Next=(Button)findViewById (R.id.button22);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("dailyChallenge");
        userRef = database.getReference("UserFiture");
        Bundle inBundle = getIntent().getExtras();
        user = (User) inBundle.getSerializable("user");
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(id)) {
                            Log.d("idOy","naaID");
                            final DatabaseReference matchesRefTemp = dataSnapshot.getRef().child(id);
                            matchesRefTemp.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.hasChild("4")) {
                                        Log.d("idOy","naaJOD");
                                        final DatabaseReference ref0 = dataSnapshot.getRef().child("4");
                                        ref0.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                String status = dataSnapshot.child("status").getValue().toString();
                                                if (status.equalsIgnoreCase("pending")) {
                                                    ref0.child("status").setValue("done");
                                                    userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                                            if(dataSnapshot.hasChild(id)){
                                                                final DatabaseReference refUserID = dataSnapshot.getRef().child(id);
                                                                refUserID.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                                        int userPoints = Integer.parseInt(dataSnapshot.child("userPoints").getValue().toString());
                                                                        userPoints+=30;
                                                                        Toast.makeText(Workout5day2.this, "Congratulations, you received 30 points!", Toast.LENGTH_LONG).show();
                                                                        refUserID.child("userPoints").setValue(userPoints);
                                                                        user.setUserPoints(String.valueOf(userPoints));
                                                                        Intent proc = new Intent(Workout5day2.this, NavDrawer.class);
                                                                        Bundle bundle = new Bundle();
                                                                        bundle.putSerializable("user", user);
                                                                        proc.putExtras(bundle);
                                                                        startActivity(proc);
                                                                        finish();
                                                                    }

                                                                    @Override
                                                                    public void onCancelled(DatabaseError databaseError) {

                                                                    }
                                                                });
                                                            }
                                                        }

                                                        @Override
                                                        public void onCancelled(DatabaseError databaseError) {

                                                        }
                                                    });

                                                }
                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {

                                            }
                                        });
                                    }
//
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
//                Intent intent = new Intent(Workout2day2.this, Workout3day2.class);
//                startActivity(intent);
//                finish();
            }
        });
        Back=(Button)findViewById(R.id.button21);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Workout5day2.this, Workout4day2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
