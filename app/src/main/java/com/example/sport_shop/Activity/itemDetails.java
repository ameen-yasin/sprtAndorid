package com.example.sport_shop.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sport_shop.Model.Item;
import com.example.sport_shop.R;
import com.google.gson.Gson;

import java.util.Map;

public class itemDetails extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String FLAG = "FLAG";
    private TextView txtViewNameDetails;
    private TextView txtViewPriceDetails;
    private TextView txtViewRateDetails;
    private TextView txtViewDescriptionDetails;
    private TextView txtViewCategoryDetails;
    private ImageView txtImgDetails;
    private Button addToCart;
    private boolean flag = false;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String price = intent.getStringExtra("PRICE");
        String rate = intent.getStringExtra("RATE");
//        int img = intent.getIntExtra("IMAGE");

        setUpViews();
        setupSharedPrefs();

        txtViewNameDetails.setText(name);
        txtViewPriceDetails.setText(price);
        txtViewRateDetails.setText(rate);
//        txtViewDescriptionDetails.setText(date);
//        txtViewCategoryDetails.setText(name);
//        txtImgDetails.setImageResource(date);
        checkPrefs(name);


    }

    private void setUpViews() {
        txtViewNameDetails = findViewById(R.id.name_details);
        txtViewPriceDetails = findViewById(R.id.price);
        txtViewRateDetails = findViewById(R.id.rate_details);
        txtViewDescriptionDetails = findViewById(R.id.description);
        txtViewCategoryDetails = findViewById(R.id.category);
        txtImgDetails = findViewById(R.id.item_img_details);
        addToCart = findViewById(R.id.add_to_cart);
    }

    public void onclkAddToCart(View view) {
        String name = txtViewNameDetails.getText().toString();
        String price = txtViewPriceDetails.getText().toString();
        String rate = txtViewCategoryDetails.getText().toString();

        Item item = new Item(0, name, price, rate);
        addToCartShared(item);
    }

    private void addToCartShared(Item item) {
        Gson gson = new Gson();
        String itemString = gson.toJson(item);
        editor.putString(txtViewNameDetails.getText().toString(), itemString);
//        editor.putString(NAME, itemString);
        editor.putBoolean(FLAG, true);
        editor.commit();
//        Toast.makeText(this, "added to shooping car:\n" + itemString,
//                Toast.LENGTH_SHORT).show();
        addToCart.setEnabled(false);

        Toast.makeText(this, "added to shopping cart successfully:",
                Toast.LENGTH_SHORT).show();

    }


    private void checkPrefs(String name) {
        flag = prefs.getBoolean(FLAG, false);
        Gson gson = new Gson();

        String data = prefs.getString(name, null);
        Map<?,?> map = gson.fromJson(data,Map.class);
        String dataName ="";
        if(map != null) {
            dataName = (String) map.get("name");
        }
        if (flag) {
            if(dataName.equals(name))
                addToCart.setEnabled(false);
        }
    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

}