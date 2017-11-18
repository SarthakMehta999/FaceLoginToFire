package fiture.quiamco.com.homefiture.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import fiture.quiamco.com.homefiture.Adapter.DailyChallengeAdapter;
import fiture.quiamco.com.homefiture.BMI;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.DailyChallengeModel;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by User on 02/09/2017.
 */

public class ProfileFragment extends Fragment{

    private ShareDialog shareDialog;
    private String TAG = "ProfileFragment";
    private CircleImageView profileImage;
    private TextView nameAndSurname, tvEmail, tvGender, tvBirthday,Bmi;
    private EditText Weight,Height;
    private MaterialFancyButton share, logout,start;
    private View rootView;
    private User user;

    private RecyclerView recyclerViewDailyChallenge;
    private ArrayList<DailyChallengeModel> dailyChallengeModels,dcmss;
    private DailyChallengeAdapter dailyChallengeAdapter;

//    private String[] pics = {
//            String.valueOf(R.drawable.nocheck1),
//            String.valueOf(R.drawable.nocheck2),
//            String.valueOf(R.drawable.nocheck3),
//            String.valueOf(R.drawable.nocheck4),
//            String.valueOf(R.drawable.nocheck5),
//            String.valueOf(R.drawable.nocheck6)
//    };

    private int pics[] = {
            R.drawable.nocheck1,
            R.drawable.nocheck2,
            R.drawable.nocheck3,
            R.drawable.nocheck4,
            R.drawable.nocheck5,
            R.drawable.nocheck6,
            R.drawable.ex1withlock,
            R.drawable.ex2withlock,
            R.drawable.ex3withlock,
            R.drawable.ex4withlock,
            R.drawable.ex5withlock
    };

    private int picsWithCheck[] = {
            R.drawable.withcheck1,
            R.drawable.withcheck2,
            R.drawable.withcheck3,
            R.drawable.withcheck4,
            R.drawable.withcheck5,
            R.drawable.withcheck6
    };
    private FirebaseDatabase database;
    private DatabaseReference myRef,userRef;
    private SharedPreferences sharedPreferences;
    private String id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        user = (User) getArguments().getSerializable("user");
        rootView = inflater.inflate(R.layout.profile_fragment,container,false);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("dailyChallenge");
        userRef = database.getReference("UserFiture");
        sharedPreferences = getContext().getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        id = sharedPreferences.getString("userKey","");
        userRef.child(id).setValue(user);
        Log.d("sampleAsesd",id);
        dcmss = new ArrayList<>();

        findViews();

        Glide.with(getActivity()).load(user.getImageUrl()).into(profileImage);
        nameAndSurname.setText(user.getfName() + " " + user.getlName());
        tvEmail.setText(user.getEmail());
        tvGender.setText(user.getGender());
        tvBirthday.setText("EXERCISE POINTS:"+" "+" "+" "+user.getUserPoints());
//        Weight.getText(user.getWeight().toString());
//        Height.setText(user.getHeight().toString());
        Bmi.setText((CharSequence) user.getResult());
        return rootView;

    }

    public void findViews(){
        profileImage = (CircleImageView) rootView.findViewById(R.id.profileImage); // find circle image view
        nameAndSurname  = (TextView) rootView.findViewById(R.id.nameAndSurname); //Find textview Id
        tvEmail = (TextView) rootView.findViewById(R.id.tvEmail);
        tvGender = (TextView) rootView.findViewById(R.id.tvGender);
        tvBirthday = (TextView) rootView.findViewById(R.id.tvBirthday);
//        Weight = (TextView) rootView.findViewById(R.id.tvWeight);
//        Height = (TextView) rootView.findViewById(R.id.tvHeight);
        Bmi = (TextView) rootView.findViewById(R.id.tvBMI);
        recyclerViewDailyChallenge = (RecyclerView) rootView.findViewById(R.id.dailyChallenge);
        dailyChallengeModels = new ArrayList<>();
        recyclerViewDailyChallenge.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        setDailyChallenge(new Callback() {
            @Override
            public void getChallenges(ArrayList<DailyChallengeModel> dailyChallengeModel) {
                Log.d("valOfI",dailyChallengeModel.size()+"");
                for (int i = 0; i < dailyChallengeModel.size(); i++) {
                    DailyChallengeModel dcm = new DailyChallengeModel();
                    if(dailyChallengeModel.get(i).getStatus().equals("done")){
                        Log.d("valOfResult",i+" "+dailyChallengeModel.size());
                        dcm.setDailyExerciseImage(picsWithCheck[i]);
                    }else{
                        dcm.setDailyExerciseImage(pics[i]);
                    }
                    dcmss.add(dcm);
                }
                dailyChallengeAdapter = new DailyChallengeAdapter(getContext(),dcmss,user);
                recyclerViewDailyChallenge.setAdapter(dailyChallengeAdapter);
            }
        });        share = (MaterialFancyButton) rootView.findViewById(R.id.share);
//        logout = (MaterialFancyButton) rootView.findViewById(R.id.logout);
        start = (MaterialFancyButton) rootView.findViewById(R.id.startActivity);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                logout();
//            }
//        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getActivity(),BMI.class);
                startActivity(login);
            }
        });
    }


    private void setDailyChallenges(){
        for (int i = 0; i < pics.length; i++) {
            DailyChallengeModel dailyChallengeModel = new DailyChallengeModel();
            dailyChallengeModel.setDailyExerciseImage(pics[i]);
            if(i==0) {
                dailyChallengeModel.setExerciseName("BENCH PRESS");
            }else if(i == 1){
                dailyChallengeModel.setExerciseName("ROMANIAN DEADLIFT");
            }else if(i == 2){
                dailyChallengeModel.setExerciseName("STANDING CALF RAISE");
            }else if(i == 3){
                dailyChallengeModel.setExerciseName("GOBLET SQUAT");
            }else if(i==4){
                dailyChallengeModel.setExerciseName("REVERSE LUNGE");
            }else if(i==5){
                dailyChallengeModel.setExerciseName("CRUNCH");
            }
            dailyChallengeModel.setStatus("pending");
            dailyChallengeModels.add(dailyChallengeModel);
            myRef.child(id).child(String.valueOf(i)).setValue(dailyChallengeModel);
        }
        Log.d("sampleAs",pics.length+"");
        dailyChallengeAdapter = new DailyChallengeAdapter(getContext(),dailyChallengeModels,user);
        recyclerViewDailyChallenge.setAdapter(dailyChallengeAdapter);
    }

    public interface Callback{
        void getChallenges(ArrayList<DailyChallengeModel> dailyChallengeModel);
    }

    private void setDailyChallenge(final Callback callback){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(id)){
                    Log.d("somethinginreturn","naa");
                    final DatabaseReference matchesRefTemp = dataSnapshot.getRef().child(id);
                    matchesRefTemp.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dailyChallengeModels = new ArrayList<>();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                DailyChallengeModel dailyChallengeModel = new DailyChallengeModel();
                                dailyChallengeModel.setStatus(snapshot.child("status").getValue()+"");
                                dailyChallengeModels.add(dailyChallengeModel);
                            }
                            Log.d("valOfI",dailyChallengeModels.size()+"set");
                            callback.getChallenges(dailyChallengeModels);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }else{
                    Log.d("somethinginreturn","wala");
                    setDailyChallenges();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static ProfileFragment newInstance(User user) {
        Bundle args = new Bundle();
        args.putSerializable("user",user);
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
    private void share(){
        shareDialog = new ShareDialog(this);
        List<String> taggedUserIds= new ArrayList<>();
        taggedUserIds.add("{USER_ID}");
        taggedUserIds.add("{USER_ID}");
        taggedUserIds.add("{USER_ID}");

        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentTitle("This is a content title")
                .setContentDescription("This is a description")
                .setShareHashtag(new ShareHashtag.Builder().setHashtag("#Fiture").build())
                .setPeopleIds(taggedUserIds)
                .setPlaceId("{PLACE_ID}")
                .build();

        shareDialog.show(content);
    }

//    private void logout(){
//        LoginManager.getInstance().logOut();
//        Intent login = new Intent(getActivity(), FacebookLoginActivity.class);
//        startActivity(login);
//    }

}
