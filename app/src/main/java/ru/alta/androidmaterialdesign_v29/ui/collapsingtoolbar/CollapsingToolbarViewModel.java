package ru.alta.androidmaterialdesign_v29.ui.collapsingtoolbar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CollapsingToolbarViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CollapsingToolbarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Collapsing Toolbar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
