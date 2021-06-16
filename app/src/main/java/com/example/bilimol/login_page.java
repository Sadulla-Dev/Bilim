package com.example.bilimol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class login_page extends AppCompatActivity {
    ImageButton tasdiqlash_button;
    ImageView logo_loginPage;
    TextView text_loginPage;
    private Animation bottom_animation,top_animation;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login_page);


        bottom_animation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        top_animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);

        logo_loginPage = findViewById(R.id.logo_loginPage);
        text_loginPage = findViewById(R.id.text_loginPage);


        logo_loginPage.setAnimation(top_animation);
        text_loginPage.setAnimation(bottom_animation);





        tasdiqlash_button = findViewById(R.id.tasdiqlash_button);
        final EditText inputMobile = findViewById(R.id.inputMobile);



        tasdiqlash_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputMobile.getText().toString().trim().isEmpty() || (inputMobile.getText().toString().length() < 8)){
                    Toast.makeText(login_page.this, "Nomeringizni kiriting", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(login_page.this,registration.class);
                intent.putExtra("mobile",inputMobile.getText().toString());
                startActivity(intent);
            }
        });






    }


}