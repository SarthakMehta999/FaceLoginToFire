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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import fiture.quiamco.com.homefiture.Activities.Lifestyle;
import fiture.quiamco.com.homefiture.Activities.Weekly;
import fiture.quiamco.com.homefiture.Activities.WeeklyLose;
import fiture.quiamco.com.homefiture.Adapter.DailyChallengeAdapter;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.TotalBodyCircuit.TotalBodyCircuitExercises;
import fiture.quiamco.com.homefiture.models.DailyChallengeModel;
import fiture.quiamco.com.homefiture.models.Infos;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by User on 02/09/2017.
 */

public class ProfileFragment extends Fragment {

    private ShareDialog shareDialog;
    private String TAG = "ProfileFragment";
    private CircleImageView profileImage;
    private TextView nameAndSurname, tvEmail, tvGender, tvBirthday, Bmi,tvWeight,tvHeight;
    private EditText Weight, Height;
    private Button share, logout, start;
    private MaterialFancyButton challenge;
    private View rootView;
    private User user;
    private Infos infos;
    private RecyclerView recyclerViewDailyChallenge;
    private ArrayList<DailyChallengeModel> dailyChallengeModels, dcmss;
    private DailyChallengeAdapter dailyChallengeAdapter;
    String surveyResponse,goal,ilness;
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
            R.drawable.loc1,
            R.drawable.loc2,
            R.drawable.loc3,
            R.drawable.loc4,
            R.drawable.loc5
    };

    private int picswithoutcheck[] = {
            R.drawable.nocheck1,
            R.drawable.nocheck2,
            R.drawable.nocheck3,
            R.drawable.nocheck4,
            R.drawable.nocheck6
    };

    private int picsWithCheck[] = {
            R.drawable.chec1,
            R.drawable.chec2,
            R.drawable.chec3,
            R.drawable.chec4,
            R.drawable.chec5,
            R.drawable.chec6,
            R.drawable.chec1,
            R.drawable.chec2,
            R.drawable.chec3,
            R.drawable.chec4,
            R.drawable.chec5
    };
    private FirebaseDatabase database;
    private DatabaseReference myRef, userRef,alterUserData;
    private SharedPreferences sharedPreferences;
    private String id;
    private String bmiLabel;
    private int j = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        user = (User) getArguments().getSerializable("user");
        infos = (Infos) getArguments().getSerializable("infos");
        rootView = inflater.inflate(R.layout.profile_fragment, container, false);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("dailyChallenge");
        userRef = database.getReference("UserFiture");
        alterUserData = database.getReference("User Data");
        sharedPreferences = getContext().getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
        id = sharedPreferences.getString("userKey", "");
        bmiLabel = sharedPreferences.getString("userBMILabel", "");
        surveyResponse = sharedPreferences.getString("userFitnessResponse","");
        goal = sharedPreferences.getString("userGoal","");
        ilness = sharedPreferences.getString("userIlness","");
        Log.d("huhu",goal);



        userRef.child(id).setValue(user);
        Log.d("sampleAsesd", id);
        dcmss = new ArrayList<>();
        findViews();

        Glide.with(getActivity()).load(user.getImageUrl()).into(profileImage);
        nameAndSurname.setText(user.getfName() + " " + user.getlName());
//        tvEmail.setText(user.getEmail());
        tvGender.setText(user.getGender());
        tvHeight.setText(user.getHeight());
        tvWeight.setText(user.getWeight());
//        tvBirthday.setText(user.getBirthDate());
//        Weight.getText(user.getWeight().toString());
//
        alterUserData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(user.getfName()).exists()) {
                    Log.d("Child exists", user.getlName());
                } else {
//                    alterUserData.child("Image").setValue(user.getImageUrl());
                    alterUserData.child(user.getfName()).setValue("Name: " + user.getfName()+" " + user.getlName() +
                            System.getProperty("line.separator")+ "Gender: "+ user.getGender() + " " + "Points: " + user.getUserPoints() );
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return rootView;

    }

    public void findViews() {
//        DatabaseReference ref = database.getReference("https://fiture-dfae4.firebaseio.com/UserFiture/bmiLabel ");
        profileImage = (CircleImageView) rootView.findViewById(R.id.profileImage); // find circle image view
        nameAndSurname = (TextView) rootView.findViewById(R.id.nameAndSurname); //Find textview Id
        challenge = (MaterialFancyButton) rootView.findViewById(R.id.challenge);
//        tvEmail = (TextView) rootView.findViewById(R.id.tvEmail);
        tvGender = (TextView) rootView.findViewById(R.id.tvGender);
        tvBirthday = (TextView) rootView.findViewById(R.id.tvBirthday);
        tvWeight = (TextView) rootView.findViewById(R.id.tvWeight);
        tvHeight = (TextView) rootView.findViewById(R.id.tvHeight);
//        Weight = (TextView) rootView.findViewById(R.id.tvWeight);
//        Height = (TextView) rootView.findViewById(R.id.tvHeight);

//        String fname = sharedPreferences.getString("userFname", "");
//        String lname = sharedPreferences.getString("userLname", "");
//        String bday = sharedPreferences.getString("userBday", "");
//        String gender = sharedPreferences.getString("userGender", "");
//        String email = sharedPreferences.getString("userEmail", "");
//        String pic = sharedPreferences.getString("userPic", "");
//        int points = sharedPreferences.getInt("samplePoint", 1);
//
//        String height = sharedPreferences.getString("userHeight", "");
//        String weight = sharedPreferences.getString("userWeight", "");
//        String BMI = sharedPreferences.getString("userBMI", "");
//        String bmiLabel = sharedPreferences.getString("userBMILabel", "");
//
//
//        user = new User(fname, lname, bday, gender, email, pic, points, height, weight, BMI,bmiLabel);

        recyclerViewDailyChallenge = (RecyclerView) rootView.findViewById(R.id.dailyChallenge);
    recyclerViewDailyChallenge.setVisibility(View.GONE);
        dailyChallengeModels = new ArrayList<>();
        recyclerViewDailyChallenge.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        setDailyChallenge(new Callback() {
            @Override
            public void getChallenges(ArrayList<DailyChallengeModel> dailyChallengeModel) {
                Log.d("valOfI", dailyChallengeModel.size() + "");
                for (int i = 0; i < dailyChallengeModel.size(); i++) {
                    DailyChallengeModel dcm = new DailyChallengeModel();
                    if (dailyChallengeModel.get(i).getStatus().equals("done")) {
                        Log.d("valOfResult", i + " " + dailyChallengeModel.size());
                        dcm.setDailyExerciseImage(picsWithCheck[i]);
                        dcm.setStatus("done");
                    } else if (dailyChallengeModel.get(i).getStatus().equalsIgnoreCase("lock")) {
                        dcm.setDailyExerciseImage(pics[i]);
                        dcm.setStatus("lock");
                    } else if(dailyChallengeModel.get(i).getStatus().equalsIgnoreCase("unlock")){
                        dcm.setDailyExerciseImage(picswithoutcheck[0]);
                        dcm.setStatus("unlock");
                    }else if(dailyChallengeModel.get(i).getStatus().equalsIgnoreCase("unlock1")) {
                        dcm.setDailyExerciseImage(picswithoutcheck[1]);
                        dcm.setStatus("unlock");
                    } else if(dailyChallengeModel.get(i).getStatus().equalsIgnoreCase("unlock2")) {
                        dcm.setDailyExerciseImage(picswithoutcheck[2]);
                        dcm.setStatus("unlock");
                    } else if(dailyChallengeModel.get(i).getStatus().equalsIgnoreCase("unlock3")) {
                        dcm.setDailyExerciseImage(picswithoutcheck[3]);
                        dcm.setStatus("unlock");
                    }else if(dailyChallengeModel.get(i).getStatus().equalsIgnoreCase("unlock4")) {
                        dcm.setDailyExerciseImage(picswithoutcheck[4]);
                        dcm.setStatus("unlock");
                    }else{
                        dcm.setDailyExerciseImage(pics[i]);
                        dcm.setStatus("pending");
                    }
                    dcmss.add(dcm);
                }
                dailyChallengeAdapter = new DailyChallengeAdapter(getContext(), dcmss, user);
                recyclerViewDailyChallenge.setAdapter(dailyChallengeAdapter);
            }
        });
        share = (Button) rootView.findViewById(R.id.share);
//        logout = (MaterialFancyButton) rootView.findViewById(R.id.logout);
        start = (Button) rootView.findViewById(R.id.startActivity);
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
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                User profile = dataSnapshot.getValue(User.class);
//                Log.d("please",profile.getBmiLabel());
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });
        switch (bmiLabel) {
            case "Underweight":
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent login = new Intent(getActivity(), Weekly.class);
                        startActivity(login);
                    }
                });
                break;
            case "Overweight":
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent login = new Intent(getActivity(), WeeklyLose.class);
                        startActivity(login);
                    }
                });
                break;
            case "Normal":

                switch (goal) {
                    case "maintain weight":
                        start.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent login = new Intent(getActivity(), TotalBodyCircuitExercises.class);
                                startActivity(login);
                            }
                        });
                        break;
                    case "lose weight":
                        start.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent login = new Intent(getActivity(), WeeklyLose.class);
                                startActivity(login);
                            }
                        });
                        break;
                    default:
                        start.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent login = new Intent(getActivity(), Lifestyle.class);
                                startActivity(login);
                            }
                        });
                        break;
                }
                break;
            default:
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent login = new Intent(getActivity(), Lifestyle.class);
                        startActivity(login);
                    }
                });
                break;
        }
        challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewDailyChallenge.setVisibility(View.VISIBLE);
            }
        });
    }


    private void setDailyChallenges() {
        for (int i = 0; i < pics.length; i++) {
            DailyChallengeModel dailyChallengeModel = new DailyChallengeModel();
            if (i == 0) {
                dailyChallengeModel.setExerciseName("BENCH PRESS");
                dailyChallengeModel.setStatus("pending");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);

            } else if (i == 1) {
                dailyChallengeModel.setExerciseName("ROMANIAN DEADLIFT");
                dailyChallengeModel.setStatus("pending");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);

            } else if (i == 2) {
                dailyChallengeModel.setExerciseName("STANDING CALF RAISE");
                dailyChallengeModel.setStatus("pending");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);

            } else if (i == 3) {
                dailyChallengeModel.setExerciseName("GOBLET SQUAT");
                dailyChallengeModel.setStatus("pending");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);

            } else if (i == 4) {
                dailyChallengeModel.setExerciseName("REVERSE LUNGE");
                dailyChallengeModel.setStatus("pending");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);
            } else if (i == 5) {
                dailyChallengeModel.setExerciseName("CRUNCH");
                dailyChallengeModel.setStatus("pending");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);
            } else if (i == 6) {
                dailyChallengeModel.setExerciseName("Front Squat");
                dailyChallengeModel.setStatus("lock");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);
            } else if (i == 7) {
                dailyChallengeModel.setExerciseName("Neutral Grip Pull-up");
                dailyChallengeModel.setStatus("lock");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);

            } else if (i == 8) {
                dailyChallengeModel.setExerciseName("Triceps Pushdown");
                dailyChallengeModel.setStatus("lock");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);

            } else if (i == 9) {
                dailyChallengeModel.setExerciseName("Dumbell Flye");
                dailyChallengeModel.setStatus("lock");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);

            } else if (i == 10) {
                dailyChallengeModel.setExerciseName("Back Extension");
                dailyChallengeModel.setStatus("lock");
                dailyChallengeModel.setDailyExerciseImage(pics[i]);
            }
            dailyChallengeModels.add(dailyChallengeModel);
            myRef.child(id).child(String.valueOf(i)).setValue(dailyChallengeModel);
        }
        Log.d("sampleAs", pics.length + "");
        dailyChallengeAdapter = new DailyChallengeAdapter(getContext(), dailyChallengeModels, user);
        recyclerViewDailyChallenge.setAdapter(dailyChallengeAdapter);
    }

    public interface Callback {
        void getChallenges(ArrayList<DailyChallengeModel> dailyChallengeModel);
    }

    private void setDailyChallenge(final Callback callback) {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(id)) {
                    Log.d("somethinginreturn", "naa");
                    final DatabaseReference matchesRefTemp = dataSnapshot.getRef().child(id);
                    matchesRefTemp.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dailyChallengeModels = new ArrayList<>();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                DailyChallengeModel dailyChallengeModel = new DailyChallengeModel();
                                dailyChallengeModel.setStatus(snapshot.child("status").getValue() + "");
                                dailyChallengeModels.add(dailyChallengeModel);
                            }
                            Log.d("valOfI", dailyChallengeModels.size() + "set");
                            callback.getChallenges(dailyChallengeModels);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                } else {
                    Log.d("somethinginreturn", "wala");
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
        args.putSerializable("user", user);
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void share() {
        shareDialog = new ShareDialog(this);
        List<String> taggedUserIds = new ArrayList<>();
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
