package com.tushar.jape.wastemanagementapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    ArrayList<Request> requestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        initialize();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initialize() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        requestList = new ArrayList<>();

        adapter = new RecyclerAdapter(requestList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        generateList();

        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void generateList() {
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));
        requestList.add(new Request("23/9", "Pic Link", "Type", 5, 6, 1));

        adapter.notifyDataSetChanged();
    }
}
