package com.example.saleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    public ArrayList<Product> productList = new ArrayList<Product>();
    public ArrayList<Product> productList1 = new ArrayList<Product>();
    AdapterProduct adapterProduct;
    ListView lvProduct;
    Button btnOrder;
    TextView tvTotal, tvProductName, tvQuantity, tvTotalPrice, tvMess;
    RelativeLayout rlCart;
    int i = 0;
    int countTotal = 0;
    int countCoca = 0, countPepsi = 0, countFanta = 0, count7UP = 0, countSprite = 0,
            totalPrice = 0;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnOrder = findViewById(R.id.btnOrder);
        lvProduct = findViewById(R.id.lvProduct);
        tvTotal = findViewById(R.id.tvTotal);
        tvQuantity = findViewById(R.id.tvQuantity);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        rlCart = findViewById(R.id.rlCart);
        tvMess = findViewById(R.id.tvMess);

        productList.add(new Product("Cocacola", ""));
        productList.add(new Product("Pepsi", ""));
        productList.add(new Product("Fanta", ""));
        productList.add(new Product("7UP", ""));
        productList.add(new Product("Sprite", ""));

        adapterProduct = new AdapterProduct(productList);
        lvProduct.setAdapter(adapterProduct);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                countTotal++;
                totalPrice += 10;
                tvTotalPrice.setText(String.valueOf(totalPrice) + "$");
                tvTotal.setText(String.valueOf(countTotal));
                if (productList.get(i).getName().equals("Cocacola")) {
                    countCoca++;
                    productList.get(i).setQuantity(String.valueOf(countCoca));
                } else if (productList.get(i).getName().equals("Pepsi")) {
                    countPepsi++;
                    productList.get(i).setQuantity(String.valueOf(countPepsi));
                } else if (productList.get(i).getName().equals("7UP")) {
                    count7UP++;
                    productList.get(i).setQuantity(String.valueOf(count7UP));
                } else if (productList.get(i).getName().equals("Sprite")) {
                    countSprite++;
                    productList.get(i).setQuantity(String.valueOf(countSprite));
                } else if (productList.get(i).getName().equals("Fanta")) {
                    countFanta++;
                    productList.get(i).setQuantity(String.valueOf(countFanta));
                } else {
                    Toast.makeText(getBaseContext(), "No item", Toast.LENGTH_LONG).show();
                }
            }

        });

        rlCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PaymentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("productList", productList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMess.setText("Thank you! Your order is sent to restaurant!");
                tvTotalPrice.setText("");
                tvTotal.setText("");
                countTotal = 0; countCoca = 0;
                countPepsi = 0; countFanta = 0;
                count7UP = 0; countSprite = 0;
                totalPrice = 0;

                    for(Product product : productList){
                        if (product.getQuantity().equals("")){

                        }else{
                            product.setQuantity("");
                        }


                }

            }
        });


    }
}
