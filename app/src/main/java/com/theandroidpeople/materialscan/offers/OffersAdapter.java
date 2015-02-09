package com.theandroidpeople.materialscan.offers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.theandroidpeople.materialscan.R;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.ViewHolder> {

    private int offersSize;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.offer_view_image);
        }
    }

    public OffersAdapter(int offersSize) {
        this.offersSize = offersSize;
    }

    @Override
    public OffersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OffersAdapter.ViewHolder viewHolder, int i) {
        // Here we replace the contents of the view
    }

    @Override
    public int getItemCount() {
        return offersSize;
    }
}
