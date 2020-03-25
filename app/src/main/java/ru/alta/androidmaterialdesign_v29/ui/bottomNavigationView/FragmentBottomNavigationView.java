package ru.alta.androidmaterialdesign_v29.ui.bottomNavigationView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.alta.androidmaterialdesign_v29.R;
import ru.alta.androidmaterialdesign_v29.ui.collapsingtoolbar.CollapsingToolbar;
import ru.alta.androidmaterialdesign_v29.ui.fragment.NewMenuFragment;
import ru.alta.androidmaterialdesign_v29.ui.progressbar.Fragment_progress_bar;
import ru.alta.androidmaterialdesign_v29.ui.recyclerView.ItemFragment;
import ru.alta.androidmaterialdesign_v29.ui.tab.FragmentTab;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBottomNavigationView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBottomNavigationView extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentBottomNavigationView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBottomNavigationView.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBottomNavigationView newInstance(String param1, String param2) {
        FragmentBottomNavigationView fragment = new FragmentBottomNavigationView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_navigation_view, container, false);

        replaceFragment(new Fragment_progress_bar());

        BottomNavigationView navView = view.findViewById(R.id.navigation_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        return view;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment( new NewMenuFragment());
                    return true;
                case R.id.navigation_dashboard:
                    replaceFragment(new ItemFragment());
                    return true;
                case R.id.navigation_notifications:
                    replaceFragment(new CollapsingToolbar());
                    return true;
            }
            return false;
        }
    };


    private void replaceFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();

    }


}
