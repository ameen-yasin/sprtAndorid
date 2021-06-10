package com.example.sport_shop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sport_shop.Model.Item;
import com.example.sport_shop.R;
import com.example.sport_shop.Activity.itemDetails;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private List<Item> itemList;
    private Context context;

    public ItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemImage.setImageResource(item.getImage());
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText(item.getPrice());
        holder.itemRate.setText(item.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, itemDetails.class);
                int img = item.getImage();
                String name = item.getName();
                String price = item.getPrice();
                String rate = item.getRating();

                intent.putExtra("NAME",name);
                intent.putExtra("PRICE",price);
                intent.putExtra("RATE",rate);
                intent.putExtra("IMAGE",img);

                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;
        TextView itemRate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_img);
            itemName =itemView.findViewById(R.id.name);
            itemPrice =itemView.findViewById(R.id.price);
            itemRate =itemView.findViewById(R.id.rate);
        }
    }
}
