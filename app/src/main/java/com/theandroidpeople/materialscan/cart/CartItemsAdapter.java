package com.theandroidpeople.materialscan.cart;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.theandroidpeople.materialscan.R;
import com.theandroidpeople.materialscan.expandablelist.ExpandableListItem;
import com.theandroidpeople.materialscan.expandablelist.ExpandingLayout;

import java.util.List;

public class CartItemsAdapter extends ArrayAdapter<ExpandableListItem> {

    private List<ExpandableListItem> data;

    public CartItemsAdapter(Context context, List<ExpandableListItem> data) {
        super(context, R.layout.list_view_item, data);
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ExpandableListItem object = data.get(position);

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_view_item, parent, false);
        }

        RelativeLayout relativeLayout = (RelativeLayout) (convertView.findViewById(R.id.item_linear_layout));
        RelativeLayout.LayoutParams linearLayoutParams = new RelativeLayout.LayoutParams
                (AbsListView.LayoutParams.MATCH_PARENT, object.getCollapsedHeight());
        relativeLayout.setLayoutParams(linearLayoutParams);

        boolean hasSavings = object.getCartItem().hasSavings();

        ImageView dollarView = (ImageView) convertView.findViewById(R.id.dollar_image_view);
        dollarView.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.dollar_orange, null));
        if (hasSavings) {
            dollarView.setVisibility(View.VISIBLE);
        } else {
           dollarView.setVisibility(View.INVISIBLE);
        }

        ImageView piggyView = (ImageView) convertView.findViewById(R.id.piggy_image_view);
        piggyView.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.piggy_whole_orange, null));
        if (hasSavings) {
            piggyView.setVisibility(View.VISIBLE);
        } else {
            piggyView.setVisibility(View.GONE);
        }

        TextView titleView = (TextView) convertView.findViewById(R.id.title_view);
        titleView.setText(object.getCartItem().getDescription());

        TextView textView = (TextView) convertView.findViewById(R.id.text_view);
        textView.setText("Savings: $" + String.format("%.2f", object.getCartItem().getSavings()));
        if (hasSavings) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }

        TextView priceView = (TextView) convertView.findViewById(R.id.price_view);
        priceView.setText("$" +  String.format("%.2f", object.getCartItem().getFinalPrice()));

        convertView.setLayoutParams(new ListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                AbsListView.LayoutParams.WRAP_CONTENT));

        ExpandingLayout expandingLayout = (ExpandingLayout) convertView.findViewById(R.id.expanding_layout);
        expandingLayout.setExpandedHeight(object.getExpandedHeight());
        expandingLayout.setSizeChangedListener(object);

        if (!object.isExpanded()) {
            expandingLayout.setVisibility(View.GONE);
        } else {
            expandingLayout.setVisibility(View.VISIBLE);
        }

        return convertView;
    }



}