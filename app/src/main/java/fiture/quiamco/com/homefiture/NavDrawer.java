package fiture.quiamco.com.homefiture;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.facebook.share.widget.ShareDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import fiture.quiamco.com.homefiture.Pedometer.Pedometer_Main;
import fiture.quiamco.com.homefiture.fragments.MainFragment;
import fiture.quiamco.com.homefiture.fragments.ProfileFragment;
import fiture.quiamco.com.homefiture.models.User;

public class NavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ShareDialog shareDialog;
    private String name, surname, imageUrl,day,genderOfUser,emailOfUser,userId;
    private String TAG = "MainActivity";
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        EventBus.getDefault().register(this);



        Bundle inBundle = getIntent().getExtras();
        user = (User) inBundle.getSerializable("user");
        name = user.getfName();
        surname = user.getlName();
        day = user.getBirthDate();
        genderOfUser = user.getGender();
        emailOfUser = user.getEmail();
        imageUrl = user.getImageUrl();
//        userId = inBundle.getString("userID");
        Log.d("namessdfds",user.getfName() + " " + user.getlName());
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        View hView =  navigationView.getHeaderView(0);
//        ImageView imageView = (ImageView) hView.findViewById(R.id.imageView);
//        Glide.with(NavDrawer.this).load(user.getImageUrl()).into(imageView);
//        TextView nav_user = (TextView)hView.findViewById(R.id.nav_name);
//        TextView email = (TextView)hView.findViewById(R.id.email);
//        email.setText(user.getEmail());
//        nav_user.setText(user.getfName() + " " + user.getlName());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.getHeaderView(0);
        ImageView imageView = (ImageView) hView.findViewById(R.id.imageView);
        Glide.with(NavDrawer.this).load(user.getImageUrl()).into(imageView);
        TextView nav_user = (TextView)hView.findViewById(R.id.nav_name);
        TextView email = (TextView)hView.findViewById(R.id.email);
        email.setText(user.getEmail());
        nav_user.setText(user.getfName() + " " + user.getlName());
        fragment();


//        FragmentManager fam = getSupportFragmentManager();
//        fam.beginTransaction().replace(R.id.content_frame,new ProfileFragment().newInstance(user)).commit();
    }
    public void fragment() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.content_frame, new ProfileFragment().newInstance(user))
                        .commit();
            }
        }, 0);
    }
    public void fragmentA() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.content_frame, new MainFragment().newInstance(user))
                        .commit();
            }
        }, 0);
    }

    @Subscribe
    public void onEvent(ProfileFragment event){
        Log.d("Sample","Test");
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            LoginManager.getInstance().logOut();
            Intent login = new Intent(NavDrawer.this, FacebookLoginActivity.class);
            startActivity(login);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager fm  = getSupportFragmentManager();
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.leaderboard) {
            fragmentA();
//            finish();
        } else if (id == R.id.pedometer) {
            Intent inte = new Intent(NavDrawer.this, Pedometer_Main.class);
            startActivity(inte);

        } else if (id == R.id.home) {
            fragment();
//
//        } else if (id == R.id.nav_manage) {
//
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}
