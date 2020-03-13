package ru.alta.androidmaterialdesign_v29.ui.progressbar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ru.alta.androidmaterialdesign_v29.R;

public class Fragment_progress_bar extends Fragment {

    private FragmentProgressBarViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_progress_bar_fragment, container, false);
                mViewModel = ViewModelProviders.of(this).get(FragmentProgressBarViewModel.class);
        final TextView textView = root.findViewById(R.id.text_progress_bar);
        mViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        final ProgressBar progressBar = root.findViewById(R.id.progressBar);
        ProgressBar progressBarLiner = root.findViewById(R.id.progressBarLiner);
        progressBar.setMin(0);
        progressBar.setMax(100);
        progressBar.setProgress(10);

//        progressBarLiner.setMin(0);
//        progressBarLiner.setMax(100);
//        progressBarLiner.setProgress(30);


        Button buttonHide = root.findViewById(R.id.buttonHide);
        buttonHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressBar.getVisibility() == View.INVISIBLE)
                progressBar.setVisibility(View.VISIBLE);
                else progressBar.setVisibility(View.INVISIBLE);
            }
        });



        return root;
    }

}
