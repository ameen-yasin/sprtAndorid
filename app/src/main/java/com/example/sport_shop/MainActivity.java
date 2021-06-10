package com.example.sport_shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sport_shop.Activity.cart;
import com.example.sport_shop.Adapter.ItemAdapter;
import com.example.sport_shop.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    List<Item> itemList;
    ItemAdapter itemAdapter;
    public static Item item = new Item(R.drawable.d1, "dumbles", "200.0", "5");
    public static Item item1 = new Item(R.drawable.shirt2, "tank", "100.0", "4");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        myRecyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.hasFixedSize();

//        Item item = new Item(R.drawable.d1, "dumbles", "200.0", "5");
//        Item item1 = new Item(R.drawable.shirt2, "tank", "100.0", "4");
        itemList.add(item);
        itemList.add(item1);

        itemAdapter = new ItemAdapter(itemList, this);
        myRecyclerView.setAdapter(itemAdapter);


    }

    public void showCartInfo(View view) {
        Intent intent = new Intent(this, cart.class);
        startActivity(intent);

    }
}