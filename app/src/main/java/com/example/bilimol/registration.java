package com.example.bilimol;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class registration extends AppCompatActivity {

    TextView txt_timer;
    int count = 120;
    private EditText inputNumber1,inputNumber2,inputNumber3,inputNumber4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_registration);


        TextView textMobile = findViewById(R.id.textMobile);
        textMobile.setText(String.format(
                "+998 %s", getIntent().getStringExtra("mobile")
        ));




        ImageButton back_login = findViewById(R.id.back_login);
        txt_timer = findViewById(R.id.txt_timer);




        back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registration.this,login_page.class);
                startActivity(intent);
            }
        });

        Thread t = new Thread(){
            @Override
            public void run(){
                while (!isInterrupted()){

                    try {
                        Thread.sleep(1000);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count--;

                                txt_timer.setText(String.valueOf(count));
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };

        t.start();

        ImageButton next_homePage = findViewById(R.id.next_homePage);
        next_homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registration.this,name_surname_login.class);
                startActivity(intent);
            }
        });






        // edittexti ulaw

        inputNumber1 = findViewById(R.id.inputNumber1);
        inputNumber2 = findViewById(R.id.inputNumber2);
        inputNumber3 = findViewById(R.id.inputNumber3);
        inputNumber4 = findViewById(R.id.inputNumber4);

        setupOTPInputs();

    }
    private void setupOTPInputs() {
        inputNumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()){
                    inputNumber2.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputNumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()){
                    inputNumber3.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputNumber3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()){
                    inputNumber4.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}