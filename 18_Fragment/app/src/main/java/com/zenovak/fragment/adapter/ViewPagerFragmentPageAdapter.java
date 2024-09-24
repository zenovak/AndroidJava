package com.zenovak.fragment.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zenovak.fragment.fragment.BlueFragment;
import com.zenovak.fragment.fragment.GreenFragment;
import com.zenovak.fragment.fragment.RedFragment;


public class ViewPagerFragmentPageAdapter extends FragmentStateAdapter {
    private int numOfPages = 3;


    public ViewPagerFragmentPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPagerFragmentPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPagerFragmentPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new RedFragment();
            case 2:
                return new GreenFragment();
            default:
                return new BlueFragment();
        }
    }

    @Override
    public int getItemCount() {
        return numOfPages;
    }
}
