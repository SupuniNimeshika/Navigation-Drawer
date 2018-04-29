package com.example.supuni.navigationdrawer.Helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.supuni.navigationdrawer.BuildConfig;
import com.example.supuni.navigationdrawer.Fragments.FragmentContent;
import com.example.supuni.navigationdrawer.Interface.NavigationManager;
import com.example.supuni.navigationdrawer.MainActivity;
import com.example.supuni.navigationdrawer.R;

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

       showFragment(FragmentContent.newInstance(title),false);
    }

    private void showFragment(Fragment fragmentContent, boolean b) {
        FragmentManager fm =mFragementManager;
        FragmentTransaction ft = fm.beginTransaction().replace(R.id.container,fragmentContent);
        ft.addToBackStack(null);
        if(b || !BuildConfig.DEBUG)
            ft.commitAllowingStateLoss();
        else
            ft.commit();
        fm.executePendingTransactions();

    }


}
