package com.example.supuni.navigationdrawer.Helper;

import android.support.v4.app.FragmentManager;

import com.example.supuni.navigationdrawer.Interface.NavigationManager;
import com.example.supuni.navigationdrawer.MainActivity;

/**
 * Created by supuni on 4/27/18.
 */

public class FragmentNavigationManager implements NavigationManager {

    private static FragmentNavigationManager mInstance;

    private FragmentManager mFragementManager;
    private MainActivity mainActivity;

    public static FragmentNavigationManager getmInstance (MainActivity mainActivity)
    {
        if(mInstance ==null)
            mInstance =new FragmentNavigationManager();
        mInstance.configure(mainActivity);
        return mInstance;
    }

    private void configure(MainActivity mainActivity){
        mainActivity =mainActivity;
        mFragementManager =mainActivity.getSupportFragmentManager();
    }
    @Override
    public void showFragment(String title) {

    }
}
