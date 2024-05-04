package com.example.orderingapp.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderingapp.LoadItems;
import com.example.orderingapp.ProductClickedActivity;
import com.example.orderingapp.R;
import com.example.orderingapp.SelectListener;
import com.example.orderingapp.adapters.ProductAdapter;
import com.example.orderingapp.models.ProductModel;
import com.example.orderingapp.models.ProductStaticModel;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    ImageButton ib_profile;
    AlertDialog.Builder loginBuilder;
    AlertDialog.Builder registerBuilder;

    RecyclerView rv;
    ProductAdapter adapter;
    LoadItems itemList;

    AlertDialog login;
    AlertDialog register;

    ImageView iv_product;
    TextView tv_details, tv_items_detail;

    CardView cv_electronics, cv_fashion, cv_food;
    SearchView sv;


    List<ProductModel> mainSearchList;
    List<ProductModel> subSearchList = new ArrayList<>();
    List<ProductModel> rvList;

    MaterialButton btn_buy;
    FrameLayout fl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initValues();


        populateRV();


        setListener();
    }

    private void initValues()
    {
        ib_profile = getView().findViewById(R.id.ibProfile);
        loginBuilder = new AlertDialog.Builder(getContext());
        registerBuilder = new AlertDialog.Builder(getContext());
        login = loginBuilder.create();
        register = registerBuilder.create();


        rv = getView().findViewById(R.id.rvItems);
        adapter = new ProductAdapter(getContext());
        itemList = new LoadItems();

        tv_details = getView().findViewById(R.id.tvProductDetails);
        iv_product = getView().findViewById(R.id.ivDetailsIcon);


        cv_electronics = getView().findViewById(R.id.cvElectronics);
        cv_fashion = getView().findViewById(R.id.cvFashion);
        cv_food = getView().findViewById(R.id.cvFood);

        sv = getView().findViewById(R.id.searchView);
        sv.clearFocus();

        mainSearchList = itemList.getAll();
        tv_items_detail = getView().findViewById(R.id.tvItemsLabel);

        btn_buy = getView().findViewById(R.id.btnBuy);


        fl = getView().findViewById(R.id.flDetails);


    }

    private void populateRV()
    {
        rvList = itemList.getAll();
        adapter.setProductList(rvList);
        rv.setAdapter(adapter);
        tv_items_detail.setText("Items");
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void clearRVList()
    {
        rvList.clear();
        adapter.setProductList(rvList);
    }



    private void setListener()
    {
        ib_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
            }
        });

        adapter.setOnItemClickListener(new SelectListener() {
            @Override
            public void itemClicked(ProductModel productModel) {
                int id = productModel.getProduct_id();
                int imgRID = productModel.getImgRID();
                String name = productModel.getName();
                String desc = productModel.getDescription();
                double price = productModel.getPrice();
                int ratings = productModel.getRatings_id();

                iv_product.setVisibility(View.VISIBLE);
                tv_details.setVisibility(View.VISIBLE);
                btn_buy.setVisibility(View.VISIBLE);
                fl.setVisibility(View.VISIBLE);

                iv_product.setImageResource(imgRID);
                tv_details.setText(desc);


                new ProductStaticModel(id, name, desc, price, ratings, imgRID);


            }
        });


        cv_electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filteredList("electronics");
                tv_items_detail.setText("Electronics");
            }
        });


        cv_fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filteredList("fashion");
                tv_items_detail.setText("Fashion");
            }
        });


        cv_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filteredList("food");
                tv_items_detail.setText("Food");
            }
        });



        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchFiltered(s);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(s.isEmpty())
                {
                    clearSubSearchList();
                }
                return true;
            }
        });

        btn_buy.setOnClickListener(click -> {
            Intent intent = new Intent(getContext(), ProductClickedActivity.class);
            startActivity(intent);
        });

    }

    private void searchFiltered(String s)
    {
        for(ProductModel productModel : mainSearchList)
        {
            if(productModel.getName().toLowerCase().contains(s.toLowerCase()))
            {
                subSearchList.add(productModel);
            }
        }

       if(!subSearchList.isEmpty())
       {
           adapter.filteredList(subSearchList);
       }
    }

    private void clearSubSearchList()
    {
        subSearchList.clear();
        adapter.setProductList(subSearchList);
        populateRV();
    }



    private void filteredList(String category)
    {
        switch (category)
        {
            case "electronics": adapter.filteredList(itemList.getElectronicsList()); break;
            case "fashion": adapter.filteredList(itemList.getFashionList()); break;
            case "food": adapter.filteredList(itemList.getFoodList()); break;
            default: break;
        }
    }

    private void showLoginDialog()
    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.login_dialog_layout, null);


        TextView txt = view.findViewById(R.id.tvJumpToRegister);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegisterDialog();

                loginBuilder.setView(null);
            }
        });






        loginBuilder.setView(view);
        loginBuilder.show();
    }

    private void dismissLogin()
    {
        login.dismiss();
    }
    private void dismissRegister()
    {
        register.dismiss();
    }
    private void showRegisterDialog()
    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.register_dialog_layout, null);


        TextView txt = view.findViewById(R.id.tvJumpToLogin);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
                registerBuilder.setView(null);
            }
        });




        registerBuilder.setView(view);
        registerBuilder.show();
    }




}