package com.example.slawomirmakurat.agromarket;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.FishAndMeetFragment;
import fragment.FruitsFragment;
import fragment.HomemadePreservesFragment;
import fragment.ServicesFragment;
import fragment.WegetablesFragment;

/**
 * Created by slawomir.makurat on 2017-02-21.
 */

public class MaterialPagerAdapter  extends FragmentPagerAdapter {

    private Context context;

    public MaterialPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WegetablesFragment();
            case 1:
                return new FruitsFragment();
            case 2:
                return new HomemadePreservesFragment();
            case 3:
                return new FishAndMeetFragment();
            case 4:
                return new ServicesFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.wegetables);
            case 1:
                return context.getString(R.string.fruits);
            case 2:
                return context.getString(R.string.homemade_preserves);
            case 3:
                return context.getString(R.string.fish_meet);
            case 4:
                return context.getString(R.string.services);

        }
        return null;
    }

}
