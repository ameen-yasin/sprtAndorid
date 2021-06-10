package com.example.sport_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sport_shop.Activity.cart;
import com.example.sport_shop.Adapter.CartAddapter;
import com.example.sport_shop.Model.Item;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckOut extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String FLAG = "FLAG";
    public static final double TAX = 0.14;
    RecyclerView checkoutRcyclerView;
    private TextView finalePrice;
    List<Item> cechoutList;
    CartAddapter checkAddapter;
    private boolean flag = false;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Double price = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        getSupportActionBar().hide();

        checkoutRcyclerView = findViewById(R.id.recyclerView_cart);
        cechoutList = new ArrayList<>();

        checkoutRcyclerView.setLayoutManager(new LinearLayoutManager(this));
        checkoutRcyclerView.hasFixedSize();

        setUpViews();
        setupSharedPrefs();
        fetchData();

        checkAddapter = new CartAddapter(cechoutList);
        checkoutRcyclerView.setAdapter(checkAddapter);

        if(price.equals(null)){
            finalePrice.setText(0);
        }else {
            double finale = (price)*TAX;
            double finalPrice0 = finale + price;
            finalePrice.setText(new DecimalFormat("##.##").format(finalPrice0)+"");
        }
    }

    private void setUpViews() {
        finalePrice = findViewById(R.id.finale_price);
    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void fetchData() {
//        String str = prefs.getString("NAME", "");
        flag = prefs.getBoolean(FLAG, false);
        if (flag) {
            Map<String, ?> str = prefs.getAll();
            Gson gson = new Gson();
            for (Map.Entry<?, ?> entry : str.entrySet()) {
                if(entry.getKey().equals("FLAG")){
                    continue;
                }
                String str0 = prefs.getString((String) entry.getKey(), "");
//                System.out.println(str0);
                Item item = gson.fromJson(str0, Item.class);
                price = price + Double.parseDouble(item.getPrice());
                cechoutList.add(item);
            }
        } else {
            Toast.makeText(this, "No data Yet", Toast.LENGTH_SHORT).show();
        }
    }
}
