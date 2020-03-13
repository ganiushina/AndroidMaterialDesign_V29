package ru.alta.androidmaterialdesign_v29.ui.progressbar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentProgressBarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FragmentProgressBarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Progress Bar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
