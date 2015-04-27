package com.example.chonlaphoom.fullcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link com.example.chonlaphoom.fullcourse.Favorite.OnFragmentInteractionListener}
 * interface.
 */
public class Favorite extends android.support.v4.app.Fragment implements AbsListView.OnItemClickListener {
    private List exampleListItemList; // at the top of your fragment list
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;

    //############################TAN List Item###################################
    private int[] flag = new int[]{
            R.drawable.food_1,
            R.drawable.food_2,
            R.drawable.food_3,
            R.drawable.food_4,
            R.drawable.food_5,
            R.drawable.food_6,
            R.drawable.food_7,
            R.drawable.food_8,
            R.drawable.food_9,
            R.drawable.food_10,
            R.drawable.food_11,
            R.drawable.food_12,
            R.drawable.food_13,
            R.drawable.food_14
    };

    private int[] shadow = new int[]{
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
            R.drawable.shadow,
    };

    private String[] title = new String[]{
            "Test1 jaa",
            "Test2 jaa",
            "Test3 jaa",
            "Test4 jaa",
            "Test5 jaa",
            "Test6 jaa",
            "Test7 jaa",
            "Test8 jaa",
            "Test9 jaa",
            "Test10 jaa",
            "Test11 jaa",
            "Test12 jaa",
            "Test13 jaa",
            "Test14 jaa"
    };
    //#######################################################################

    // TODO: Rename and change types of parameters
    public static Favorite newInstance(String param1, String param2) {
        Favorite fragment = new Favorite();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Favorite() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exampleListItemList = new ArrayList();

        for(int i=0;i!=title.length;i++){
            exampleListItemList.add(new FAItemList(title[i]));

        }
        /*
        exampleListItemList.add(new FCItemList("FCEX 1"));
        exampleListItemList.add(new FCItemList("FCEX 2"));
        exampleListItemList.add(new FCItemList("FCEX 3"));
        exampleListItemList.add(new FCItemList("FuckFCEX"));
        exampleListItemList.add(new FCItemList("FCEX 4"));
        exampleListItemList.add(new FCItemList("FCEX 5"));
        exampleListItemList.add(new FCItemList("FCEX 6"));
        mAdapter = new FCAdapterlist(getActivity(), exampleListItemList);
        */
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_grid, container, false);

        //###################################TAN Adaptor##############################################
        String[] from = {"flag2","shadow","text"};
        int[] to = {R.id.fc_pic,R.id.fc_shadow,R.id.fc_text};
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<14;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("flag2", Integer.toString(flag[i]));
            hm.put("shadow", Integer.toString(shadow[i]));
            hm.put("text", title[i]);
            aList.add(hm);
        }
        SimpleAdapter TanAdapter = new SimpleAdapter(getActivity().getBaseContext(),aList,R.layout.favorite_list_layout,from,to);
        //###########################################################################################


        // Set the adapter , ****Choose between TanAdapter/mAdapter*****
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        //((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);
        ((AdapterView<ListAdapter>) mListView).setAdapter(TanAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

 /*   @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FAItemList item = (FAItemList) this.exampleListItemList.get(position);
        Toast.makeText(getActivity(), item.getItemTitle() + " Clicked!"
                , Toast.LENGTH_SHORT).show();
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
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
        public void onFragmentInteraction(String id);

    }

}
