package com.exam.hmbft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MenuCartActivty extends AppCompatActivity implements OnSuccessListener {

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
                try {
                    //JSONObject request = new JSONObject();
                    Random rand = new Random();
                    int n = rand.nextInt(500) + 1;
                    JSONArray request = new JSONArray();
                    for (int i = 0; i < lstMenu.size(); i++) {
                        JSONObject jNode = new JSONObject();
                        jNode.put("itemname", lstMenu.get(i).getName());
                        jNode.put("count", lstMenu.get(i).getCount());
                        jNode.put("tableno", MainActivity.tableNo+1);

                        jNode.put("orderno", n);
                        request.put(jNode);
                    }
                    //request.put( node);
                    FoodOrder foodOrder = new FoodOrder();
                    foodOrder.setOnSuccessListener(MenuCartActivty.this, request);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        for (int i = 0; i < MenuHelper.getMenus().size(); i++) {
            if (SelectMenu.checked.get(i)) {
                lstMenu.add(MenuHelper.getMenus().get(MenuHelper.getName()[i]));
            }
        }

        lstSelectedItems.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        lstSelectedItems.setAdapter(new MenuCardAdapter(lstMenu));

    }

    @Override
    public void onSuccess(String result) {
        if (null != result) {
            Intent intent = new Intent(MenuCartActivty.this, ConfirmationActivity.class);
            startActivity(intent);
        }
    }
}
