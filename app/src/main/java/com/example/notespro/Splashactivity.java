package com.example.notespro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if(currentUser==null){
                    startActivity(new Intent(Splashactivity.this,LoginActivity.class));
                }
                else{
                    startActivity(new Intent(Splashactivity.this,MainActivity.class));
                }
                startActivity(new Intent(Splashactivity.this, CreateAccountActivity.class));
                finish();
            }
        },1000);

            }
        }

