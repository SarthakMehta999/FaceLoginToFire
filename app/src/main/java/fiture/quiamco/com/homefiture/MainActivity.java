package fiture.quiamco.com.homefiture;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ShareDialog shareDialog;
    private String name, surname, imageUrl,day,genderOfUser,emailOfUser,userId;
    private String TAG = "MainActivity";
    private int dimensionPixelSize = getResources().getDimensionPixelSize(com.facebook.R.dimen.com_facebook_profilepictureview_preset_size_large);
    private Uri profilePictureUri= Profile.getCurrentProfile().getProfilePictureUri(dimensionPixelSize , dimensionPixelSize);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle inBundle = getIntent().getExtras();
        name = inBundle.getString("name");
        surname = inBundle.getString("surname");
        day = inBundle.getString("birthday");
        genderOfUser = inBundle.getString("gender");
        emailOfUser = inBundle.getString("email");
        imageUrl = inBundle.getString("profilePicture");
        userId = inBundle.getString("userID");

        TextView nameView = (TextView) findViewById(R.id.nameAndSurname);
        ProfilePictureView profileImageUs = (ProfilePictureView) findViewById(R.id.profileImage);
        TextView bday = (TextView) findViewById(R.id.tvBirthday);
        TextView gender = (TextView) findViewById(R.id.tvGender);
        TextView email = (TextView) findViewById(R.id.tvEmail);

        email.setText(emailOfUser);
        bday.setText(day);
        gender.setText(genderOfUser);
        nameView.setText("" + name + " " + surname);
        profileImageUs.setProfileId(imageUrl);

//        Uri imageUri = Profile.getCurrentProfile().getProfilePictureUri(400, 400);
//        Picasso.with(this).load(imageUri).into();
//        Picasso.with(getApplicationContext()).load(imageUrl).into(profilePictur);
//        Glide.with(this).load(profilePictureUri)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .into;
//        profileImage.setProfileId(profile);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share:
                share();
                break;

            case R.id.getPosts:
                getPosts();
                break;

            case R.id.logout:
                logout();
                break;
        }
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

    private void getPosts(){
        new GraphRequest(
                AccessToken.getCurrentAccessToken(), "/me/posts", null, HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Log.e(TAG,response.toString());
                    }
                }
        ).executeAsync();
    }


    private void logout(){
        LoginManager.getInstance().logOut();
        Intent login = new Intent(MainActivity.this, FacebookLoginActivity.class);
        startActivity(login);
        finish();
    }
}