package com.example.btvnbuoi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        String category = getIntent().getStringExtra("CATEGORY");
        setTitle(category);
        ListView listView = findViewById(R.id.foodListView);
        List<FoodItem> foodItems = getFoodItemsForCategory(category);
        FoodAdapter adapter = new FoodAdapter(this, foodItems);
        listView.setAdapter(adapter);
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodListActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Đóng Activity hiện tại
            }
        });
    }

    private List<FoodItem> getFoodItemsForCategory(String category) {
        List<FoodItem> foodItems = new ArrayList<>();

        // Add food items based on the category
        if (category.equals("Món mặn")) {
            foodItems.add(new FoodItem("Sườn nướng", 12000, 15000, R.drawable.ic_person, 4));
            foodItems.add(new FoodItem("Gà kho", 30000, 50000, R.drawable.gakho, 5));
            foodItems.add(new FoodItem("Cá chiên", 30000, 50000, R.drawable.cachien, 5));
            foodItems.add(new FoodItem("Thịt kho trứng", 40000, 60000, R.drawable.thitkho, 4));
            foodItems.add(new FoodItem("Bún bò Huế", 30000, 40000, R.drawable.bun, 4));
            foodItems.add(new FoodItem("Phở Hà Lội", 50000, 60000, R.drawable.pho, 4));
            foodItems.add(new FoodItem("Trứng chiên", 50000, 60000, R.drawable.trungchien, 4));

        } else if (category.equals("Món canh")) {
            foodItems.add(new FoodItem("Canh bí đỏ", 12000, 15000, R.drawable.canhbido, 4));
            foodItems.add(new FoodItem("Canh cua", 30000, 50000, R.drawable.canhcua, 5));
            foodItems.add(new FoodItem("Canh Khoai Mỡ", 30000, 50000, R.drawable.canhkhoaimo, 5));
            foodItems.add(new FoodItem("Canh Khổ qua", 40000, 60000, R.drawable.canhkhoqua, 4));
            foodItems.add(new FoodItem("Canh Rau Má", 30000, 40000, R.drawable.canhrauma, 4));
            foodItems.add(new FoodItem("Canh mướp", 50000, 60000, R.drawable.canhmuop, 4));
        } else if (category.equals("Món xào")) {
            foodItems.add(new FoodItem("Rau xào bò", 12000, 15000, R.drawable.xaobo, 4));
            foodItems.add(new FoodItem("Rau xào lòng", 30000, 50000, R.drawable.xaolong, 5));
            foodItems.add(new FoodItem("Rau xào mực", 30000, 50000, R.drawable.xaomuc, 5));
            foodItems.add(new FoodItem("Rau xào nấm", 40000, 60000, R.drawable.xaonam, 4));
            foodItems.add(new FoodItem("Rau xào", 30000, 40000, R.drawable.xaorau, 4));
            foodItems.add(new FoodItem("Rau xào trứng non", 50000, 60000, R.drawable.xaotrungnon, 4));
        }

        return foodItems;
    }
}
