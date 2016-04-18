package com.example.airo.notebook21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Airo on 17.04.2016.
 */
public class Adapter extends BaseAdapter implements Filterable{

    private Context c;
    private ArrayList<Item> items;
    private ArrayList<Item> filteritems;
    private CustomFilter filter;


    public Adapter(Context c) {
        this.c = c;
    }

    public Adapter(Context c, ArrayList<Item> items) {
        this.c = c;
        this.items = items;
        this.filteritems = items;
    }




    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView==null){
            convertView=inflater.inflate(R.layout.model, null);
        }
        TextView nameTxt=(TextView) convertView.findViewById(R.id.textView);
        ImageView img=(ImageView) convertView.findViewById(R.id.imageView);

        nameTxt.setText(items.get(position).getName());
        img.setImageResource(items.get(position).getImg());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(filter==null){
            filter=new CustomFilter();
        }

        return filter;
    }

    class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            if (constraint!=null&&constraint.length()>0){
                constraint=constraint.toString().toUpperCase();
                ArrayList<Item> filter = new ArrayList<Item>();
                for (int i = 0; i < filteritems.size(); i++) {
                    if(filteritems.get(i).getName().toUpperCase().contains(constraint)){
                        Item item = new Item(filteritems.get(i).getName(),filteritems.get(i).getImg());
                        filter.add(item);


                    }
                    
                }
                results.count=filter.size();
                results.values=filter;

            }else {
                results.count=filteritems.size();
                results.values=filteritems;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            items= (ArrayList<Item>) results.values;
            notifyDataSetChanged();


        }
    }

}
