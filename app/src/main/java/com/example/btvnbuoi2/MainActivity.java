package com.example.btvnbuoi2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.myListView);

        int[] imageResources = {R.drawable.ic_person, R.drawable.soup, R.drawable.xao};
        String[] titles = {"Món mặn", "Món canh", "Món xào"};
        String[] productCounts = {"7 sản phẩm", "6 sản phẩm", "6 sản phẩm"};
        String[] discountCounts = {"7 đang giảm giá", "6 đang giảm giá", "6 đang giảm giá"};

        CustomAdapter adapter = new CustomAdapter(this, titles, productCounts, discountCounts, imageResources);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                intent.putExtra("CATEGORY", titles[position]);
                startActivity(intent);
            }
        });
    }
}