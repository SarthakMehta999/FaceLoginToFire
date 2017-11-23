package fiture.quiamco.com.homefiture.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.share.widget.ShareDialog;
import com.firebase.client.Firebase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import java.util.ArrayList;
import java.util.Collections;

import de.hdodenhof.circleimageview.CircleImageView;
import fiture.quiamco.com.homefiture.Adapter.UserAdapter;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by User on 02/09/2017.
 */

public class MainFragment extends Fragment {
    private ShareDialog shareDialog;
    private String TAG = "MainFragment";
    private CircleImageView profileImage;
    private TextView nameAndSurname, tvGender;
    private String nS;
    private MaterialFancyButton share, logout,start;
    private View rootView;
    private User user;
    FirebaseDatabase database;
    Firebase mRef;
    DatabaseReference myRef;
    private UserAdapter userAdapter;
    private RecyclerView mUserList;
    private ArrayList<User> mUserDatas;

    public interface Callback{
        void getUserData(ArrayList<User> users);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mUserDatas = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        myRef= database.getReference("UserFiture");
        user = (User) getArguments().getSerializable("user");
        rootView = inflater.inflate(R.layout.fragment_main,container,false);

        findViews();
        mUserDatas = new ArrayList<>();


//
//        for(int i =0; i < 20; i++){
//            User user = new User();
//            user.setfName("asd");
//            user.setUserPoints(43);
//            user.setImageUrl("awew");
//
//            mUserDatas.add(user);
//        }
//        temp();

        //collectAllUserData();
        /*final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mUserList = (RecyclerView) rootView.findViewById(R.id.recycler_view_frag);
        getUser(new Callback() {
            @Override
            public void getUserData(ArrayList<User> users) {
                mUserList.setLayoutManager(mLayoutManager);
                mUserList.setItemAnimator(new DefaultItemAnimator());
                Log.d("valuSasulod",mUserDatas.size()+"");
                userAdapter = new UserAdapter(getContext(),users);
                mUserList.setAdapter(userAdapter);
                Log.d("naay sulod", String.valueOf(mUserDatas.size()));
            }
        });*/

        getUser();


        return rootView;

    }
    private void collectAllUserData() {
    }

    public void findViews(){
        profileImage = (CircleImageView) rootView.findViewById(R.id.profileImage); // find circle image view
        nameAndSurname  = (TextView) rootView.findViewById(R.id.nameAndSurname); //Find textview Id
        tvGender = (TextView) rootView.findViewById(R.id.tvGender);
//        Weight = (TextView) rootView.findViewById(R.id.tvWeight);
//        Height = (TextView) rootView.findViewById(R.id.tvHeight);

        share = (MaterialFancyButton) rootView.findViewById(R.id.share);
//        logout = (MaterialFancyButton) rootView.findViewById(R.id.logout);
        start = (MaterialFancyButton) rootView.findViewById(R.id.startActivity);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                logout();
//            }
//        });

//        mUserList = (RecyclerView) rootView.findViewById(R.id.recycler_view_frag);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//        mUserList.setLayoutManager(mLayoutManager);
//        mUserList.setItemAnimator(new DefaultItemAnimator());
//        userAdapter = new UserAdapter(getContext(),data);
//        mUserList.setAdapter(userAdapter);
//        //
//
//        Log.d("gawsi", String.valueOf(data.size()));
//        userAdapter = new UserAdapter(getContext(),mUserDatas);
//
////        mUserDatas = new ArrayList<>();
//
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        mUserList.setLayoutManager(mLayoutManager);
//        mUserList.setItemAnimator(new DefaultItemAnimator());
//        mUserList.setAdapter(userAdapter);
//        Log.d("naay sulod", String.valueOf(mUserDatas.size()));


    }
    public void temp(){

        mUserList = (RecyclerView)rootView.findViewById(R.id.recycler_view_frag);
        User user = new User();
        user.setfName("asds");
        user.setImageUrl("weww");
        user.setUserPoints(34);
        mUserDatas.add(user);
        userAdapter = new UserAdapter(getContext(),mUserDatas);
        mUserList.setAdapter(userAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
      //  mUserList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        mUserList.setLayoutManager(layoutManager);

        userAdapter.notifyDataSetChanged();

    }

    public void getUser(){
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User user = dataSnapshot.getValue(User.class);
                mUserDatas.add(user);
                Collections.sort(mUserDatas);
//                userAdap

              //  LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//                mUserList.setLayoutManager(layoutManager);
//                userAdapter = new UserAdapter(getContext(),mUserDatas);
//                mUserList.setAdapter(userAdapter);

//                Log.d("hahays", String.valueOf(mUserDatas.size()));
//                callback.getUserData(mUserDatas);
//                Log.d("sure",TAG);


                mUserList = (RecyclerView)rootView.findViewById(R.id.recycler_view_frag);
               // mUserDatas.add(user);
                userAdapter = new UserAdapter(getContext(),mUserDatas);
                mUserList.setAdapter(userAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                //  mUserList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
                mUserList.setLayoutManager(layoutManager);

                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public static MainFragment newInstance(User user) {
        Bundle args = new Bundle();
        args.putSerializable("user",user);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }


    //    private void logout(){
//        LoginManager.getInstance().logOut();
//        Intent login = new Intent(getActivity(), FacebookLoginActivity.class);
//        startActivity(login);
//    }

}

