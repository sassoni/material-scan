package com.theandroidpeople.materialscan.cart;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theandroidpeople.materialscan.R;
import com.theandroidpeople.materialscan.expandablelist.ExpandableListItem;
import com.theandroidpeople.materialscan.expandablelist.ExpandingListView;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CartFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        CartItemsAdapter adapter = new CartItemsAdapter(getActivity(), generateTestData());
        ExpandingListView listView = (ExpandingListView) view.findViewById(R.id.cart_list_view);
        listView.setAdapter(adapter);
        listView.setDivider(null);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private List<ExpandableListItem> generateTestData() {
        List<ExpandableListItem> data = new ArrayList<>();
        data.add(new ExpandableListItem(new CartItem("Coca Cola 6 pack", 10.00f, 0.00f)));
        data.add(new ExpandableListItem(new CartItem("Colgate toothpaste", 2.50f, 1.00f)));
        data.add(new ExpandableListItem(new CartItem("Cheddar Cheese", 6.00f, 0.00f)));
        data.add(new ExpandableListItem(new CartItem("Tomatoes on the vine", 8.25f, 2.40f)));
        data.add(new ExpandableListItem(new CartItem("Cucumbers 4", 2.70f, 0.0f)));
        data.add(new ExpandableListItem(new CartItem("Nutella hazelnut spread", 5.66f, 0.60f)));
        data.add(new ExpandableListItem(new CartItem("Florida orange juice", 3.60f, 0.00f)));
        data.add(new ExpandableListItem(new CartItem("Hood milk 1lt", 1.70f, 0.10f)));
        data.add(new ExpandableListItem(new CartItem("Pepperidge Farm cookies", 3.05f, 0.10f)));
        data.add(new ExpandableListItem(new CartItem("Kellogg's Corn Flakes", 2.50f, 0.00f)));
        data.add(new ExpandableListItem(new CartItem("Tazzo tea berryblossom white", 5.00f, 0.00f)));
        data.add(new ExpandableListItem(new CartItem("Bananas", 1.50f, 0.10f)));
        return data;
    }

}
