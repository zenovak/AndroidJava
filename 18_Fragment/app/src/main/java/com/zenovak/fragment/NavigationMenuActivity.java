package com.zenovak.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.zenovak.fragment.adapter.ViewPagerFragmentPageAdapter;
import com.zenovak.fragment.fragment.BlueFragment;
import com.zenovak.fragment.fragment.GreenFragment;
import com.zenovak.fragment.fragment.RedFragment;

import java.util.logging.Logger;

public class NavigationMenuActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                Class fragmentClass;

                 // is you see an error to link the R ids from menu resource file see stack overflow below
                 // https://stackoverflow.com/questions/76334499/error-constant-expression-required-android-studio
                 switch (item.getItemId()){
                     case R.id.nav_red_fragment:
                         fragmentClass = RedFragment.class;
                         break;
                     case R.id.nav_green_fragment:
                         fragmentClass = GreenFragment.class;
                         break;
                     default:
                         fragmentClass = BlueFragment.class;
                         break;
                 }

                 try {
                     fragment = (Fragment) fragmentClass.newInstance();
                 } catch (IllegalAccessException e) {
                     throw new RuntimeException(e);
                 } catch (InstantiationException e) {
                     throw new RuntimeException(e);
                 }

                 FragmentManager fragmentManager = getSupportFragmentManager();
                 fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();

                 setTitle(item.getTitle());
                 item.setChecked(true);

                 drawerLayout.closeDrawer(GravityCompat.START);

                 return false;
             }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}