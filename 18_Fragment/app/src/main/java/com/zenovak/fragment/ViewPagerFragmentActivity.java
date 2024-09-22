package com.zenovak.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.zenovak.fragment.adapter.ViewPagerFragmentPageAdapter;


public class ViewPagerFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_fragment);

        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        FragmentStateAdapter adapter = new ViewPagerFragmentPageAdapter(this);
        viewPager2.setAdapter(adapter);
    }
}