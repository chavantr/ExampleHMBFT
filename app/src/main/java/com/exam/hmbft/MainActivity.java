package com.exam.hmbft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private List<String> lstTables = new ArrayList<>();
    private RecyclerView lstTable;
    private TableAdapter tableAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstTable = findViewById(R.id.lstTable);

        lstTable.setLayoutManager(new GridLayoutManager(this, 3));

        for (int i = 1; i <= 30; i++) {

            lstTables.add("Table \n" + i);

        }

        tableAdapter = new TableAdapter(lstTables);

        tableAdapter.setOnItemClickListener(this);

        lstTable.setAdapter(tableAdapter);


    }


    @Override
    public void onItemClick(int id) {
        if (id > 0) {
            Intent intent = new Intent(this, SelectMenu.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
    }
}
