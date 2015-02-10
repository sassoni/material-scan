package com.theandroidpeople.materialscan.shoppinglist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.theandroidpeople.materialscan.R;

import java.util.List;

/**
 * Created by Avatapally on 2/9/15.
 */
public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private List<String> shoppingList;

    public ShoppingListAdapter(List<String> shoppingList){
        this.shoppingList = shoppingList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public CheckBox checkBox;
        public TextView textView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.shopping_list_row_textview);
            checkBox = (CheckBox) v.findViewById(R.id.shopping_list_row_checkbox);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(shoppingList.get(position));
    }

    @Override
    public int getItemCount() {
        if (shoppingList == null)
            return 0;
        else
            return shoppingList.size();
    }

}
