package com.example.saleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity {
    ArrayList<Product> productList;
    AdapterPayment adapterPayment;
    ListView lvProduct;
    ImageView imgBack;
    TextView tvTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        lvProduct = findViewById(R.id.lvProduct);
        imgBack = findViewById(R.id.imgBack);
        tvTotal = findViewById(R.id.tvTotal);
        productList = new ArrayList<>();

        Bundle bundle =getIntent().getExtras();
        productList = bundle.getParcelableArrayList("productList");

        adapterPayment = new AdapterPayment(productList);
        lvProduct.setAdapter(adapterPayment);
        adapterPayment.notifyDataSetChanged();

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("productList", productList);
                Bundle bundle1 = new Bundle();
                bundle1.putString("totalProduct", String.valueOf(tvTotal.getText()));
                intent.putExtras(bundle1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
