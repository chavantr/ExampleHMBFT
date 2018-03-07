package com.exam.hmbft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MenuCartActivty extends AppCompatActivity {

    private RecyclerView lstSelectedItems;
    private List<Menu> lstMenu = new ArrayList<>();
    private Button btnOrderBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cart_activty);
        lstSelectedItems = findViewById(R.id.lstSelectedItems);
        btnOrderBook = findViewById(R.id.btnBookOrder);
        btnOrderBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCartActivty.this, ConfirmationActivity.class);
                startActivity(intent);
            }
        });
        for (int i = 0; i < SelectMenu.checked.size(); i++) {
            if (SelectMenu.checked.valueAt(i)) {
                lstMenu.add(MenuHelper.getMenus().get(MenuHelper.getName()[i]));
            }
        }

        lstSelectedItems.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        lstSelectedItems.setAdapter(new MenuCardAdapter(lstMenu));

    }
}
