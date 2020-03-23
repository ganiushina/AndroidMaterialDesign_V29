package ru.alta.androidmaterialdesign_v29.ui.tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import ru.alta.androidmaterialdesign_v29.R;
import ru.alta.androidmaterialdesign_v29.ui.collapsingtoolbar.CollapsingToolbar;
import ru.alta.androidmaterialdesign_v29.ui.fragment.NewMenuFragment;
import ru.alta.androidmaterialdesign_v29.ui.recyclerView.ItemFragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTab extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTab.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTab newInstance(String param1, String param2) {
        FragmentTab fragment = new FragmentTab();
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
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        NewMenuFragment menuFragment = new NewMenuFragment();
        ItemFragment itemFragment = new ItemFragment();
        CollapsingToolbar collapsingToolbar = new CollapsingToolbar();

        TabsAdapter tabsAdapter = new TabsAdapter(getActivity().getSupportFragmentManager());
        tabsAdapter.addFragment(menuFragment, "tab1");
        tabsAdapter.addFragment(itemFragment, "tab2");
        tabsAdapter.addFragment(collapsingToolbar, "tab3");

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(tabsAdapter);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        return view;

    }
}
