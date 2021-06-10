package com.example.sport_shop.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sport_shop.Model.Item;
import com.example.sport_shop.R;

import java.util.List;

public class CartAddapter extends RecyclerView.Adapter<CartAddapter.MyViewHolder> {
    private List<Item> itemList;

    public CartAddapter(List<Item> itemList) { this.itemList = itemList; }

    @NonNull
    @Override
    public CartAddapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items,parent,false);
        return new CartAddapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAddapter.MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemImage.setImageResource(item.getImage());
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText(item.getPrice());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_img_cart);
            itemName =itemView.findViewById(R.id.name_cart);
            itemPrice =itemView.findViewById(R.id.price_cart);
        }
    }

}




