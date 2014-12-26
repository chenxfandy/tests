package com.kvest.tests.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.kvest.tests.R;

import android.support.v7.widget.RecyclerView;
import com.kvest.tests.ui.adapter.SimpleRecyclerViewAdapter;

/**
 * User: roman
 * Date: 12/26/14
 * Time: 1:31 PM
 */
public class SimpleRecyclerViewActivity extends Activity {
    private static final int DATASET_SIZE = 1000;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SimpleRecyclerViewActivity.class);
        context.startActivity(intent);
    }

    //TODO
    // 1) просмотреть все методы класса
    // 2) Разные LayoutManager
    // 3) Кастомный LayoutManager
    // 4) Анимации
    // 5) Разные адаптеры

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_recycler_view_activity);

        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //create dataset
        String[] dataset = new String[DATASET_SIZE];
        for (int i = 0; i < DATASET_SIZE; ++i) {
            dataset[i] = "Test " + i;
        }

        // specify an adapter (see also next example)
        mAdapter = new SimpleRecyclerViewAdapter(dataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
