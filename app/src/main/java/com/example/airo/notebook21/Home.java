package com.example.airo.notebook21;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    private ListView lv;
    private SearchView sv;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, null);


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
                bundle.putInt("fragment",0);
                itemActivity.setArguments(bundle);
                FragmentTransaction ft  = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_home, itemActivity);
                ft.commit();
            }
        });

        return rootView;
    }

    private ArrayList<Item> getItems() {
        return MainActivity.statiItems;
    }


}
