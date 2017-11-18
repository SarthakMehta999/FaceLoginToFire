package fiture.quiamco.com.homefiture.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.share.widget.ShareDialog;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import de.hdodenhof.circleimageview.CircleImageView;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by User on 02/09/2017.
 */

public class MainFragment extends Fragment {
    private ShareDialog shareDialog;
    private String TAG = "ProfileFragment";
    private CircleImageView profileImage;
    private TextView nameAndSurname, tvGender;
    private String nS;
    private MaterialFancyButton share, logout,start;
    private View rootView;
    private User user;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        user = (User) getArguments().getSerializable("user");
        rootView = inflater.inflate(R.layout.fragment_main,container,false);

        findViews();

        Glide.with(getActivity()).load(user.getImageUrl()).into(profileImage);
         nameAndSurname.setText("Name: "+user.getfName() + " " + user.getlName());

        tvGender.setText("Gender: "+user.getGender());
//        Weight.getText(user.getWeight().toString());
//        Height.setText(user.getHeight().toString());
        Log.d("duga",user.getfName() + " " + user.getlName());
        return rootView;
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

