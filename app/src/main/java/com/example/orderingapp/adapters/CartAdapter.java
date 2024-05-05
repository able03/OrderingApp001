package com.example.orderingapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderingapp.R;
import com.example.orderingapp.models.CartModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>
{
    private Context context;
    private List<CartModel> cartList;

    public CartAdapter(Context context)
    {
        this.context = context;
    }

    public void setCartList(List<CartModel> cartList)
    {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_cart_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        int pos = position;
        int cart_id = cartList.get(pos).getCart_id();
        int product_id = cartList.get(pos).getProduct_id();
        String product_name = cartList.get(pos).getProduct_name();
        double price = cartList.get(pos).getPrice();


        int imgRID = cartList.get(pos).getImgRID();


        holder.tv_id.setText(String.valueOf(cart_id));
        holder.tv_pid.setText(String.valueOf(product_id));
        holder.tv_name.setText(product_name);
        holder.tv_price.setText(String.valueOf(price));
        holder.iv_img.setImageResource(imgRID);

    }

    @Override
    public int getItemCount()
    {
        return cartList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv_id, tv_pid, tv_name, tv_price;
        private ImageView iv_img;
        private MaterialButton btn_checkout;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tvCartId);
            tv_pid = itemView.findViewById(R.id.tvCartProductId);
            tv_name = itemView.findViewById(R.id.tvCartName);
            tv_price = itemView.findViewById(R.id.tvCartPrice);

            iv_img = itemView.findViewById(R.id.ivCartImg);

            btn_checkout = itemView.findViewById(R.id.btnCartCheckout);
        }
    }
}
