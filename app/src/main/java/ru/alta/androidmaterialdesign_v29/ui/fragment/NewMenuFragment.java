package ru.alta.androidmaterialdesign_v29.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import ru.alta.androidmaterialdesign_v29.R;

public class NewMenuFragment extends Fragment {

    private NewMenuViewModel newMenuViewModel;
    int cnt = 0;

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

        textLoginName.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cnt++;
            }
        });


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt==0) {
                    Snackbar snackbar = Snackbar
                            .make(view, "Поле Имя пустое", Snackbar.LENGTH_LONG)
                            .setAction("Повторить", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });
                snackbar.setActionTextColor(Color.CYAN);
                TextView textView = (TextView) snackbar.getView()
                        .findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.LTGRAY);
                snackbar.show();
            }
            };
        });
        return root;
    }




}
