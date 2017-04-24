package com.example.ammar.navigationdrawer.fragment.navigation;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.ammar.navigationdrawer.BuildConfig;
import com.example.ammar.navigationdrawer.NavigationMain;
import com.example.ammar.navigationdrawer.R;
import com.example.ammar.navigationdrawer.fragment.FragmentJellyBean;
import com.example.ammar.navigationdrawer.fragment.FragmentMarshmallow;
import com.example.ammar.navigationdrawer.fragment.FragmentNougat;
import com.example.ammar.navigationdrawer.fragment.FragmentKitkat;
import com.example.ammar.navigationdrawer.fragment.FragmentLollipop;

/**
 * @author msahakyan
 */

public class FragmentNavigationManager implements NavigationManager {

    private static FragmentNavigationManager sInstance;

    private FragmentManager mFragmentManager;
    private NavigationMain mActivity;

    public static FragmentNavigationManager obtain(NavigationMain activity) {
        if (sInstance == null) {
            sInstance = new FragmentNavigationManager();
        }
        sInstance.configure(activity);
        return sInstance;
    }

    private void configure(NavigationMain activity) {
        mActivity = activity;
        mFragmentManager = mActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragmentAction(String title) {
        showFragment(FragmentNougat.newInstance(title), false);
    }

    @Override
    public void showFragmentComedy(String title) {
        showFragment(FragmentKitkat.newInstance(title), false);
    }

    @Override
    public void showFragmentDrama(String title) {
        showFragment(FragmentLollipop.newInstance(title), false);
    }

    @Override
    public void showFragmentMusical(String title) {
        showFragment(FragmentMarshmallow.newInstance(title), false);
    }

    @Override
    public void showFragmentThriller(String title) {
        showFragment(FragmentJellyBean.newInstance(title), false);
    }

    private void showFragment(Fragment fragment, boolean allowStateLoss) {
        FragmentManager fm = mFragmentManager;

        @SuppressLint("CommitTransaction")
        FragmentTransaction ft = fm.beginTransaction()
            .replace(R.id.container, fragment);

        ft.addToBackStack(null);

        if (allowStateLoss || !BuildConfig.DEBUG) {
            ft.commitAllowingStateLoss();
        } else {
            ft.commit();
        }

        fm.executePendingTransactions();
    }
}
