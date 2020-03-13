package ru.alta.androidmaterialdesign_v29.ui.fragment;

import android.text.Editable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewMenuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewMenuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is new menu fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
