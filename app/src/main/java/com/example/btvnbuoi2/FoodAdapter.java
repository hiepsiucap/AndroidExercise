package com.example.btvnbuoi2;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private List<FoodItem> foodItems;

    public FoodAdapter(Context context, List<FoodItem> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
    }

    @Override
    public int getCount() {
        return foodItems.size();
    }

    @Override
    public Object getItem(int position) {
        return foodItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.food_list_item, parent, false);
        }

        FoodItem item = foodItems.get(position);

        ImageView foodImage = convertView.findViewById(R.id.foodImage);
        TextView foodName = convertView.findViewById(R.id.foodName);
        TextView foodPrice = convertView.findViewById(R.id.foodPrice);
        TextView oldPrice = convertView.findViewById(R.id.oldPrice);
        RatingBar ratingBar = convertView.findViewById(R.id.ratingBar);

        foodImage.setImageResource(item.getImageResource());
        foodName.setText(item.getName());
        foodPrice.setText(item.getCurrentPrice() + " đ");
        oldPrice.setText(item.getOldPrice() + " đ");
        oldPrice.setPaintFlags(oldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        ratingBar.setRating(item.getRating());

        if (item.getCurrentPrice() == item.getOldPrice()) {
            oldPrice.setVisibility(View.GONE);
        } else {
            oldPrice.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}