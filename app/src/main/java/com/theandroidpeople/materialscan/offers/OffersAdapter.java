package com.theandroidpeople.materialscan.offers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.theandroidpeople.materialscan.R;

public class OffersAdapter extends BaseAdapter {

   // private Context context;
    private int offersSize;

    private int[] imageIds = new int[] {
      R.drawable.anytizers,
            R.drawable.canada,
            R.drawable.dog,
            R.drawable.dole,
            R.drawable.grahams,
            R.drawable.granola,
            R.drawable.pirate,
            R.drawable.pizza,
            R.drawable.tyson,
            R.drawable.yogurt
    };

    public OffersAdapter(/*Context context,*/ int offersSize) {
        this.offersSize = offersSize;
        //this.context = context;
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
        ImageView imageView = (ImageView) v.findViewById(R.id.offer_view_image);
        imageView.setImageResource(imageIds[position]);
        return v;
    }
}