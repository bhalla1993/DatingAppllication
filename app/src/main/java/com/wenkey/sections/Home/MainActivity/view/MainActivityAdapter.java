package com.wenkey.sections.Home.MainActivity.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import com.wenkey.sections.Profile.AccountFragment.view.AccountFragment;
import com.wenkey.sections.Messages.ChatFragment.view.ChatFragment;
import com.wenkey.sections.Home.VotingFragment.view.VotingFragment;

/**
 * Created by Ali Assadi on 10/15/2017.
 */
public class MainActivityAdapter extends FragmentPagerAdapter {

    private String[] tablist= new String[] {"Home","Wenkey","Taed"};
    ArrayList<Fragment> mFragments;

    public MainActivityAdapter(FragmentManager fm) {
        super(fm);
        init();
    }

    private void init() {
        mFragments = new ArrayList<>();
        mFragments.add(new AccountFragment());
        mFragments.add(new VotingFragment());
        mFragments.add(new ChatFragment());

   /*     mFragments.add(new HomeFragment());
        mFragments.add(new ChatsFragment());
        mFragments.add(new NotificationFragment());
        mFragments.add(new ProfileFragment());*/

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return tablist.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tablist[position];
    }
}