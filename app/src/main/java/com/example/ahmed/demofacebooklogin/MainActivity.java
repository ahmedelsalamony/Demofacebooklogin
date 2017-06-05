package com.example.ahmed.demofacebooklogin;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    FacebookLoginManager facebookLoginManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        facebookLoginManager = new FacebookLoginManager(getApplicationContext()).init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        facebookLoginManager.setCustomButton(findViewById(R.id.facebooklogin));
        facebookLoginManager.setup(findViewById(R.id.login_facebook_button), new FacebookLoginManager.FacebookResponseListener() {
            @Override
            public void onSuccess(final Bundle bundle) {
                //facebook(bundle.getString("idFacebook"), bundle.getString("email"), bundle.getString("profile_pic"), bundle.getString("first_name") + bundle.getString("last_name"), 1, bundle.getString("email"));
                String facebook_id = bundle.getString("idFacebook");
                String name_U = bundle.getString("first_name") + bundle.getString("last_name");
                String email = bundle.getString("email");
                String profile = bundle.getString("profile_pic");

                Toast.makeText(MainActivity.this, "hello " + name_U, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailed() {
                Log.e("Name", "failed");
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        facebookLoginManager.onActivityResult(requestCode, resultCode, data);
    }
}
