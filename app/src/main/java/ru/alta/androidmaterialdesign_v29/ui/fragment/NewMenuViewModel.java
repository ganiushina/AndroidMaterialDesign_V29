package ru.alta.androidmaterialdesign_v29.ui.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewMenuViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> loginText;

    public void setLoginText(MutableLiveData<String> loginText) {
        this.loginText = loginText;
    }

    public NewMenuViewModel() {
        mText = new MutableLiveData<>();
        loginText = new MutableLiveData<>();
        mText.setValue("This is new menu fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getLoginText() {
        return loginText;
    }

}
