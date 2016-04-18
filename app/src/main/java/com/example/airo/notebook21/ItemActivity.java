package com.example.airo.notebook21;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemActivity extends Fragment {

    private int pos = 0, fr = 0;
    private FragmentTransaction fragmentTransaction;

    public ItemActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.activity_item, null);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            pos = bundle.getInt("tag");
            fr = bundle.getInt("fragment");
        }

        if (container != null) {
            container.removeAllViews();
        }

        final TextView nameTxt = (TextView) rootView.findViewById(R.id.textView0);
        final ImageView img = (ImageView) rootView.findViewById(R.id.imageView0);
        final CheckBox chb1 = (CheckBox) rootView.findViewById(R.id.checkBox1);
        final CheckBox chb2 = (CheckBox) rootView.findViewById(R.id.checkBox2);
        final CheckBox chb3 = (CheckBox) rootView.findViewById(R.id.checkBox3);
        final Button btn = (Button) rootView.findViewById(R.id.button);

        nameTxt.setText(MainActivity.statiItems.get(pos).getName());
        img.setImageResource(MainActivity.statiItems.get(pos).getImg());
        chb1.setChecked(MainActivity.statiItems.get(pos).isGroup1());
        chb2.setChecked(MainActivity.statiItems.get(pos).isGroup2());
        chb3.setChecked(MainActivity.statiItems.get(pos).isGroup3());
        chb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    MainActivity.statiItems.get(pos).setGroup1(true);
                } else {
                    MainActivity.statiItems.get(pos).setGroup1(false);
                }
            }
        });
        chb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    MainActivity.statiItems.get(pos).setGroup2(true);
                } else {
                    MainActivity.statiItems.get(pos).setGroup2(false);
                }
            }
        });
        chb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    MainActivity.statiItems.get(pos).setGroup3(true);
                } else {
                    MainActivity.statiItems.get(pos).setGroup3(false);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (fr) {
                    case 0:
                        Home home = new Home();
                        fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_home, home);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        BlankFragment1 blankFragment1 = new BlankFragment1();
                        fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.blankFragment1, blankFragment1);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case 2:
                        BlankFragment2 blankFragment2 = new BlankFragment2();
                        fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.blankFragment2, blankFragment2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case 3:
                        BlankFragment3 blankFragment3 = new BlankFragment3();
                        fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.blankFragment3, blankFragment3);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                }
            }

        });




        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
