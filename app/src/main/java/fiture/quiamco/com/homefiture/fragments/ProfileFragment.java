package fiture.quiamco.com.homefiture.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import fiture.quiamco.com.homefiture.FacebookLoginActivity;
import fiture.quiamco.com.homefiture.R;
import fiture.quiamco.com.homefiture.StartActivity;
import fiture.quiamco.com.homefiture.models.User;

/**
 * Created by User on 02/09/2017.
 */

public class ProfileFragment extends Fragment{

    private ShareDialog shareDialog;
    private String TAG = "ProfileFragment";
    private CircleImageView profileImage;
    private TextView nameAndSurname, tvEmail, tvGender, tvBirthday,BMI;
    private EditText Weight,Height;
    private MaterialFancyButton share, logout,start;
    private View rootView;
    private User user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        user = (User) getArguments().getSerializable("user");
        rootView = inflater.inflate(R.layout.profile_fragment,container,false);

        findViews();

        Glide.with(getActivity()).load(user.getImageUrl()).into(profileImage);
        nameAndSurname.setText(user.getfName() + " " + user.getlName());
        tvEmail.setText(user.getEmail());
        tvGender.setText(user.getGender());
        tvBirthday.setText(user.getBirthDate());
//        Weight.getText(user.getWeight().toString());
//        Height.setText(user.getHeight().toString());
        BMI.setText((CharSequence) user.getResult());
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
        BMI = (TextView) rootView.findViewById(R.id.tvBMI);

        share = (MaterialFancyButton) rootView.findViewById(R.id.share);
        logout = (MaterialFancyButton) rootView.findViewById(R.id.logout);
        start = (MaterialFancyButton) rootView.findViewById(R.id.startActivity);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
    }

    private void start() {
        Intent login = new Intent(getActivity(), StartActivity.class);
        startActivity(login);
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

    private void logout(){
        LoginManager.getInstance().logOut();
        Intent login = new Intent(getActivity(), FacebookLoginActivity.class);
        startActivity(login);
    }

}
