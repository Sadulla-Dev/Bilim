package com.example.bilimol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class home_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(navListener);





        // setting home Fragment as main fragment


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,new homeFragment()).commit();




    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.Id_home:
                    selectedFragment = new homeFragment();
                    break;
                case R.id.Id_search:
                    selectedFragment = new searchFragment();
                    break;
                case R.id.Id_star:
                    selectedFragment = new starFragment();
                    break;
                case R.id.Id_profile:
                    selectedFragment = new profileFragment();
                    break;


            }
            // begin transaction

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,selectedFragment).commit();

            return true;
        }
    };
}