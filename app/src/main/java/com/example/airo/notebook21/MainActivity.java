package com.example.airo.notebook21;

import android.app.SearchManager;
import android.content.Context;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerlayout;
    private ListView navList;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    public static ArrayList<Item> statiItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navList = (ListView) findViewById(R.id.navlist);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, R.string.opendrawer, R.string.closedrawer);
        drawerlayout.setDrawerListener(actionBarDrawerToggle);
        ArrayList<String> navArray = new ArrayList<String>();
        navArray.add("Все");
        navArray.add("Группа 1");
        navArray.add("Группа 2");
        navArray.add("Группа 3");
        navArray.add("О программе");
        navArray.add("Выход");
        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, navArray);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        fragmentManager = getSupportFragmentManager();

        loadSelection(0);

        statiItems = new ArrayList<>();
        statiItems.add(new Item(0,"Ананас", R.drawable.anans, false, false, false));
        statiItems.add(new Item(1, "Яблоко", R.drawable.apple, true, false, false));
        statiItems.add(new Item(2, "Арбуз", R.drawable.arbuz, true, false, false));
        statiItems.add(new Item(3, "Перец", R.drawable.balgarperec, false, true, false));
        statiItems.add(new Item(4, "Банан", R.drawable.banan, false, true, false));
        statiItems.add(new Item(5, "Вишня", R.drawable.cherry, false, true, false));
        statiItems.add(new Item(6, "Киви", R.drawable.kivi, false, false, true));
        statiItems.add(new Item(7, "Кукуруза", R.drawable.kukuruza, false, false, true));
        statiItems.add(new Item(8, "Лемон", R.drawable.lemon, true, false, true));
        statiItems.add(new Item(9, "Тыква", R.drawable.tikva, false, false, true));
        statiItems.add(new Item(10, "Томат", R.drawable.tomat, false, false, false));
        statiItems.add(new Item(11, "Виноград", R.drawable.vinograd, false, false, false));
        statiItems.add(new Item(12, "Земляника", R.drawable.zeml, false, false, false));
    }

    private void loadSelection(int i) {
        navList.setItemChecked(i, true);
        switch (i) {
            case 0:
                Home home = new Home();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, home);
                fragmentTransaction.commit();
                break;
            case 1:
                BlankFragment1 blankFragment1 = new BlankFragment1();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, blankFragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case 2:
                BlankFragment2 blankFragment2 = new BlankFragment2();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, blankFragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case 3:
                BlankFragment3 blankFragment3 = new BlankFragment3();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, blankFragment3);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case 4:
                BlankFragment4 blankFragment4 = new BlankFragment4();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, blankFragment4);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case 5:
                finish();
                break;
        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        } else if (id == android.R.id.home) {
            if (drawerlayout.isDrawerOpen(navList)) {
                drawerlayout.closeDrawer(navList);

            } else {
                drawerlayout.openDrawer(navList);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        loadSelection(position);

        drawerlayout.closeDrawer(navList);
    }


}
