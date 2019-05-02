/*
* ===========================================================================
* Copyright 2016 OpenTrends
* All Rights Reserved
* ===========================================================================
*
* File Name: ListFragment.java
*
*
* Version Number: 0.0.0.1
*
* Created Date: 15 Mar 2016
*
*/
package com.opentrends.demo.ui.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.opentrends.demo.R;
import com.opentrends.demo.model.ResponseModel;
import com.opentrends.demo.model.Result;
import com.opentrends.demo.ui.adapter.CustomAdapter;
import com.opentrends.demo.util.Constants;
import com.opentrends.demo.util.GsonHelper;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private ListView mListView;
    private List<String> mTitleList;
    private List<String> mImageList;
    private List<String> mImageThumbnailList;
    private ProgressDialog dialog;


    private GsonHelper mGsonHelper;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_list, container, false);

        //Initialise attributes for title text, image url and image thumbnail url
        mTitleList = new ArrayList<String>();
        mImageList = new ArrayList<String>();
        mImageThumbnailList = new ArrayList<String>();

        //Display progress dialog while Volley in action!! We are not using any AsyncTask here!!
        dialog = ProgressDialog.show(getActivity(), "Loading...", "Please wait...", true);

        //Fire a volley web service request
        doGetRequest(Constants.getRandomapiUrl(), getActivity());

        //Init the listview, we will add contents once we hear back from volley
        mListView = (ListView) mView.findViewById(R.id.fragment_list);

        //Listen to list item click
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switchFragment(position);
            }
        });

        return mView;
    }

    /**
     * This method creates a web service request using the Volley Library
     *
     * @param url
     * @param context
     */
    public void doGetRequest(String url, Context context) {

        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mGsonHelper = new GsonHelper();//Lets GSON Helper parse the JSON String

                        ResponseModel responseModel = mGsonHelper.parseJson(response);//Get Response data from JSON

                        List<Result> results = responseModel.getResults();//Get Result entries

                        for (Result result : results) {//Iterate through each result
                            mTitleList.add(result.getEntity().getDescritpion());//Add title text
                            mImageList.add(result.getEntity().getPicture());//Add image url
                            mImageThumbnailList.add(result.getEntity().getThumbnail());//Add thumbnail url
                        }

                        mListView.setVisibility(View.VISIBLE);//Time to make the list view visible
                        mListView.setAdapter(new CustomAdapter(getActivity(), mTitleList, mImageList));//Set custom adapter to listview

                        if (dialog.isShowing()) {//Is dialog showing still?
                            dialog.dismiss();//Lets dismiss the dialog
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (dialog.isShowing()) {//Is dialog showing still?
                            dialog.dismiss();//Lets dismiss the dialog
                        }

                        Toast.makeText(getActivity(), "Unexpected Error, Please try again", Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    /**
     * This method makes a fragment transaction to open detail fragment view
     *
     * @param position
     */
    private void switchFragment(int position) {
        FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", mTitleList.get(position));
        bundle.putString("imageUrl", mImageList.get(position));
        detailFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.fragment_place, detailFragment, "detailFragment");
        fragmentTransaction.addToBackStack(detailFragment.getClass().getName());
        fragmentTransaction.commit();
    }

}
