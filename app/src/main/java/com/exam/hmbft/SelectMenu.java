package com.exam.hmbft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SelectMenu extends AppCompatActivity {


    private ListView lstMenu;
    private Button btnConfirmOrder;
    public static SparseBooleanArray checked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_menu);
        lstMenu = findViewById(R.id.lstMenu);
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder);
        lstMenu.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, MenuHelper.getName());
        lstMenu.setAdapter(adapter);
        btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checked = lstMenu.getCheckedItemPositions();
                Intent intent = new Intent(SelectMenu.this, MenuCartActivty.class);
                startActivity(intent);
            }
        });

        lstMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });


    }
}
