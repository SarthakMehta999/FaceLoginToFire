package fiture.quiamco.com.homefiture.Gamification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.widget.GameRequestDialog;

import fiture.quiamco.com.homefiture.R;

public class GameRequest extends AppCompatActivity {

    GameRequestDialog requestDialog;
    CallbackManager callbackManager;
    Button invite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_request);

        invite =(Button)findViewById(R.id.btnInvite);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        requestDialog = new GameRequestDialog(this);
        requestDialog.registerCallback(callbackManager,
                new FacebookCallback<GameRequestDialog.Result>() {
                    public void onSuccess(GameRequestDialog.Result result) {
//                        String id = result.getId();
                        Toast.makeText(GameRequest.this, "Success!", Toast.LENGTH_SHORT).show();
                    }
                    public void onCancel() {

                    }
                    public void onError(FacebookException error) {

                    }
                }
        );

        invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRequestButton();
            }
        });
    }


    private void onClickRequestButton() {
        GameRequestContent content = new GameRequestContent.Builder()
                .setMessage("Come play this level with me")
                .build();
        requestDialog.show(content);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
