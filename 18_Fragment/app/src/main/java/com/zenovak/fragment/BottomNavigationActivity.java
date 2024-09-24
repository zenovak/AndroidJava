package com.zenovak.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.zenovak.fragment.fragment.BlueFragment;
import com.zenovak.fragment.fragment.GreenFragment;
import com.zenovak.fragment.fragment.RedFragment;

public class BottomNavigationActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    private BlueFragment blueFragment = new BlueFragment();
    private RedFragment redFragment = new RedFragment();
    private GreenFragment greenFragment = new GreenFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(this);
        // Sets the default selected menu item (first page you see)
        bottomNavigationView.setSelectedItemId(R.id.nav_blue_fragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_blue_fragment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_bottomNav, blueFragment).commit();
                return true;
            case R.id.nav_red_fragment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_bottomNav, redFragment).commit();
                return true;
            case R.id.nav_green_fragment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout_bottomNav, greenFragment).commit();
                return true;
            default:
                return false;
        }
    }
}