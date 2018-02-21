package com.newsalerts.ef.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.newsalerts.ef.fragment.IntroContentFragment;

/**
 * Created by EF on 20-Feb-18.
 */

public class ImagePagerAdapter extends FragmentPagerAdapter{
    public ImagePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return IntroContentFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 5;
    }
}
