package com.theandroidpeople.materialscan;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sassa on 2/9/2015.
 */
public class CartItemsAdapter extends BaseExpandableListAdapter {
    private Activity activity;
    private ArrayList<Object> childtems;
    private LayoutInflater inflater;
    private ArrayList<String> parentItems, child;
    private int size;

    public CartItemsAdapter(/*ArrayList<String> parents, ArrayList<Object> childern*/int size) {
        //this.parentItems = parents;
        //this.childtems = childern;
        this.size = size;
    }

    public void setInflater(LayoutInflater inflater, Activity activity) {
        this.inflater = inflater;
        this.activity = activity;
    }


    @Override
    public int getGroupCount() {
        return size;//parentItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cart_item_details_view, null);
        }
        //((TextView) convertView).setText(parentItems.get(groupPosition));
        //((TextView) convertView).setChecked(isExpanded);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //child = (ArrayList<String>) childtems.get(groupPosition);
        TextView textView = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cart_item_description_view, null);
        }
        textView = (TextView) convertView.findViewById(R.id.cart_description_text);
        //textView.setText(child.get(childPosition));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, /*child.get(childPosition)*/"lol", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
