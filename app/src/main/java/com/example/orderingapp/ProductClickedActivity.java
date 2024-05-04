package com.example.orderingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.orderingapp.fragments.FavoritesFragment;
import com.example.orderingapp.models.ProductStaticModel;

public class ProductClickedActivity extends AppCompatActivity {

    TextView tv_name, tv_price, tv_desc;
    ImageView iv_back, iv_head, iv_fav, iv_favs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_clicked);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initValues();


        tv_name.setText(ProductStaticModel.getName());
        tv_price.setText(String.valueOf(ProductStaticModel.getPrice()));
        tv_desc.setText(ProductStaticModel.getDescription());
        iv_head.setImageResource(ProductStaticModel.getImgRID());
        setListener();

    }

    private void initValues()
    {
        tv_name = findViewById(R.id.tvProductName);
        tv_price = findViewById(R.id.tvProductPrice);
        tv_desc = findViewById(R.id.tvProductDescription);

        iv_back = findViewById(R.id.ivBack);
        iv_head = findViewById(R.id.vTemp);
        iv_fav = findViewById(R.id.ivFav);
        iv_favs = findViewById(R.id.ivFav1);

    }

    private void setListener()
    {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        iv_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_fav.setVisibility(View.GONE);

                iv_favs.setVisibility(View.VISIBLE);






            }
        });


        iv_favs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_fav.setVisibility(View.VISIBLE);

                iv_favs.setVisibility(View.GONE);

                

            }
        });





    }

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}