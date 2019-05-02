/*
* ===========================================================================
* Copyright 2016 OpenTrends
* All Rights Reserved
* ===========================================================================
*
* File Name: DetailFragment.java
*
*
* Version Number: 0.0.0.1
*
* Created Date: 15 Mar 2016
*
*/
package com.opentrends.demo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.opentrends.demo.R;
import com.squareup.picasso.Picasso;


public class DetailFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Get title text
        String title = getArguments().getString("title");

        //Get imageUrl
        String imageUrl = getArguments().getString("imageUrl");


        //Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_detail, container, false);

        //Set title text to the text view
        TextView titleView = (TextView) mView.findViewById(R.id.titleView);
        titleView.setText(title);

        //Load image from imageUrl using Picasso
        ImageView imageView = (ImageView) mView.findViewById(R.id.imageView);
        Picasso.with(getActivity())
                .load(imageUrl)
                .into(imageView);

        return mView;
    }
}
