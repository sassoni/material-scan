package com.theandroidpeople.materialscan;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.theandroidpeople.materialscan.cart.CartFragment;
import com.theandroidpeople.materialscan.offers.OffersFragment;
import com.theandroidpeople.materialscan.shoppinglist.ShoppingListFragment;

import java.util.Locale;

/**
 * Created by cchaleva on 2/6/2015.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CartFragment.newInstance("a", "b");
            case 1:
                return OffersFragment.newInstance("a", "b");
            default:
                return ShoppingListFragment.newInstance("a", "b");
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return context.getString(R.string.cart_tab_title).toUpperCase(l);
            case 1:
                return context.getString(R.string.offers_tab_title).toUpperCase(l);
            case 2:
                return context.getString(R.string.shopping_list_tab_title).toUpperCase(l);
        }
        return null;
    }
}
