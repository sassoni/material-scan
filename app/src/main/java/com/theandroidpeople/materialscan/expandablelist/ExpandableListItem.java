package com.theandroidpeople.materialscan.expandablelist;

import com.theandroidpeople.materialscan.cart.CartItem;

public class ExpandableListItem implements OnSizeChangedListener {
    private static final int HEIGHT = 130;

    private CartItem item;
    private boolean isExpanded;
    private int collapsedHeight;
    private int expandedHeight;

    public ExpandableListItem(CartItem item) {
        this.item = item;
        this.isExpanded = false;
        this.collapsedHeight = HEIGHT;
        this.expandedHeight = -1;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean isExpanded) {
        this.isExpanded = isExpanded;
    }

    public CartItem getCartItem() {
        return item;
    }

    public String getTitle() {
        return item.getDescription();
    }

    public int getCollapsedHeight() {
        return collapsedHeight;
    }

    public void setCollapsedHeight(int collapsedHeight) {
        this.collapsedHeight = collapsedHeight;
    }

    public String getDetails() {
        return "" + item.getSavings();
    }

    public void setText(String text) {
        //details = text;
    }

    public int getExpandedHeight() {
        return expandedHeight;
    }

    public void setExpandedHeight(int expandedHeight) {
        this.expandedHeight = expandedHeight;
    }

    @Override
    public void onSizeChanged(int newHeight) {
        setExpandedHeight(newHeight);
    }
}

