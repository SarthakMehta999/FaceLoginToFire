package fiture.quiamco.com.homefiture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;
import java.util.List;

import static fiture.quiamco.com.homefiture.R.id.profileImage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ShareDialog shareDialog;
    private String name, surname, imageUrl,day,genderOfUser,emailOfUser,userId;

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_fragment);


        Bundle inBundle = getIntent().getExtras();
        name = inBundle.getString("name");
        surname = inBundle.getString("surname");
        day = inBundle.getString("birthday");
        genderOfUser = inBundle.getString("gender");
        emailOfUser = inBundle.getString("email");
        imageUrl = inBundle.getString("imageUrl");
        userId = inBundle.getString("userID");



        TextView nameView = (TextView) findViewById(R.id.nameAndSurname);
        ImageView profileImageUs = (ImageView) findViewById(profileImage);
        TextView bday = (TextView) findViewById(R.id.tvBirthday);
        TextView gender = (TextView) findViewById(R.id.tvGender);
        TextView email = (TextView) findViewById(R.id.tvEmail);

        email.setText(emailOfUser);
        bday.setText(day);
        gender.setText(genderOfUser);
        nameView.setText("" + name + " " + surname);

        nameView.setTypeface(EasyFonts.robotoLight(this));
        email.setTypeface(EasyFonts.robotoItalic(this));
        gender.setTypeface(EasyFonts.robotoLight(this));
        bday.setTypeface(EasyFonts.robotoLight(this));

        Glide.with(this).load(imageUrl).centerCrop().into(profileImageUs);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share:
                share();
                break;

            case R.id.test:
                user();
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

    private void user(){
        Intent log = new Intent(this, UserStatus.class);
        startActivity(log);
        super.finish();
    }
    private void logout(){
        LoginManager.getInstance().logOut();
        Intent login = new Intent(MainActivity.this, FacebookLoginActivity.class);
        startActivity(login);
        finish();
    }


}