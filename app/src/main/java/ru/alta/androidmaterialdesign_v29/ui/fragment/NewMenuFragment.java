package ru.alta.androidmaterialdesign_v29.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import ru.alta.androidmaterialdesign_v29.R;

public class NewMenuFragment extends Fragment {

    private NewMenuViewModel newMenuViewModel;

    boolean isEmpty = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newMenuViewModel =
                ViewModelProviders.of(this).get(NewMenuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_new_menu, container, false);
        final TextView textView = root.findViewById(R.id.text_new);
        final TextInputEditText textLoginName = root.findViewById(R.id.textInputEditText);
        Button buttonLogin = root.findViewById(R.id.button);
        newMenuViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        newMenuViewModel.getLoginText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textLoginName.setText(s);
                isEmpty = true;
            }
        });


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty)
                    Snackbar.make(view, "Hello Android ", Snackbar.LENGTH_LONG)
                        .show();
            };
        });
        return root;
    }
}
