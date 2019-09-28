package com.example.saleapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterPayment extends BaseAdapter {
    List<Product> productList;

    public AdapterPayment(List<Product> products) {
        this.productList = products;
    }


    @Override
    public int getCount() {

        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = inflater.inflate(R.layout.item_listview, viewGroup, false);

        TextView tvProductName = view.findViewById(R.id.tvProductName);
        TextView tvQuantity = view.findViewById(R.id.tvQuantity);

        Product product = productList.get(i);
        if (productList.get(i).getQuantity().equals("")){
            productList.remove(product.getQuantity().equals(""));
            i--;
        }else {
            tvProductName.setText(product.getName());
            tvQuantity.setText(product.getQuantity());
        }

        return view;
    }
}
