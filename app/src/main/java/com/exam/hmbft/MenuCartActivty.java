package com.exam.hmbft;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class MenuCartActivty extends AppCompatActivity {

    private RecyclerView lstSelectedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cart_activty);
        lstSelectedItems = findViewById(R.id.lstSelectedItems);

    }
}
