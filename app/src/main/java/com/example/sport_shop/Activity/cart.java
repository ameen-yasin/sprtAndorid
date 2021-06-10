package com.example.sport_shop.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sport_shop.Adapter.CartAddapter;
import com.example.sport_shop.CheckOut;
import com.example.sport_shop.Model.Item;
import com.example.sport_shop.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class cart extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String FLAG = "FLAG";
    RecyclerView cartRcyclerView;
    List<Item> cartList;
    CartAddapter cartAddapter;
    private Button checkout;
    private boolean flag = false;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();

        cartRcyclerView = findViewById(R.id.recyclerView_cart);
        cartList = new ArrayList<>();

        cartRcyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartRcyclerView.hasFixedSize();

        setUpViews();
        setupSharedPrefs();
        fetchData();

        cartAddapter = new CartAddapter(cartList);
        cartRcyclerView.setAdapter(cartAddapter);


    }

    private void setUpViews() {
        checkout = findViewById(R.id.check_out_btn);
    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    public void checkOut(View view) {
        Intent intent = new Intent(this, CheckOut.class);
        startActivity(intent);
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
                System.out.println(str0);
                Item item = gson.fromJson(str0, Item.class);
                cartList.add(item);
            }
        } else {
            Toast.makeText(this, "No data Yet", Toast.LENGTH_SHORT).show();
        }
    }
}

