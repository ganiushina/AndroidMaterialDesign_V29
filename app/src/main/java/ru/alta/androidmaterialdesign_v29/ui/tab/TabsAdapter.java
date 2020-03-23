package ru.alta.androidmaterialdesign_v29.ui.tab;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabsAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> tabTitles = new ArrayList<>();

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String tabTitle) {
        this.fragments.add(fragment);
        this.tabTitles.add(tabTitle);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);

    }
}
