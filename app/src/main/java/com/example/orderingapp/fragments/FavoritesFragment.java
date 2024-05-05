package com.example.orderingapp.fragments;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orderingapp.AccountsStaticModel;
import com.example.orderingapp.DBHelper;
import com.example.orderingapp.R;
import com.example.orderingapp.adapters.CartAdapter;
import com.example.orderingapp.models.CartModel;
import com.example.orderingapp.models.ProductStaticModel;

import java.util.ArrayList;
import java.util.List;


public class FavoritesFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragments_cart_temp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<CartModel> cartModelList = new ArrayList<>();
        DBHelper dbHelper = new DBHelper(getContext());

        Cursor cursor = dbHelper.getCart(AccountsStaticModel.getAccount_id());

        while(cursor.moveToNext())
        {
            int cart_id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            int product_id = cursor.getInt(cursor.getColumnIndexOrThrow("product_id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
            int imgRID = cursor.getInt(cursor.getColumnIndexOrThrow("imgRID"));

            Log.d("Debugging", "Cart: " + name);

            cartModelList.add(new CartModel(cart_id, product_id, name,  price, 0, imgRID));
        }

        CartAdapter adapter = new CartAdapter(getContext());
        adapter.setCartList(cartModelList);
        RecyclerView rv = view.findViewById(R.id.rvCart);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


    }

}