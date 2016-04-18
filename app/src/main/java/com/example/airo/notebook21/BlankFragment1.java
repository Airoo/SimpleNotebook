package com.example.airo.notebook21;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {

    private ListView lv;
    private SearchView sv;

    public BlankFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank_fragment1, null);


        lv = (ListView) rootView.findViewById(R.id.listView);
        sv = (SearchView) rootView.findViewById(R.id.searchView);

        final Adapter adapter = new Adapter(getActivity(), getItems());
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemActivity itemActivity= new ItemActivity();
                Bundle bundle = new Bundle();
                bundle.putInt("tag", getItems().get(position).getId());
                bundle.putInt("fragment",1);
                itemActivity.setArguments(bundle);
                FragmentTransaction ft  = getFragmentManager().beginTransaction();
                ft.replace(R.id.blankFragment1, itemActivity);
                ft.commit();
            }
        });

        return rootView;
    }

    private ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList();
        Item m;
        for (int i = 0; i < MainActivity.statiItems.size() ; i++) {
            if(MainActivity.statiItems.get(i).isGroup1()==true) {
                m = new Item(MainActivity.statiItems.get(i).getId(), MainActivity.statiItems.get(i).getName(),MainActivity.statiItems.get(i).getImg(),MainActivity.statiItems.get(i).isGroup1(),MainActivity.statiItems.get(i).isGroup2(),MainActivity.statiItems.get(i).isGroup3());
                items.add(m);
            }
        }
        return items;
    }
}
