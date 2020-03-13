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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import ru.alta.androidmaterialdesign_v29.BottomSheetFragment;
import ru.alta.androidmaterialdesign_v29.R;

public class NewMenuFragment extends Fragment {

    private NewMenuViewModel newMenuViewModel;
    int cnt = 0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, final Bundle savedInstanceState) {
        newMenuViewModel =
                ViewModelProviders.of(this).get(NewMenuViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_new_menu, container, false);
        final TextView textView = root.findViewById(R.id.text_new);
        final TextInputEditText textLoginName = root.findViewById(R.id.textInputEditText);
        Button buttonLogin = root.findViewById(R.id.buttonLogin);
        Button buttonNoActionBar = root.findViewById(R.id.buttonNoActionBar);
        Button buttonOpen = root.findViewById(R.id.buttonOpen);


        buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
 //                   Navigation.findNavController(v).navigate(R.id.nav_host_fragment);
//                    fTrans.replace(R.id.fragment_container_view_tag, frag1);
////                    getActivity().getSupportFragmentManager().beginTransaction()
////                            .replace(R.id., new Fragment_progress_bar())
////                            .commit();
                }
            }
        });

     //   buttonOpen.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.fr));

        BottomSheetFragment bottomSheetDialogFragment = new BottomSheetFragment();
        bottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");


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

        buttonNoActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
            }
        }
        );

        return root;

    }


}
