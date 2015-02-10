package com.theandroidpeople.materialscan.offers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.theandroidpeople.materialscan.R;

public class OffersAdapter extends BaseAdapter {

    private int offersSize;

    public OffersAdapter(int offersSize) {
        this.offersSize = offersSize;
    }

    @Override
    public int getCount() {
        return offersSize;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_view, parent, false);
        //ImageView imageView = (ImageView) v.findViewById(R.id.offer_view_image);
        return v;
    }
}