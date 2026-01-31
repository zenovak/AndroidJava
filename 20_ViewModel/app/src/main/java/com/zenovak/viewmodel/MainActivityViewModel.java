package com.zenovak.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int count = 0;
    private final MutableLiveData<Integer> _count = new MutableLiveData<>(0);

    public LiveData<Integer> getCount() {
        return _count;
    }

    public void increment() {
        count++;
        _count.setValue(count);
    }
}
