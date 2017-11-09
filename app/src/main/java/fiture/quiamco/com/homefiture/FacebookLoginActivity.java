package fiture.quiamco.com.homefiture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yasic.library.particletextview.View.ParticleTextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import fiture.quiamco.com.homefiture.models.User;

public class FacebookLoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private int mColor;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListner;
    private ParticleTextView particleTextView;


    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    private String firstName, lastName, email, birthday, gender;
    private String profilePicture;
    private String userName;
    private TextView appName;
    private String TAG = "FacebookLoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            Intent startNew = new Intent(FacebookLoginActivity.this,Lifestyle.class);
            startActivity(startNew);

        }
        setContentView(R.layout.activity_facebook_login);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset_password);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FacebookLoginActivity.this, SignupActivity.class));
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FacebookLoginActivity.this, ResetPasswordActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(FacebookLoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(FacebookLoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(FacebookLoginActivity.this, Lifestyle.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });

        callbackManager = CallbackManager.Factory.create();
        FacebookSdk.sdkInitialize(this.getApplicationContext());

//         appName = (TextView) findViewById(R.id.nameOfApp);
//        appName.setTypeface(EasyFonts.windSong(this));
        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);
//
//        particleTextView = (ParticleTextView) findViewById(R.id.particleTextView);
//        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
//        ParticleTextViewConfig config = new ParticleTextViewConfig.Builder()
//                .setRowStep(8)
//                .setColumnStep(8)
//                .setTargetText("Fiture")
//                .setReleasing(0.2)
//                .setParticleRadius(4)
//                .setMiniDistance(0.1)
//                .setTextSize(150)
//                .setMovingStrategy(randomMovingStrategy)
//                .instance();
//        particleTextView.setConfig(config);
//        particleTextView.startAnimation();


//        loginButton.setReadPermissions("email", "user_birthday","user_posts","user_photos","public_profile");
        loginButton.setReadPermissions(Arrays.asList("email", "user_birthday", "user_posts", "user_photos", "public_profile"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.e(TAG, object.toString());
                        Log.e(TAG, response.toString());

                        try {
                            userName = object.getString("id");
//                            profilePicture = new URL("http://graph.facebook.com/" + userName + "/picture?width=500&height=500");
                            profilePicture = object.getJSONObject("picture").getJSONObject("data").getString("url");
                            Log.d("deceree", profilePicture);
                            if (object.has("first_name"))
                                firstName = object.getString("first_name");
                            if (object.has("last_name"))
                                lastName = object.getString("last_name");
                            if (object.has("email"))
                                email = object.getString("email");
                            if (object.has("birthday"))
                                birthday = object.getString("birthday");
                            if (object.has("gender"))
                                gender = object.getString("gender");


                            Intent main = new Intent(FacebookLoginActivity.this, Lifestyle.class);
                            Bundle bundle = new Bundle();
                            if(email == null){
                                email="none";
                            }
                            User user = new User(
//                                    firstName,
//                                    lastName,
//                                    birthday,
//                                    gender,
//                                    email,
//                                    profilePicture
                            );
                            user.setfName(firstName);
                            user.setlName(lastName);
                            user.setBirthDate(birthday);
                            user.setGender(gender);
                            user.setEmail(email);
                            user.setImageUrl(profilePicture);
                            SharedPreferences sharedPreferences = getSharedPreferences("FitureUser", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("userFname",firstName);
                            editor.putString("userLname",lastName);
                            editor.putString("userBday",birthday);
                            editor.putString("userGender",gender);
                            editor.putString("userEmail",email);
                            editor.putString("userPic",profilePicture);
                            editor.apply();
                            Log.d("userAss",profilePicture+" "+email+" "+firstName+" "+lastName+" "+birthday+" "+
                            gender);
                            bundle.putSerializable("user", user);
                            main.putExtras(bundle);
//                            main.putExtra("name", firstName);
//                            main.putExtra("surname", lastName);
//                            main.putExtra("birthday",birthday);
//                            main.putExtra("gender",gender);
//                            main.putExtra("email",email);
//                            main.putExtra("userID",userName);
//                            main.putExtra("imageUrl", profilePicture);
                            startActivity(main);
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                //Here we put the requested fields to be returned from the JSONObject
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, first_name, last_name, email, birthday, gender, picture.type(large)");
                request.setParameters(parameters);
                request.executeAsync();


            }


            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

            }
        };
    }



    private void handleFacebookAccessToken(AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListner);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(firebaseAuthListner);
//        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
//        updateUI(currentUser);
    }


    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);
        callbackManager.onActivityResult(requestCode, responseCode, intent);
    }


}