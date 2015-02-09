package com.theandroidpeople.materialscan.cart;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.theandroidpeople.materialscan.CartItemsAdapter;
import com.theandroidpeople.materialscan.R;
import com.theandroidpeople.materialscan.exp.ExpCartItemsAdapter;
import com.theandroidpeople.materialscan.exp.ExpandableListItem;
import com.theandroidpeople.materialscan.exp.ExpandingListView;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    CartItemsAdapter listAdapter;
    ExpandableListView expListView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private final int CELL_DEFAULT_HEIGHT = 200;
    private final int NUM_OF_CELLS = 30;

    private ExpandingListView mListView;

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
        // Required empty public constructor
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

//        expListView = (ExpandableListView) view.findViewById(R.id.cart_list_view);
//        // preparing list data
//        //prepareListData();
//        //listAdapter = new CartItemsAdapter(10/*getActivity(), listDataHeader, listDataChild*/);
//        // setting list adapter
//        //expListView.setAdapter(listAdapter);
//        expListView.setDividerHeight(2);
//        expListView.setGroupIndicator(null);
//        expListView.setClickable(true);
//        CartItemsAdapter adapter = new CartItemsAdapter(5);
//        adapter.setInflater((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE), getActivity());
//        expListView.setAdapter(adapter);
//        //expListView.setOnChildClickListener(getActivity());


        ExpandableListItem[] values = new ExpandableListItem[] {
                new ExpandableListItem("Coca Cola 6 pack", R.drawable.dollar, CELL_DEFAULT_HEIGHT,
                        getResources().getString(R.string.short_lorem_ipsum)),
                new ExpandableListItem("Tampons 10 pack", R.drawable.dollar, CELL_DEFAULT_HEIGHT,
                        getResources().getString(R.string.medium_lorem_ipsum)),
                new ExpandableListItem("Toilet paper", R.drawable.dollar, CELL_DEFAULT_HEIGHT,
                        getResources().getString(R.string.long_lorem_ipsum)),
        };

        List<ExpandableListItem> mData = new ArrayList<ExpandableListItem>();

        for (int i = 0; i < NUM_OF_CELLS; i++) {
            ExpandableListItem obj = values[i % values.length];
            mData.add(new ExpandableListItem(obj.getTitle(), obj.getImgResource(),
                    obj.getCollapsedHeight(), obj.getText()));
        }

        ExpCartItemsAdapter adapter = new ExpCartItemsAdapter(getActivity(), R.layout.list_view_item, mData);

        mListView = (ExpandingListView) view.findViewById(R.id.main_list_view);
        mListView.setAdapter(adapter);
        mListView.setDivider(null);



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

}
