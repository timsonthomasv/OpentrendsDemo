/*
* ===========================================================================
* Copyright 2016 OpenTrends
* All Rights Reserved
* ===========================================================================
*
* File Name: MainActivity.java
*
*
* Version Number: 0.0.0.1
*
* Created Date: 15 Mar 2016
*
*/
package com.opentrends.demo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.opentrends.demo.R;
import com.opentrends.demo.ui.fragment.ListFragment;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initiate fragment transaction for ListFragment.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ListFragment listFragment = new ListFragment();
        fragmentTransaction.add(R.id.fragment_place, listFragment, "listFragment");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

        //Check whether any fragment added to backstack
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();//No Backstack entry, ready to exit application!!
        } else {
            getSupportFragmentManager().popBackStack();//Display list fragment from Backstack
        }

    }
}
