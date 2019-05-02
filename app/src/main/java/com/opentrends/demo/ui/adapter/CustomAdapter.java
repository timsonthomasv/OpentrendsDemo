/*
* ===========================================================================
* Copyright 2016 OpenTrends
* All Rights Reserved
* ===========================================================================
*
* File Name: CustomAdapter.java
*
*
* Version Number: 0.0.0.1
*
* Created Date: 15 Mar 2016
*
*/
package com.opentrends.demo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.opentrends.demo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private static LayoutInflater inflater;
    Context context;

    /**
     * This attribute stores the text to be displayed
     */
    List<String> titleText;

    /**
     * This attribute stores the list of image url
     */
    List<String> images;


    public CustomAdapter(Context ctx, List<String> title, List<String> links) {

        titleText = title;
        context = ctx;
        images = links;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return titleText.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();

        //setup view holder row with thumbnail image and text
        View rowView = inflater.inflate(R.layout.listview_layout, null);
        holder.listTitleView = (TextView) rowView.findViewById(R.id.list_title_view);
        holder.listImageView = (ImageView) rowView.findViewById(R.id.list_image_view);

        //Set title text
        holder.listTitleView.setText(titleText.get(position));

        //Load image from url with Picasso
        Picasso.with(context)
                .load(images.get(position))
                .into(holder.listImageView);

        return rowView;
    }

    public class Holder {
        TextView listTitleView;
        ImageView listImageView;
    }
}