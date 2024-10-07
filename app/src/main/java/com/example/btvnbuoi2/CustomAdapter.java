package com.example.btvnbuoi2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] titles;
    private String[] productCounts;
    private String[] discountCounts;
    private int[] imageResources;

    public CustomAdapter(Context context, String[] titles, String[] productCounts, String[] discountCounts) {
        this.context = context;
        this.titles = titles;
        this.productCounts = productCounts;
        this.discountCounts = discountCounts;
    }

    public CustomAdapter(Context context, String[] titles, String[] productCounts, String[] discountCounts, int[] imageResources) {
        this.context = context;
        this.titles = titles;
        this.productCounts = productCounts;
        this.discountCounts = discountCounts;
        this.imageResources = imageResources;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView foodImage = convertView.findViewById(R.id.foodImage);
        TextView categoryTitle = convertView.findViewById(R.id.categoryTitle);
        TextView productCount = convertView.findViewById(R.id.productCount);
        TextView discountCount = convertView.findViewById(R.id.discountCount);
        ImageView arrowIcon = convertView.findViewById(R.id.arrowIcon);


        categoryTitle.setText(titles[position]);
        productCount.setText(productCounts[position]);
        discountCount.setText(discountCounts[position]);


        foodImage.setImageResource(imageResources[position]);

        return convertView;
    }
}
