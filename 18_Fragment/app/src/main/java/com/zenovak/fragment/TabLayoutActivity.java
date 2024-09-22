package com.zenovak.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zenovak.fragment.adapter.ViewPagerFragmentPageAdapter;

public class TabLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        FragmentStateAdapter adapter = new ViewPagerFragmentPageAdapter(this);
        viewPager2.setAdapter(adapter);

        // dynamically assign tabs to the pages
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> {
            switch (position) {
                case 1:
                    tab.setText("Red fragment");
                    break;
                default:
                    tab.setText("Blue fragment");

            }
        })).attach();
    }
}